package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.PlayerControls;

public class Player extends Entity {
	GamePanel gp;
	PlayerControls playerKey;

	public final int screenX;
	public final int screenY;

	public Player(GamePanel gp, PlayerControls playerKey) {

		this.gp = gp;
		this.playerKey = playerKey;

		screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
		screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

		setDefaultValues();
		getPlayerImage();
	}

	public void setDefaultValues() {
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		// speed = 4;
		speed = gp.worldWidth / 600;
		direction = "down";
	}

	public void getPlayerImage() {
		//System.out.println(gp.character);

		if (this.gp.character == "Batman") {
			try {

				spriteSheet = ImageIO.read(getClass().getResourceAsStream("/player/batman/batman_sprite_sheet.png"));
				up1 = this.getSprite(1, 4, 48, 48);
				up2 = this.getSprite(3, 4, 48, 48);
				down1 = this.getSprite(1, 1, 48, 48);
				down2 = this.getSprite(3, 1, 48, 48);
				left1 = this.getSprite(1, 2, 48, 48);
				left2 = this.getSprite(3, 2, 48, 48);
				right1 = this.getSprite(1, 3, 48, 48);
				right2 = this.getSprite(3, 3, 48, 48);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (this.gp.character == "Robin") {
			try {

				spriteSheet = ImageIO
						.read(getClass().getResourceAsStream("/player/robin/robin_nightwing_sprite_sheet.png"));
				up1 = this.getSprite(1, 4, 48, 48);
				up2 = this.getSprite(3, 4, 48, 48);
				down1 = this.getSprite(1, 1, 48, 48);
				down2 = this.getSprite(3, 1, 48, 48);
				left1 = this.getSprite(1, 2, 48, 48);
				left2 = this.getSprite(3, 2, 48, 48);
				right1 = this.getSprite(1, 3, 48, 48);
				right2 = this.getSprite(3, 3, 48, 48);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		//		try{
		//            BufferedImage img = this.getSprite(2, 1, 48, 48);
		//
		//            File robin_character_select = new File("robin_character_select.png");
		//            ImageIO.write(img, "PNG", robin_character_select);
		//            System.out.println("Hello");        }
		//        catch(Exception e){
		//            e.printStackTrace();
		//        }
	}

	public void update() {

		if (playerKey.moveDown == true || playerKey.moveUp == true || playerKey.moveRight == true
				|| playerKey.moveLeft == true) {

			if (playerKey.moveUp == true) {

				direction = "up";
				worldY -= speed;

			}

			else if (playerKey.moveDown == true) {

				direction = "down";
				worldY += speed;

			}

			else if (playerKey.moveLeft == true) {

				direction = "left";
				worldX -= speed;

			}

			else if (playerKey.moveRight == true) {

				direction = "right";
				worldX += speed;

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
		}

	}

	public void draw(Graphics2D g2) {

		//		g2.setColor(Color.white);
		//		
		//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);

		BufferedImage playerSprite = null;

		switch (direction) {
		case "up":
			if (spriteNum == 1) {
				playerSprite = up1;
			}
			if (spriteNum == 2) {
				playerSprite = up2;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				playerSprite = down1;
			}
			if (spriteNum == 2) {
				playerSprite = down2;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				playerSprite = left1;
			}
			if (spriteNum == 2) {
				playerSprite = left2;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				playerSprite = right1;
			}
			if (spriteNum == 2) {
				playerSprite = right2;
			}
			break;
		}

		g2.drawImage(playerSprite, screenX, screenY, gp.tileSize, gp.tileSize, null);

	}
}
