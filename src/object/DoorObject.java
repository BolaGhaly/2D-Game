package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class DoorObject extends ParentObject {
	GamePanel gp;

	public DoorObject(GamePanel gp) {

		this.gp = gp;

		objectName = "Door";

		try {
			objectSprite = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
			uTool.scaleImg(objectSprite, gp.tileSize, gp.tileSize);
		} catch (IOException e) {
			e.printStackTrace();
		}

		collision = true;
	}
}
