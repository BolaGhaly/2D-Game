package enemies;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class EnemyTwoFace extends Entity{

	public EnemyTwoFace(GamePanel gp) {
		super(gp);
		
		entityName = "Two Face";
		speed = 1;
		maxHealth = 2;
		currentHealth = maxHealth;
		entityType="enemy";
		
		getSprite();
		
	}
	
	public void getSprite() {
		try {

			spriteSheet = ImageIO.read(getClass().getResourceAsStream("/enemies/Two_Face_Sprite_Sheet.jpeg"));
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
	
	

	
	
}
