package main;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.security.PublicKey;

import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import entity.Entity;
import entity.Player;
import main.PlayerControls;
import object.ParentObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

	//screen settings
	final int originalTileSize = 16; //16x16 tile 
	final int scale = 3;
	public String character = "";

	// map
	public int tileSize = originalTileSize * scale; //48x48 tile
	public int maxScreenColumn = 22;
	public int maxScreenRow = 16;
	public int screenWidth = tileSize * maxScreenColumn; //760 pixels
	public int screenHeight = tileSize * maxScreenRow; //576 pixels

	// world settings
	public final int maxWorldCol = 80;
	public final int maxWorldRow = 68;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	

	//Game State
	public int gameState;
	public final int playState=1;
	public final int pauseState=2;
	public final int dialogueState=3;
	
	
	int FPS = 60;

	TileManager tileM = new TileManager(this);
	public PlayerControls playerKey = new PlayerControls(this);
	public CollisionChecker collisionChecker = new CollisionChecker(this);
	public Player player;
	Sound background_music = new Sound();
	Sound sound_effect = new Sound();
	Thread gameThread;
	public UI ui = new UI(this);

	int playerXCoord = 100;
	int playerYCoord = 100;
	int playerSpeed = 4;

	public ParentObject[] objects = new ParentObject[10];
	public Entity npc[] = new Entity[10];

	public AssetSetter aSetter = new AssetSetter(this);

	public GamePanel(String character) {

		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.blue);
		this.setDoubleBuffered(true);
		this.addKeyListener(playerKey);
		this.setFocusable(true);
		this.character = character;
		this.player = new Player(this, playerKey);
	}

	public void zoomInOut(int i) {

		int oldWorldWidth = tileSize * maxWorldCol;
		tileSize += i;
		int newWorldWidth = tileSize * maxWorldCol;

		player.speed = newWorldWidth / 600;

		int multiplier = newWorldWidth / oldWorldWidth;

		int newPlayerWorldX = player.worldX * multiplier;
		int newPlayerWorldY = player.worldY * multiplier;

		player.worldX = newPlayerWorldX;
		player.worldY = newPlayerWorldY;
	}

	public void setupGame() {
		aSetter.setObject();
		aSetter.setNPC();

		// plays the sound of index 0
		playBackgroundMusic(0);
		
		gameState=playState;
	}

	public void startGameThread() {

		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {

		double drawInterval = 1000000000 / FPS;
		double changeInTime = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		while (gameThread != null) {

			currentTime = System.nanoTime();
			//System.out.println("current time:" + currentTime);

			changeInTime += (currentTime - lastTime) / drawInterval;

			timer += (currentTime - lastTime);

			lastTime = currentTime;

			if (changeInTime >= 1) {

				update();

				repaint();

				changeInTime--;

				drawCount++;

			}

			if (timer >= 1000000000) {
				// System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}

		}
	}

	public void update() {

		
		if(gameState==playState) {
			player.update();
			
			for(int i = 0; i < npc.length; i++) {
				if(npc[i]!=null) {
					npc[i].update();
				}
			}
		}
		if(gameState==pauseState) {
			//nothing
		}
	}

	//draws all elements of the game
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		// DEBUG
		long drawStart = 0;
		if (playerKey.checkDebugTime == true) {
			drawStart = System.nanoTime();
		}

		//draw tiles
		tileM.draw(g2);

		//draw player(s)
		player.draw(g2);

		// UI
		ui.draw(g2);

		//draw objects
		for (int i = 0; i < objects.length; i++) {
			if (objects[i] != null) {
				objects[i].draw(g2, this);
			}
		
		}

		//draw NPCs
		
		for(int i = 0; i < npc.length; i++) {
			if(npc[i]!= null) {	
				npc[i].draw(g2);
			}
		
		// DEBUG
		if (playerKey.checkDebugTime == true) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			System.out.println("Draw Time: " + passed);
		}
		
}

		g2.dispose();
	}

	public void playBackgroundMusic(int i) {
		background_music.setFile(i);
		background_music.play();
		background_music.loop();
	}

	public void stopBackgroundMusic(int i) {
		background_music.stop();
	}

	public void playSoundEffect(int i) {
		sound_effect.setFile(i);
		sound_effect.play();

	}
}
