package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.PlayerControls;
import main.UtilityTool;

public class Player extends Entity {

	PlayerControls playerKey;

	public final int screenX;
	public final int screenY;

	//public int numOfKeys = 0;

	public Player(GamePanel gp, PlayerControls playerKey) {

		super(gp);

		this.playerKey = playerKey;

		screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
		screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

		solidArea = new Rectangle(8, 16, 32, 32);

		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		attackRadius.width= 36;
		attackRadius.height = 36; 

		setDefaultValues();
		getPlayerImage();
	}

	public void setDefaultValues() {
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
//		worldX = gp.tileSize * 10;
//		worldY = gp.tileSize * 13;
		// speed = 4;
		speed = gp.worldWidth / 600;
		direction = "down";
		
		//Player Stats
		maxHealth = 6;
		currentHealth = 6;
		
	}

	public void getPlayerImage() {

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
				attackUp1  = this.getSprite(7, 9, 48, 48);
				attackDown1 = this.getSprite(4, 9, 48, 48);
				attackRight1 = this.getSprite(6, 9, 48, 48);
				attackLeft1 = this.getSprite(5, 9, 48, 48);


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

		if (this.gp.character == "Signal") {
			try {

				spriteSheet = ImageIO.read(getClass().getResourceAsStream("/player/signal/signal_sprite_sheet.png"));
				up1 = this.getSprite(2, 3, 48, 48);
				up2 = this.getSprite(3, 3, 48, 48);
				down1 = this.getSprite(1, 1, 48, 48);
				down2 = this.getSprite(2, 1, 48, 48);
				left1 = this.getSprite(1, 2, 48, 48);
				left2 = this.getSprite(2, 2, 48, 48);
				right1 = this.getSprite(3, 2, 48, 48);
				right2 = this.getSprite(1, 3, 48, 48);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		else if (this.gp.character == "Soldier 1") {
			try {

				spriteSheet = ImageIO.read(getClass().getResourceAsStream("/player/soldiers/soldier_sprite_sheet.png"));
				up1 = this.getSprite(1, 4, 16, 16);
				up2 = this.getSprite(3, 4, 16, 16);
				down1 = this.getSprite(1, 1, 16, 16);
				down2 = this.getSprite(3, 1, 16, 16);
				left1 = this.getSprite(1, 2, 16, 16);
				left2 = this.getSprite(3, 2, 16, 16);
				right1 = this.getSprite(1, 3, 16, 16);
				right2 = this.getSprite(3, 3, 16, 16);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public void update() {

		if(attacking == true) {
			
			attackAction();
			
		}
		
		else if (playerKey.moveDown == true || playerKey.moveUp == true || playerKey.moveRight == true
				|| playerKey.moveLeft == true || playerKey.startDialogue==true) {

			if (playerKey.moveUp == true) {

				direction = "up";
				//				worldY -= speed;

			}

			else if (playerKey.moveDown == true) {

				direction = "down";
				//				worldY += speed;

			}

			else if (playerKey.moveLeft == true) {

				direction = "left";
				//				worldX -= speed;

			}

			else if (playerKey.moveRight == true) {

				direction = "right";
				//				worldX += speed;

			}

			// check tile collision
			collisionOn = false;
			gp.collisionChecker.checkTile(this);

			//check for object collision
			int objectIndex = gp.collisionChecker.checkObject(this, true);
			pickUpObject(objectIndex);
			
			//check for npc collision
			int npcIndex = gp.collisionChecker.checkEntity(this, gp.npc);
			interactNPC(npcIndex);
			
			//check for enemy collision
			int enemyIndex = gp.collisionChecker.checkEntity(this, gp.enemies);
			enemyContact(enemyIndex);
			
			//check event
			gp.event.checkEvent();
			
			// If collision is false, player can move
			if (collisionOn == false && playerKey.startDialogue == false) {
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
			
			gp.playerKey.startDialogue = false;

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
		
		if(invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 60) {
				invincible=false;
				invincibleCounter=0;
			}
		}
		
		if(currentHealth<=0) {
			gp.gameState=gp.gameOverState;
		}
		

	}

	public void pickUpObject(int index) {
		if (index != 999) {
			
			

//			String objectName = gp.objects[index].objectName;
//			switch (objectName) {
//			case "Key":
//				gp.playSoundEffect(1);
//				numOfKeys++;
//				gp.objects[index] = null;
//				gp.ui.displayMessage("You got a key!");
//				break;
//			case "Door":
//				if (numOfKeys > 0) {
//					gp.playSoundEffect(8);
//					gp.objects[index] = null;
//					numOfKeys--;
//					gp.ui.displayMessage("You opened the door!");
//				} else {
//					gp.ui.displayMessage("You need a key!");
//
//				}
//				break;
//			case "Boots":
//				gp.playSoundEffect(6);
//				speed += 2;
//				gp.objects[index] = null;
//				gp.ui.displayMessage("Speed Up!");
//				break;
//			case "Chest":
//				gp.ui.gameFinished = true;
//				gp.stopBackgroundMusic(0);
//				gp.playSoundEffect(3);
//				break;
//			}

		}
	}
	
	public void enemyContact(int i) {
		
		if(i!=999) {
			if(invincible==false) {
				currentHealth -= 1;
				invincible = true;
			}
			
		}
	}
	
	public void damageEnemy(int i) {
		
		if(i!=999) {
			
			if(gp.enemies[i].invincible == false) {
				
				gp.enemies[i].currentHealth -= 1;
				gp.enemies[i].invincible = true;
				
				if(gp.enemies[i].currentHealth <= 0) {
					
					gp.enemies[i] = null;
										
				}
			}
		}
		
	}
	
	public void attackAction() {
		
		spriteCounter++;
		if(spriteCounter<=5) {
			spriteNum = 1;
		}
		if(spriteCounter >5 && spriteCounter <=25) {
			spriteNum = 2;
			
			//Temp varibales so we can remember where player was
			int tempWorldX = worldX;
			int tempWorldY = worldY;
			int tempSolidAreaWidth = solidArea.width;
			int tempSolidAreaHeight = solidArea.height;
			
			
			switch(direction) {
			case "up":
				worldY-= attackRadius.height;
				break;
			case "down":
				worldY+= attackRadius.height;
				break;
			case "left":
				worldX-= attackRadius.width;
				break;
			case "right":
				worldX+= attackRadius.width;
				break;
			}
			
			solidArea.width = attackRadius.width;
			solidArea.height = attackRadius.height;
			
			int enemyIndex = gp.collisionChecker.checkEntity(this, gp.enemies);
			damageEnemy(enemyIndex);
			
			worldX = tempWorldX;
			worldY = tempWorldY;
			solidArea.width = tempSolidAreaWidth;
			solidArea.height = tempSolidAreaHeight;
			
		}
		if(spriteCounter > 25) {
			spriteNum = 1;
			spriteCounter = 0;
			attacking = false;
		}
		}

	public void interactNPC(int i) {
		if(gp.playerKey.startDialogue==true) {
			if(i!=999) {
					
					gp.gameState = gp.dialogueState;
					gp.npc[i].speak();			
				
			}
			else {
				attacking = true;
			}
			
		}
		
		
		gp.playerKey.startDialogue=false;
	}
	
	
	
	public void draw(Graphics2D g2) {

		//		g2.setColor(Color.white);
		//		
		//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);

		BufferedImage playerSprite = null;

		switch (direction) {
		case "up":
			if(attacking==false) {
				if (spriteNum == 1) {
					playerSprite = up1;
				}
				if (spriteNum == 2) {
					playerSprite = up2;
				}
			}
			if(attacking==true) {
				if (spriteNum == 1) {
					playerSprite = up1;
				}
				if (spriteNum == 2) {
					playerSprite = attackUp1;
				}
			}
			break;
		case "down":
			if(attacking==false) {
				if (spriteNum == 1) {
					playerSprite = down1;
				}
				if (spriteNum == 2) {
					playerSprite = down2;
				}
			}
			if(attacking==true) {
				if (spriteNum == 1) {
					playerSprite = down1;
				}
				if (spriteNum == 2) {
					playerSprite = attackDown1;
				}
			}
			break;
		case "left":
			if(attacking==false) {
				if (spriteNum == 1) {
					playerSprite = left1;
				}
				if (spriteNum == 2) {
					playerSprite = left2;
				}
			}
			if(attacking==true) {
				if (spriteNum == 1) {
					playerSprite = left1;
				}
				if (spriteNum == 2) {
					playerSprite = attackLeft1;
				}
			}
			break;
		case "right":
			if(attacking==false) {
				if (spriteNum == 1) {
					playerSprite = right1;
				}
				if (spriteNum == 2) {
					playerSprite = right2;
				}
			}
			if(attacking==true) {
				if (spriteNum == 1) {
					playerSprite = right1;
				}
				if (spriteNum == 2) {
					playerSprite = attackRight1;
				}
			}
			break;
		}

		if(invincible ==true) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		}
		g2.drawImage(playerSprite, screenX, screenY, gp.tileSize, gp.tileSize, null);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

	}
}
