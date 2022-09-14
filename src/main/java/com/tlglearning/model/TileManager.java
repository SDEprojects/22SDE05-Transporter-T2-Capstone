package com.tlglearning.model;

import com.tlglearning.controller.GamePanelB;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanelB gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanelB gp) {
        this.gp = gp;
        tile = new Tile[10];
        getTileImage();
        mapTileNum = new int[gp.maxScreenRow][gp.maxScreenColumn];
        loadMap("/maps1/map1.txt");

    }

    public void getTileImage() {

        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles1/grass.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles1/sand.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles1/road.png"));
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles1/water.png"));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void loadMap(String filePath){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;

            while (col < gp.maxScreenColumn && row < gp.maxScreenRow) {
                String line = br.readLine();

                while (col < gp.maxScreenColumn) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[row][col] = num;
                    col++;
                }
                if(col == gp.maxScreenColumn){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

//        g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        while (col < gp.maxScreenColumn && row < gp.maxScreenRow) {

            int tileNum = mapTileNum[row][col];
            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            x += gp.tileSize;
            col++;
            if (col == gp.maxScreenColumn) {
                col = 0;
                x = 0;
                y += gp.tileSize;
                row++;
            }
        }

    }

}
