package main;

import javax.swing.*;
import java.awt.*;
import entity.player;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale ;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWitdh = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    int FPS = 60;



    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    player player = new player(this,keyH);

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;


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
      int i = 100;

      Graphics2D g2 = (Graphics2D)g;
      player.draw(g2);

      g2.dispose();


  }
}
