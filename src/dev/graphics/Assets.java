package dev.graphics;

import dev.graphics.ImageLoader;
import dev.graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage intro, bg, player, cardboardBox, metalBox,
    stoneBox, woodBox, stopButton, end, wall;
//    private static final int dim = 64;

    public static void init(){
        intro = ImageLoader.loadImage("/resources/Title.gif");
        bg = ImageLoader.loadImage("/resources/Background.bmp");
        end = ImageLoader.loadImage("/resources/game_over.png");

        player = ImageLoader.loadImage("/resources/Lazarus_stand.gif");
        wall = ImageLoader.loadImage("/resources/Wall.gif");
        stopButton = ImageLoader.loadImage("/resources/Button.gif");

        cardboardBox = ImageLoader.loadImage("/resources/CardBox.gif");
        metalBox = ImageLoader.loadImage("/resources/MetalBox.gif");
        stoneBox = ImageLoader.loadImage("/resources/StoneBox.gif");
        woodBox = ImageLoader.loadImage("/resources/WoodBox.gif");
    }
}
