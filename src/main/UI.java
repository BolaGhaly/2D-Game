	package main;

import java.awt.BasicStroke;
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
	public String dialouge;
	
	

//	double playTime;
//	DecimalFormat dFormat = new DecimalFormat("#0.00");

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
		
		//play state
		this.g2=g2;
		g2.setFont(arial_font_40);
		g2.setColor(Color.white);
		if(gPanel.gameState == gPanel.playState) {
			//tbd
		}
		
		//pause state
		if(gPanel.gameState==gPanel.pauseState) {
			drawPauseScreen();
		}
		
		//dialogue state
		if(gPanel.gameState==gPanel.dialogueState) {
			drawDialogueScreen();
		}

	}
	
	public void drawPauseScreen() {
		String text = "Paused";
		int y= gPanel.screenHeight/2;
		int x = getHorizontalCenter(text);
		
		g2.drawString(text, x, y);
	}
	
	public void drawDialogueScreen() {
		
		int x=gPanel.tileSize*2, 
			y=gPanel.tileSize/2,
			width=gPanel.screenWidth-(gPanel.tileSize*4), 
			height=gPanel.tileSize*3;
		
		drawSubWindow(x, y, width, height);
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,20F));
		x+=gPanel.tileSize;
		y+=gPanel.tileSize;
		g2.drawString(dialouge, x, y);
	}
	
	public void drawSubWindow(int x, int y, int width, int height) {
		
		//color of the sub window
		Color mainColor = new Color(0,0,0,200);
		g2.setColor(mainColor);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		//color of the sub window's border
		Color borderColor = new Color(255, 255, 255);
		g2.setStroke(new BasicStroke(5));
		g2.setColor(borderColor);
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 35, 35);
	}
	
	public int getHorizontalCenter(String text) {
		
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gPanel.screenWidth/2-length/2;
		return x;
	}
}
