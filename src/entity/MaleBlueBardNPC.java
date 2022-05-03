package entity;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class MaleBlueBardNPC extends Entity{

	public MaleBlueBardNPC(GamePanel gp) {
		super(gp);
		// TODO Auto-generated constructor stub
		
		direction = "down";
		speed = gp.worldWidth / 3200;
		
		//get sprites for this NPC
		try {
			
		spriteSheet= ImageIO.read(getClass().getResourceAsStream("/npc/bard_male_blue.png"));
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
		
		setDialogue();
		
		
	}
	
	public void setDirection() {
		
		
		directionChangeCounter++;
		//makes it so that direction only changes once every 60 frames
		if(directionChangeCounter==120) {
		Random random = new Random();
		int i = random.nextInt(100)+1; //random number from 1-100
		if(i<=25) {
			direction = "up";
		}
		if(i>25 && i<=50) {
			direction = "down";	
		}
		if(i>50 && i<=75) {
			direction = "left";
		}
		if(i>75 && i<=100) {
			direction="right";
		}
		
		directionChangeCounter=0;
		}
	}
	
	public void setDialogue() {
		 
		dialogues[0] = "Whats up gang?";
	}
	
	public void speak() {
		
		gp.ui.dialouge = dialogues[0];
		
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
	
	
	
	
	
}