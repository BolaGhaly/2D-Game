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
}
