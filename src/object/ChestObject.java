package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class ChestObject extends Entity {
	GamePanel gp;

	public ChestObject(GamePanel gp) {

		super(gp);

		objectName = "Chest";
		
		objectSetup("/objects/chest");



	}
}
