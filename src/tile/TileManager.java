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

		tile = new Tile[10];
		mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
		getTileImage();
		loadMap("/worldMap1/worldMap1.txt");
	}

	public void getTileImage() {
		// earth
		tileSetup(0, "earth", false);

		// wall
		tileSetup(1, "wall", true);

		// grass
		tileSetup(2, "grass01", false);

		// tree
		tileSetup(3, "tree", true);

		// water
		tileSetup(4, "water00", true);

		// sand
		tileSetup(5, "sand", false);
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
