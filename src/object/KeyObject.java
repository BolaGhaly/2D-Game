package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class KeyObject extends ParentObject {
	GamePanel gp;

	public KeyObject(GamePanel gp) {

		this.gp = gp;

		objectName = "Key";

		try {
			objectSprite = ImageIO.read(getClass().getResourceAsStream("/objects/batarang.png"));
			uTool.scaleImg(objectSprite, gp.tileSize, gp.tileSize);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
