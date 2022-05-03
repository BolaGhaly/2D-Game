package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ChestObject extends ParentObject {
	GamePanel gp;

	public ChestObject(GamePanel gp) {

		this.gp = gp;

		objectName = "Chest";

		try {
			objectSprite1 = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
			uTool.scaleImg(objectSprite1, gp.tileSize, gp.tileSize);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
