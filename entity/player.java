package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class player extends entity {

  GamePanel gp;
  KeyHandler keyH;

  public player (GamePanel gp, KeyHandler keyH){

    this.gp = gp;
    this.keyH = keyH;
    setDefaultValues();
    getPlayerImage();

  }

  public void setDefaultValues(){

    x = 100;
    y = 100;
    speed = 4;
    direction = "face";
  }

  public void getPlayerImage(){

    try{
      face = ImageIO.read(getClass().getResourceAsStream("/player/face.png"));
      dos = ImageIO.read(getClass().getResourceAsStream("/player/dos.png"));
      droite = ImageIO.read(getClass().getResourceAsStream("/player/droite.png"));
      gauche = ImageIO.read(getClass().getResourceAsStream("/player/gauche.png"));

    } catch (Exception e) {
      e.printStackTrace();
    }

  }


  public void update(){

    if (keyH.upPressed == true){
      direction = "dos";
      y -= speed;
    }
    else if(keyH.downPressed == true){
      direction = "face";
      y += speed;
    }
    else if(keyH.leftPressed == true){
      direction = "gauche";
      x -= speed;
    }
    else if (keyH.rightPressed == true){
      direction = "droite";
      x += speed;
    }



  }
  public void draw (Graphics2D g2){

//    g2.setColor(Color.WHITE);
//
//    g2.fillRect(x,y, gp.tileSize, gp.tileSize);

    BufferedImage image = null;

    switch(direction){

      case "face":
        image = face;
        break;
        case "dos":
          image = dos;
          break;
          case "gauche":
            image = gauche;
            break;
            case "droite":
              image = droite;
              break;

    }
    g2.drawImage(image, x, y, gp.tileSize, gp.tileSize,null);
  }


}
