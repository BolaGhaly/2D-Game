package object;



import entity.Entity;
import main.GamePanel;

public class BootsObject extends Entity {
	GamePanel gp;

	public BootsObject(GamePanel gp) {

		super(gp);

		objectName = "Boots";

		down1 = objectSetup("/objects/boots");

	}
}
