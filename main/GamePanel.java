package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    //SCREEN SETTINGS
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale ;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWitdh = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWitdh, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

    }
}
