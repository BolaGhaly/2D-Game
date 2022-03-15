package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.KeyObject;

public class UI {
	GamePanel gPanel;
	Font arial_font;
	Font arial_font_40;
	Font arial_font_60;
	BufferedImage keyImg;
	public boolean messageOn = false;
	public String messageString = "";
	int messageCounter = 0;
	public boolean gameFinished = false;

	public UI(GamePanel gamePanel) {
		this.gPanel = gamePanel;
		arial_font = new Font("Arial", Font.PLAIN, 28);
		arial_font_40 = new Font("Arial", Font.BOLD, 40);

		KeyObject key = new KeyObject();
		keyImg = key.objectSprite;
	}

	public void displayMessage(String text) {
		messageString = text;
		messageOn = true;
	}

	public void draw(Graphics2D g2) {
		if (gameFinished == true) {

			final String END_GAME_TEXT1 = "You found the treasure!";
			final String END_GAME_TEXT2 = "Congratulations!!";

			// final int END_GAME_TEXT_LEN = END_GAME_TEXT.length();

			// int center_x = gPanel.screenWidth / 2 - END_GAME_TEXT_LEN / 2;
			// int center_y = gPanel.screenHeight / 2 - gPanel.tileSize * 3;

			g2.setFont(arial_font_40);
			g2.setColor(Color.white);

			g2.drawString(END_GAME_TEXT1, 300, 200);

			g2.setFont(arial_font_60);
			g2.setColor(Color.yellow);
			g2.drawString(END_GAME_TEXT2, 350, 250);

			gPanel.gameThread = null;

		} else {
			g2.setFont(arial_font);
			g2.setColor(Color.white);
			g2.drawImage(keyImg, 8, 8, 60, 60, null);
			g2.drawString("x " + gPanel.player.numOfKeys, 68, 42);

			if (messageOn == true) {
				g2.drawString(messageString, gPanel.tileSize / 2, gPanel.tileSize / 2 * 5);

				messageCounter++;

				// 100 frames
				if (messageCounter > 100) {
					messageCounter = 0;
					messageOn = false;
				}
			}
		}

	}

}
