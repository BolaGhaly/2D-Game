package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.PlayerControls;

public class Player extends Entity{
	GamePanel gp;
	PlayerControls playerKey;
	
	public Player(GamePanel gp, PlayerControls playerKey) {
		this.gp=gp;
		this.playerKey=playerKey;
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/batman/batman_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/batman/batman_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/batman/batman_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/batman/batman_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/batman/batman_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/batman/batman_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/batman/batman_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/batman/batman_right_2.png"));

		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(playerKey.moveUp == true) {
			
			direction = "up";
			y-=speed;
		
		}
	
		else if(playerKey.moveDown == true) {
		
			direction = "down";
			y+=speed;
		
		}
	
		else if(playerKey.moveLeft==true) {
	
			direction = "left";
			x-=speed;
		
		}
	
		else if(playerKey.moveRight == true) {
		
			direction = "right";
			x+=speed;
		
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
//		g2.setColor(Color.white);
//		
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage playerSprite = null;
		
		switch(direction) {
		case "up":
			playerSprite = up1;
			break;
		case "down":
			playerSprite = down1;
			break;
		case "left":
			playerSprite = left1;
			break;
		case "right":
			playerSprite = right1;
			break;
		}
		
		g2.drawImage(playerSprite, x, y, gp.tileSize, gp.tileSize, null);
		
		
		
	}
}
