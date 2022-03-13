package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class BootsObject extends ParentObject {
	public BootsObject() {
		objectName = "Boots";

		try {
			objectSprite = ImageIO.read(getClass().getResourceAsStream("/objects/boots.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		collision = true;
	}
}
