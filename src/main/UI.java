package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.KeyObject;

public class UI {
	GamePanel gPanel;
	Graphics2D g2;
	Font arial_font;
	Font arial_font_40;
	Font arial_font_60;
//	BufferedImage keyImg;
	public boolean messageOn = false;
	public String messageString = "";
	int messageCounter = 0;
	public boolean gameFinished = false;

	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.00");

	public UI(GamePanel gamePanel) {
		this.gPanel = gamePanel;
		arial_font = new Font("Arial", Font.PLAIN, 28);
		arial_font_40 = new Font("Arial", Font.BOLD, 40);

//		KeyObject key = new KeyObject(gamePanel);
//		keyImg = key.objectSprite;
	}

	public void displayMessage(String text) {
		messageString = text;
		messageOn = true;
	}

	public void draw(Graphics2D g2) {
		
		this.g2=g2;
		g2.setFont(arial_font_40);
		g2.setColor(Color.white);
		if(gPanel.gameState == gPanel.playState) {
			//tbd
		}
		if(gPanel.gameState==gPanel.pauseState) {
			drawPauseScreen();
		}

	}
	
	public void drawPauseScreen() {
		String text = "Paused";
		int y= gPanel.screenHeight/2;
		int x = getHorizontalCenter(text);
		
		g2.drawString(text, x, y);
	}
	
	public int getHorizontalCenter(String text) {
		
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gPanel.screenWidth/2-length/2;
		return x;
	}
}
