package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class BootsObject extends ParentObject {
	GamePanel gp;

	public BootsObject(GamePanel gp) {

		this.gp = gp;

		objectName = "Boots";

		try {
			objectSprite1 = ImageIO.read(getClass().getResourceAsStream("/objects/boots.png"));
			uTool.scaleImg(objectSprite1, gp.tileSize, gp.tileSize);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
