package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;
import main.UtilityTool;

public class KeyObject extends Entity {

	public KeyObject(GamePanel gp) {

		super(gp);

		objectName = "Key";

		down1 = objectSetup("/objects/key");

	}
}
