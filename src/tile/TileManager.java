package tile;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {
	GamePanel gamePanel;
	Tile[] tile;
	int mapTileNum[][];

	public TileManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;

		tile = new Tile[10];
		mapTileNum = new int[gamePanel.maxScreenColumn][gamePanel.maxScreenRow];
		getTileImage();
		loadMp("/map1/map.txt");
	}

	public void getTileImage() {
		try {
			// earth
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/earth/earth.png"));

			// wall
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/wall/wall.png"));

			// grass
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/grass01/grass01.png"));

			// tree
			//			tile[2] = new Tile();
			//			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tree/tree.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadMp(String mapFilePath) {
		try {
			InputStream input_stream = getClass().getResourceAsStream(mapFilePath);
			BufferedReader buffered_reader = new BufferedReader(new InputStreamReader(input_stream));

			int col = 0;
			int row = 0;

			while (col < gamePanel.maxScreenColumn && row < gamePanel.maxScreenRow) {
				String line = buffered_reader.readLine();

				while (col < gamePanel.maxScreenColumn) {
					String numbers[] = line.split(" ");

					int num = Integer.parseInt(numbers[col]);

					mapTileNum[col][row] = num;

					col++;
				}
				if (col == gamePanel.maxScreenColumn) {
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
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;

		while (col < gamePanel.maxScreenColumn && row < gamePanel.maxScreenRow) {

			int tileNum = mapTileNum[col][row];

			g2.drawImage(tile[tileNum].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
			col++;
			x += gamePanel.tileSize;

			if (col == gamePanel.maxScreenColumn) {
				col = 0;
				x = 0;
				row++;
				y += gamePanel.tileSize;
			}
		}
	}

	// IF WE'RE NOT USING MAP.TXT FILE USE THIS INSTEAD...	
	//		public void draw(Graphics2D g2) {
	//			int col = 0;
	//			int row = 0;
	//			int x = 0;
	//			int y = 0;
	//	
	//			while (col < gamePanel.maxScreenColumn && row < gamePanel.maxScreenRow) {
	//				g2.drawImage(tile[3].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
	//				col++;
	//				x += gamePanel.tileSize;
	//	
	//				if (col == gamePanel.maxScreenColumn) {
	//					col = 0;
	//					x = 0;
	//					row++;
	//					y += gamePanel.tileSize;
	//				}
	//			}
	//		}

}
