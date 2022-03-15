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

	public UI(GamePanel gamePanel) {
		this.gPanel = gamePanel;
		arial_font = new Font("Poppins", Font.PLAIN, 30);
		KeyObject key = new KeyObject();
		keyImg = key.objectSprite;
	}

	public void draw(Graphics2D g2) {
		g2.setFont(arial_font);
		g2.setColor(Color.white);
		g2.drawImage(keyImg, gPanel.tileSize / 2, gPanel.tileSize / 2, gPanel.tileSize, gPanel.tileSize, null);
		g2.drawString("x " + gPanel.player.numOfKeys, 75, 52);
	}

}
