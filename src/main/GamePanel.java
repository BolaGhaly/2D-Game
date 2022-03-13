package main;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

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
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;

	int FPS = 60;

	TileManager tileM = new TileManager(this);
	PlayerControls playerKey = new PlayerControls(this);
	public CollisionChecker collisionChecker = new CollisionChecker(this);
	public Player player;
	Sound sound = new Sound();
	Thread gameThread;

	int playerXCoord = 100;
	int playerYCoord = 100;
	int playerSpeed = 4;

	public ParentObject[] objects = new ParentObject[5];

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

		// plays the sound of index 0
		playSoundLoop(0);
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

		player.update();
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		//draw tiles
		tileM.draw(g2);

		//draw player(s)
		player.draw(g2);

		//draw objects
		for (int i = 0; i < objects.length; i++) {
			if (objects[i] != null) {
				objects[i].draw(g2, this);
			}
		}

		g2.dispose();
	}

	public void playSoundLoop(int i) {
		sound.setFile(i);
		sound.play();
		sound.loop();
	}

	public void stopSound(int i) {
		sound.stop();
	}

	public void playSoundOnce(int i) {
		sound.setFile(i);
		sound.play();

	}
}
