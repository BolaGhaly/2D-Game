package main;

import object.BootsObject;
import object.ChestObject;
import object.DoorObject;
import object.KeyObject;

public class AssetSetter {

	GamePanel gp;

	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}

	public void setObject() {
		gp.objects[0] = new KeyObject();
		gp.objects[0].worldX = 22 * gp.tileSize;
		gp.objects[0].worldY = 18 * gp.tileSize;

		gp.objects[1] = new DoorObject();
		gp.objects[1].worldX = 26 * gp.tileSize;
		gp.objects[1].worldY = 18 * gp.tileSize;

		gp.objects[2] = new ChestObject();
		gp.objects[2].worldX = 30 * gp.tileSize;
		gp.objects[2].worldY = 18 * gp.tileSize;

		gp.objects[3] = new BootsObject();
		gp.objects[3].worldX = 34 * gp.tileSize;
		gp.objects[3].worldY = 18 * gp.tileSize;

	}
}
