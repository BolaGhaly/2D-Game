package object;



import entity.Entity;
import main.GamePanel;

public class DoorObject extends Entity {
	GamePanel gp;

	public DoorObject(GamePanel gp) {

		super(gp);

		objectName = "Door";

		down1 = objectSetup("/objects/door");

		collisionOn = true;
	}
}
