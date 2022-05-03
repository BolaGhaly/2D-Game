package main;

import java.awt.Rectangle;

public class Event {

	GamePanel gp;
	Rectangle eventRectangle;
	int eventRectangleDefaultX, eventRectangleDefaultY;
	
	public Event(GamePanel gp) {
		
		this.gp = gp;
		eventRectangle = new Rectangle();
		eventRectangle.x = 23;
		eventRectangle.y = 23;
		eventRectangle.height = 2;
		eventRectangle.width = 2;
		eventRectangleDefaultX = eventRectangle.x;
		eventRectangleDefaultY = eventRectangle.y;
		
	}
	
	public void checkEvent() {
		
		if(hit(27,16,"right") == true) {
			damgePit(gp.dialogueState);
		}
	}
	
	public boolean hit(int eventCol, int eventRow, String requiredDirection) {
		boolean hit = false;
		
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		eventRectangle.x = eventCol * gp.tileSize + eventRectangle.x;
		eventRectangle.y = eventRow * gp.tileSize + eventRectangle.y;
		
		if(gp.player.solidArea.intersects(eventRectangle)){
			if(gp.player.direction.contentEquals(requiredDirection) || requiredDirection.contentEquals("any")){
				hit=true;
			}
		}
		
		gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;
		eventRectangle.x = eventRectangleDefaultX;
		eventRectangle.x = eventRectangleDefaultY;
		
		
		return hit;
	}
	
	public void damgePit(int gameState) {
		gp.gameState = gameState;
		gp.ui.dialogue = "You have stepped on a sharp rock!";
		gp.player.currentHealth -=1; 
	}
	
}
