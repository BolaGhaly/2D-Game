package main;

import object.DoorObject;
import object.KeyObject;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp=gp;
	}
	
	public void setObject() {
		gp.objects[0]=new KeyObject();
		gp.objects[0].worldX=18*gp.tileSize;
		gp.objects[0].worldY=18*gp.tileSize;
		
		gp.objects[1]=new DoorObject();
		gp.objects[1].worldX=16*gp.tileSize;
		gp.objects[1].worldY=18*gp.tileSize;
		
		
	}
}
