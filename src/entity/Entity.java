package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity {

	GamePanel gp;
	public double worldX, worldY;
	public double speed;
	public BufferedImage spriteSheet, up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle solidArea;
	public boolean collisionOn = false;

	public BufferedImage getSprite(int column, int row, int width, int height) {
		BufferedImage sprite = spriteSheet.getSubimage(column * width - width, row * height - height, width, height);
		return sprite;
	}
	
	public Entity(GamePanel gp) {
		this.gp=gp;
	}

}
