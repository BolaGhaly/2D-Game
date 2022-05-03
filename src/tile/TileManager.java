package tile;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;

public class TileManager {
	GamePanel gamePanel;
	public Tile[] tile;
	public int mapTileNum[][];

	public TileManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;

		tile = new Tile[50];
		mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
		getTileImage();
		loadMap("/worldMap/worldV2.txt");
	}

	public void getTileImage() {
		
		tileSetup(0, "grass00", false);
		tileSetup(1, "grass00", false);
		tileSetup(2, "grass00", false);
		tileSetup(3, "grass00", false);
		tileSetup(4, "grass00", false);
		tileSetup(5, "grass00", false);
		tileSetup(6, "grass00", false);
		tileSetup(7, "grass00", false);
		tileSetup(8, "grass00", false);
		tileSetup(9, "grass00", false);
		
		
		tileSetup(10, "grass00", false);
		tileSetup(11, "grass01", false);
		tileSetup(12, "water00", true);
		tileSetup(13, "water01", true);
		tileSetup(14, "water02", true);
		tileSetup(15, "water03", true);
		tileSetup(16, "water04", true);
		tileSetup(17, "water05", true);
		tileSetup(18, "water06", true);
		tileSetup(19, "water07", true);
		tileSetup(20, "water08", true);
		tileSetup(21, "water09", true);
		tileSetup(22, "water10", true);
		tileSetup(23, "water11", true);
		tileSetup(24, "water12", true);
		tileSetup(25, "water13", true);
		tileSetup(26, "road00", false);
		tileSetup(27, "road01", false);
		tileSetup(28, "road02", false);
		tileSetup(29, "road03", false);
		tileSetup(30, "road04", false);
		tileSetup(31, "road05", false);
		tileSetup(32, "road06", false);
		tileSetup(33, "road07", false);
		tileSetup(34, "road08", false);
		tileSetup(35, "road09", false);
		tileSetup(36, "road10", false);
		tileSetup(37, "road11", false);
		tileSetup(38, "road12", false);
		tileSetup(39, "earth", false);
		tileSetup(40, "wall", true);
		tileSetup(41, "tree", true);
		
		
		
	}

	public void tileSetup(int index, String imagePath, boolean collision) {
		UtilityTool utilityTool = new UtilityTool();

		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imagePath + ".png"));
			tile[index].image = utilityTool.scaleImg(tile[index].image, gamePanel.tileSize, gamePanel.tileSize);
			tile[index].collision = collision;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadMap(String mapFilePath) {
		try {
			InputStream input_stream = getClass().getResourceAsStream(mapFilePath);
			BufferedReader buffered_reader = new BufferedReader(new InputStreamReader(input_stream));

			int col = 0;
			int row = 0;

			while (col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow) {
				String line = buffered_reader.readLine();

				while (col < gamePanel.maxWorldCol) {
					String numbers[] = line.split(" ");

					int num = Integer.parseInt(numbers[col]);

					mapTileNum[col][row] = num;

					col++;
				}
				if (col == gamePanel.maxWorldCol) {
					col = 0;
					row++;
				}

			}

			buffered_reader.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void draw(Graphics2D g2) {
		int worldCol = 0;
		int worldRow = 0;

		while (worldCol < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow) {

			int tileNum = mapTileNum[worldCol][worldRow];
			int worldX = worldCol * gamePanel.tileSize;
			int worldY = worldRow * gamePanel.tileSize;
			int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
			int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

			if (worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX
					&& worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX
					&& worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY
					&& worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, null);
			}

			worldCol++;

			if (worldCol == gamePanel.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}
	}

}
