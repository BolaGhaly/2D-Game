package entity;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class NPC_Commisioner_Gordon extends Entity{
	
	public NPC_Commisioner_Gordon(GamePanel gp) {
		super(gp);
		
		
		direction = "down";
		speed=2;
		getNPCImage(); 
		worldX=10;
		worldY=10;
	}
	
	public void getNPCImage() {
		//System.out.println(gp.character);

		
			try {
				spriteSheet = ImageIO.read(getClass().getResourceAsStream("/player/commisioner_gordon/commisioner_gordon_sprite_sheet.png"));
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
	
	
}
