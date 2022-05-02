package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity {

	GamePanel gp;
	public int worldX, worldY;
	public double speed;
	public BufferedImage spriteSheet, up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
	public int directionChangeCounter = 0;

	public BufferedImage getSprite(int column, int row, int width, int height) {
		BufferedImage sprite = spriteSheet.getSubimage(column * width - width, row * height - height, width, height);
		return sprite;
	}
	
	public Entity(GamePanel gp) {
		this.gp=gp;
	}
	
	public void setDirection() {
	
	}
	
	public void update() {
		
		setDirection();
		
		collisionOn = false;
		gp.collisionChecker.checkTile(this);
		gp.collisionChecker.checkObject(this, false);
		gp.collisionChecker.checkPlayer(this);
		
		//if collision is false, entity can move
		if (collisionOn == false) {
			switch (direction) {
			case "up":
				worldY -= speed;
				break;
			case "down":
				worldY += speed;
				break;
			case "left":
				worldX -= speed;
				break;
			case "right":
				worldX += speed;
				break;
			}
		}
		
		spriteCounter++;
		if (spriteCounter > 10) {
			if (spriteNum == 1) {
				spriteNum = 2;
			} else if (spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	};
	
	//drawing the entity
	public void draw(Graphics2D g2) {
		
		BufferedImage entitySprite = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;

		if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
				&& worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
				&& worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
				&& worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			
		
		
		switch (direction) {
		case "up":
			if (spriteNum == 1) {
				entitySprite = up1;
			}
			if (spriteNum == 2) {
				entitySprite = up2;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				entitySprite = down1;
			}
			if (spriteNum == 2) {
				entitySprite = down2;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				entitySprite = left1;
			}
			if (spriteNum == 2) {
				entitySprite = left2;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				entitySprite = right1;
			}
			if (spriteNum == 2) {
				entitySprite = right2;
			}
			break;
		}
		
		g2.drawImage(entitySprite, screenX, screenY, gp.tileSize, gp.tileSize, null);
		}
	}

}
