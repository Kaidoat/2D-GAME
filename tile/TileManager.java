package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

  GamePanel gp;
  Tile []tile;
  int[][] mapTileNum;
  public int MAX_TILE_NB = 10;

  public TileManager(GamePanel gp){

    this.gp = gp;

    tile = new Tile[MAX_TILE_NB];
    mapTileNum = new int[gp.maxScreenRow][gp.maxScreenCol];
    getTileImage();
    loadMap();

  }

  public void getTileImage(){

    try{

      tile[0] = new Tile();
      tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

      tile[1] = new Tile();
      tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));

      tile[2] = new Tile();
      tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));

    }catch(IOException e){
      e.printStackTrace();
    }

  }

  public void loadMap(){

    try{
      InputStream is = getClass().getResourceAsStream("/maps/map01.txt");
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      int col = 0;
      int row = 0;

      while(col < gp.maxScreenCol && row < gp.maxScreenRow){

        String line = br.readLine();

        while(col < gp.maxScreenCol){

          String numbers [] = line.split(" ");

          int num = Integer.parseInt(numbers[col]);

          mapTileNum[row][col] = num;
          col++;
        }
        if (col == gp.maxScreenCol){
          col = 0;
          row++;
        }
      }
      br.close();

    }catch(Exception e){
      e.printStackTrace();

    }
  }





  public void draw(Graphics2D g2){

    int col = 0;
    int row = 0;
    int x = 0;
    int y = 0;
    int tileNum = mapTileNum[row][col];

    while (col < gp.maxScreenCol && row < gp.maxScreenRow){


      g2.drawImage(tile[tileNum].image, x, y,gp.tileSize, gp.tileSize, null);
      col ++;
      x += gp.tileSize;

      if (col == gp.maxScreenCol){
        col = 0;
        x=0;
        row++;
        y+= gp.tileSize;

      }
    }
  }
}
