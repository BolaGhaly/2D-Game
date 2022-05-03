package main;

import entity.Entity;

public class CollisionChecker {
	GamePanel gamePanel;

	public CollisionChecker(GamePanel gp) {
		this.gamePanel = gp;
	}

	public void checkTile(Entity entity) {
		int entityLeftWorldX = (int) (entity.worldX + entity.solidArea.x);
		int entityRightWorldX = (int) (entity.worldX + entity.solidArea.x + entity.solidArea.width);
		int entityTopWorldY = (int) (entity.worldY + entity.solidArea.y);
		int entityBottomWorldY = (int) (entity.worldY + entity.solidArea.y + entity.solidArea.height);

		int entityLeftCol = entityLeftWorldX / gamePanel.tileSize;
		int entityRightCol = entityRightWorldX / gamePanel.tileSize;
		int entityTopRow = entityTopWorldY / gamePanel.tileSize;
		int entityBottomRow = entityBottomWorldY / gamePanel.tileSize;

		int tileNum1;
		int tileNum2;

		switch (entity.direction) {
		case "up": {
			entityTopRow = (int) ((entityTopWorldY - entity.speed) / gamePanel.tileSize);
			tileNum1 = gamePanel.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gamePanel.tileM.mapTileNum[entityRightCol][entityTopRow];
			if (gamePanel.tileM.tile[tileNum1].collision == true || gamePanel.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		}
		case "down": {
			entityBottomRow = (int) ((entityBottomWorldY + entity.speed) / gamePanel.tileSize);
			tileNum1 = gamePanel.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gamePanel.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gamePanel.tileM.tile[tileNum1].collision == true || gamePanel.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		}
		case "right": {
			entityRightCol = (int) ((entityRightWorldX + entity.speed) / gamePanel.tileSize);
			tileNum1 = gamePanel.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gamePanel.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gamePanel.tileM.tile[tileNum1].collision == true || gamePanel.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				break;
			}
			break;
		}
		case "left": {
			entityLeftCol = (int) ((entityLeftWorldX - entity.speed) / gamePanel.tileSize);
			tileNum1 = gamePanel.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gamePanel.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if (gamePanel.tileM.tile[tileNum1].collision == true || gamePanel.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		}
		}
		
	}
	
	public int checkObject(Entity entity, boolean player) {
		int index = 999;
		for(int i = 0; i < gamePanel.objects.length; i++) {
			if(gamePanel.objects[i] != null) {
				
				//Get the solid area position of entity
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				//Get the solid area position of the object
				gamePanel.objects[i].solidArea.x = gamePanel.objects[i].worldX + gamePanel.objects[i].solidArea.x;
				gamePanel.objects[i].solidArea.y = gamePanel.objects[i].worldY + gamePanel.objects[i].solidArea.y;
				//System.out.println(gamePanel.objects[i].solidArea.x);
				switch(entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					break;
				}
				if(entity.solidArea.intersects(gamePanel.objects[i].solidArea)) {
					//if the object cannot be moved through
					if(gamePanel.objects[i].collisionOn==true) {
						entity.collisionOn=true;
					}
					if(player==true) {
						index = i;
					}
				}
				
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gamePanel.objects[i].solidArea.x= gamePanel.objects[i].solidAreaDefaultX;
				gamePanel.objects[i].solidArea.y= gamePanel.objects[i].solidAreaDefaultY;

			}
		
		}
		return index;
		
	}
	
	//npc collision
	public int checkEntity(Entity entity, Entity[] npc) {
			
		int index = 999;
		for(int i = 0; i < npc.length; i++) {
			if(npc[i] != null) {
				
				//Get the solid area position of entity
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				//Get the solid area position of the object
				npc[i].solidArea.x = npc[i].worldX + npc[i].solidArea.x;
				npc[i].solidArea.y = npc[i].worldY + npc[i].solidArea.y;
				
				switch(entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					break;
				}
				if(entity.solidArea.intersects(npc[i].solidArea)) {
					if(npc[i]!=entity) {
						entity.collisionOn=true;
						index = i;
					}
					
				}
				
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				npc[i].solidArea.x= npc[i].solidAreaDefaultX;
				npc[i].solidArea.y= npc[i].solidAreaDefaultY;

			}
		
		}
		return index;
		
	
		}
	
	public void checkPlayer(Entity entity){
				
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				//Get the solid area position of the object
				gamePanel.player.solidArea.x = gamePanel.player.worldX + gamePanel.player.solidArea.x;
				gamePanel.player.solidArea.y = gamePanel.player.worldY + gamePanel.player.solidArea.y;
				
				switch(entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					break;
				}
				if(entity.solidArea.intersects(gamePanel.player.solidArea)) {
					entity.collisionOn=true;
				}
				
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gamePanel.player.solidArea.x= gamePanel.player.solidAreaDefaultX;
				gamePanel.player.solidArea.y= gamePanel.player.solidAreaDefaultY;

		
	}
}
