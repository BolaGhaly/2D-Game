package main;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import main.PlayerControls;

public class GamePanel extends JPanel implements Runnable{

	//screen settings
	final int originalTileSize = 16; //16x16 tile 
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale; //48x48 tile
	final int maxScreenColumn = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenColumn; //760 pixels
	final int screenHeight = tileSize * maxScreenRow; //576 pixels
	
	int FPS = 60;
	
	PlayerControls playerKey = new PlayerControls();
	Thread gameThread;
	Player player = new Player(this, playerKey);
	
	int playerXCoord = 100;
	int playerYCoord = 100;
	int playerSpeed = 4;
	
	
	public GamePanel () {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.blue);
		this.setDoubleBuffered(true);
		this.addKeyListener(playerKey);
		this.setFocusable(true);
	}

	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		double drawInterval = 1000000000/FPS;
		double changeInTime = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
			
		while(gameThread!=null) {
			
			currentTime = System.nanoTime();
			//System.out.println("current time:" + currentTime);
			
			changeInTime += (currentTime - lastTime)/drawInterval;
			
			timer += (currentTime - lastTime);
			
			lastTime = currentTime;
			
			
			if(changeInTime >= 1) {
				
				update();
		
				repaint(); 
				
				changeInTime--;
				
				drawCount++;
				
			}
			
		
			if( timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
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
		
		Graphics2D g2 = (Graphics2D)g;
		
		player.draw(g2);
		
		g2.dispose();
	}
	 
}
