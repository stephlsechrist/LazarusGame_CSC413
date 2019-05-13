package dev.graphics;

import dev.graphics.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage intro, bg, player, cardboardBox, metalBox,
    stoneBox, woodBox, stopButton, end, wall, tryAgain, life, level2;
//    private static final int dim = 64;

    public static void init(){
        intro = ImageLoader.loadImage("/resources/Title.png");
        bg = ImageLoader.loadImage("/resources/Background.bmp");
        tryAgain = ImageLoader.loadImage("/resources/tryagain.png");
//        level2 = ImageLoader.loadImage("resources/level2.png");
        end = ImageLoader.loadImage("/resources/game_over2.png");

        player = ImageLoader.loadImage("/resources/Lazarus.png");
        wall = ImageLoader.loadImage("/resources/Wall.gif");
        stopButton = ImageLoader.loadImage("/resources/Button.gif");
        life = ImageLoader.loadImage("/resources/heart.png");

        cardboardBox = ImageLoader.loadImage("/resources/CardBox.gif");
        metalBox = ImageLoader.loadImage("/resources/MetalBox.png");
        stoneBox = ImageLoader.loadImage("/resources/StoneBox.gif");
        woodBox = ImageLoader.loadImage("/resources/WoodBox.png");
    }
}
