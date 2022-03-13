package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ChestObject extends ParentObject {
	public ChestObject() {
		objectName = "Chest";

		try {
			objectSprite = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		collision = true;
	}
}
