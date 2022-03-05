package main;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import main.PlayerControls;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

	//screen settings
	final int originalTileSize = 16; //16x16 tile 
	final int scale = 3;
	public String character = "";

	public final int tileSize = originalTileSize * scale; //48x48 tile
	public final int maxScreenColumn = 22;
	public final int maxScreenRow = 16;
	public final int screenWidth = tileSize * maxScreenColumn; //760 pixels
	public final int screenHeight = tileSize * maxScreenRow; //576 pixels

	// WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;

	int FPS = 60;

	TileManager tileM = new TileManager(this);
	PlayerControls playerKey = new PlayerControls();
	Thread gameThread;
	public Player player;

	int playerXCoord = 100;
	int playerYCoord = 100;
	int playerSpeed = 4;

	public GamePanel(String character) {

		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.blue);
		this.setDoubleBuffered(true);
		this.addKeyListener(playerKey);
		this.setFocusable(true);
		this.character = character;
		this.player = new Player(this, playerKey);
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

		tileM.draw(g2);

		player.draw(g2);

		g2.dispose();
	}

}
