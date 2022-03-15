package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.KeyObject;

public class UI {
	GamePanel gPanel;
	Font arial_font;
	BufferedImage keyImg;
	public boolean messageOn = false;
	public String messageString = "";

	public UI(GamePanel gamePanel) {
		this.gPanel = gamePanel;
		arial_font = new Font("Arial", Font.PLAIN, 28);
		KeyObject key = new KeyObject();
		keyImg = key.objectSprite;
	}

	public void displayMessage(String text) {
		messageString = text;
		messageOn = true;
	}

	public void draw(Graphics2D g2) {
		g2.setFont(arial_font);
		g2.setColor(Color.white);
		g2.drawImage(keyImg, 8, 8, 60, 60, null);
		g2.drawString("x " + gPanel.player.numOfKeys, 68, 42);

		if (messageOn == true) {
			g2.drawString(messageString, gPanel.tileSize / 2, gPanel.tileSize / 2 * 5);
		}
	}

}
