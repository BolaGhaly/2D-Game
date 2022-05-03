package main;

import enemies.EnemyTwoFace;
import entity.MaleBlueBardNPC;
import object.BootsObject;
import object.ChestObject;
import object.DoorObject;
import object.KeyObject;

public class AssetSetter {

	GamePanel gp;

	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setNPC() {
//		gp.npc[0] = new MaleBlueBardNPC(gp);
//		gp.npc[0].worldX = gp.tileSize*11;
//		gp.npc[0].worldY = gp.tileSize*11;
		gp.npc[0] = new MaleBlueBardNPC(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*21;
	}

	public void setObject() {

//		// ------------------ Keys -------------------
//		gp.objects[0] = new KeyObject(gp);
//		gp.objects[0].worldX = 22 * gp.tileSize;
//		gp.objects[0].worldY = 18 * gp.tileSize;
//
//		gp.objects[1] = new KeyObject(gp);
//		gp.objects[1].worldX = 24 * gp.tileSize;
//		gp.objects[1].worldY = 18 * gp.tileSize;
//
//		// ------------------ Doors ------------------
//		gp.objects[2] = new DoorObject(gp);
//		gp.objects[2].worldX = 24 * gp.tileSize;
//		gp.objects[2].worldY = 18 * gp.tileSize;
//
//		gp.objects[3] = new DoorObject(gp);
//		gp.objects[3].worldX = 28 * gp.tileSize;
//		gp.objects[3].worldY = 18 * gp.tileSize;
//
//		// ------------------ Chests -----------------
//		gp.objects[4] = new ChestObject(gp);
//		gp.objects[4].worldX = 30 * gp.tileSize;
//		gp.objects[4].worldY = 18 * gp.tileSize;
//
//		// ------------------ Boots ------------------
//		gp.objects[5] = new BootsObject(gp);
//		gp.objects[5].worldX = 34 * gp.tileSize;
//		gp.objects[5].worldY = 18 * gp.tileSize;
//		
	}
	
	public void setEnemies() {
//		gp.enemies[0] = new EnemyTwoFace(gp);
//		gp.enemies[0].worldX=11*gp.tileSize;
//		gp.enemies[0].worldY=10*gp.tileSize;	
		gp.enemies[0] = new EnemyTwoFace(gp);
		gp.enemies[0].worldX=23*gp.tileSize;
		gp.enemies[0].worldY=37*gp.tileSize;	
	}
}
