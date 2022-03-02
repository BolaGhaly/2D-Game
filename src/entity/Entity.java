package entity;

import java.awt.image.BufferedImage;

public class Entity {
	
	public int x, y;
	public int speed;
	public BufferedImage spriteSheet, up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;
	public int spriteCounter = 0;
	public int spriteNum = 1;


public BufferedImage getSprite(int column, int row, int width, int height) {
	BufferedImage sprite = spriteSheet.getSubimage( column * width - width, row * height - height, width, height);
	return sprite;
}

}
