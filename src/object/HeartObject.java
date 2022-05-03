package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class HeartObject extends Entity {
	
	GamePanel gp;

		public HeartObject(GamePanel gp) {

			super(gp);

			objectName = "Heart";

			objectSprite1 = objectSetup("/objects/heart_full");
			objectSprite2 = objectSetup("/objects/heart_half");
			objectSprite3 = objectSetup("/objects/heart_empty");

		}
}
