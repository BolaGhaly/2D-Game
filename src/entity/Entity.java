package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {

	GamePanel gp;
	public int worldX, worldY;
	public double speed;
	public BufferedImage spriteSheet, up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction="down"; 
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
	public int directionChangeCounter = 0;
	String dialogues[] = new String[20]; 
	public BufferedImage objectSprite1, objectSprite2, objectSprite3;
	public String objectName;
	public String entityName;
	public Boolean invincible=false;
	public int invincibleCounter=0;
	
	//character stats
	public int maxHealth;
	public int currentHealth;

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
		gp.collisionChecker.checkEntity(this, gp.npc);
		gp.collisionChecker.checkEntity(this, gp.enemies);
		
		
		
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
	
	public void speak() {
		
		gp.ui.dialogue = dialogues[0];
		
		switch(gp.player.direction) {
		case "up":
			direction = "down";
			break;
		case "down":
			direction = "up";
			break;
		case "left":
			direction = "right";
			break;
		case "right":
			direction = "left";
			break;
		}
	}
	
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
	
	public BufferedImage objectSetup(String spritePath) {
		
		UtilityTool uTool = new UtilityTool();
		BufferedImage sprite = null;
		
		try {
			sprite = ImageIO.read(getClass().getResourceAsStream(spritePath+".png"));
			sprite = uTool.scaleImg(sprite, gp.tileSize, gp.tileSize);
		}catch(IOException e){
			e.printStackTrace();
		}
		return sprite;
	}
	
	

}
