package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {

  GamePanel gp;
  Tile []tile;
  public int MAX_TILE_NB = 10;

  public TileManager(GamePanel gp){

    this.gp = gp;

    tile = new Tile[MAX_TILE_NB];
    getTileImage();

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

  public void draw(Graphics2D g2){

    g2.drawImage(tile[0].image,0, 0, gp.tileSize,gp.tileSize, null );
  }
}
