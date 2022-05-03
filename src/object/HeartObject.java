package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class HeartObject extends ParentObject {
	
	GamePanel gp;

		public HeartObject(GamePanel gp) {

			this.gp = gp;

			objectName = "Boots";

			try {
				objectSprite1 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_full.png"));
				objectSprite2 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_half.png"));
				objectSprite3 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_blank.png"));
				uTool.scaleImg(objectSprite1, gp.tileSize, gp.tileSize);
				uTool.scaleImg(objectSprite2, gp.tileSize, gp.tileSize);
				uTool.scaleImg(objectSprite3, gp.tileSize, gp.tileSize);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
}
