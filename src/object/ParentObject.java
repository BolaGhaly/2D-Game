package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class ParentObject {

	public BufferedImage objectSprite;
	public String objectName;
	public boolean collision=false;
	public double worldX, worldY;
	
	public void draw(Graphics2D g2, GamePanel gp) {
		
		double screenX = worldX - gp.player.worldX + gp.player.screenX;
		double screenY = worldY - gp.player.worldY + gp.player.screenY;

		if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
				&& worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
				&& worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
				&& worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			g2.drawImage(objectSprite, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize,
					null);
		}
	}
}
