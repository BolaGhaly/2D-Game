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

		// ------------------ Keys -------------------
		gp.objects[0] = new KeyObject();
		gp.objects[0].worldX = 22 * gp.tileSize;
		gp.objects[0].worldY = 18 * gp.tileSize;

		gp.objects[1] = new KeyObject();
		gp.objects[1].worldX = 24 * gp.tileSize;
		gp.objects[1].worldY = 18 * gp.tileSize;

		// ------------------ Doors ------------------
		gp.objects[2] = new DoorObject();
		gp.objects[2].worldX = 26 * gp.tileSize;
		gp.objects[2].worldY = 18 * gp.tileSize;

		gp.objects[3] = new DoorObject();
		gp.objects[3].worldX = 28 * gp.tileSize;
		gp.objects[3].worldY = 18 * gp.tileSize;

		// ------------------ Chests -----------------
		gp.objects[4] = new ChestObject();
		gp.objects[4].worldX = 30 * gp.tileSize;
		gp.objects[4].worldY = 18 * gp.tileSize;

		// ------------------ Boots ------------------
		gp.objects[5] = new BootsObject();
		gp.objects[5].worldX = 34 * gp.tileSize;
		gp.objects[5].worldY = 18 * gp.tileSize;

	}
}
