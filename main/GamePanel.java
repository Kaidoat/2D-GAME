package main;

import javax.swing.*;
import java.awt.*;
import entity.player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale ;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWitdh = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;


    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    player player = new player(this,keyH);


    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWitdh, screenHeight));
        this.setBackground(Color.orange);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void startGameThread(){
      gameThread = new Thread(this);
      gameThread.start();
    }

  public void run() {

      double drawInterval = 1000000000/FPS;
      double delta = 0;
      long lastTime = System.nanoTime();
      long currentTime;
      long timer = 0;
      int drawCount = 0 ;


    while(gameThread != null ){

      currentTime = System.nanoTime();
      delta += (currentTime - lastTime) / drawInterval; // basically how much time has past
      timer += (currentTime-lastTime);
      lastTime = currentTime;

if (delta >= 1){
  update();
  repaint();
  delta--;
  drawCount++;

}
if (timer >= 1000000000){
    System.out.println("FPS:" + drawCount);
    drawCount = 0;
    timer = 0;
}
  }
  }


  public void update(){

      player.update();
  }

  public void paintComponent(Graphics g){

      super.paintComponent(g);


      Graphics2D g2 = (Graphics2D)g;
      tileM.draw(g2);
      player.draw(g2);


      g2.dispose();


  }
}
