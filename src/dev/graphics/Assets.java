/* **************************
* Assets uses loadImage() defined in ImageLoader
* to load all images used in game.
 ************************** */

package dev.graphics;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage intro, bg, end, tryAgain, win,
    level1, level2, level3, player, cardboardBox, metalBox,
    stoneBox, woodBox, stopButton, wall, life;

    public static void init(){
        intro = ImageLoader.loadImage("/resources/Title.png");
        bg = ImageLoader.loadImage("/resources/Background.bmp");
        tryAgain = ImageLoader.loadImage("/resources/tryagain.png");
        end = ImageLoader.loadImage("/resources/game_over2.png");
        win = ImageLoader.loadImage("/resources/win.png");

        level1 = ImageLoader.loadImage("/resources/level1.png");
        level2 = ImageLoader.loadImage("/resources/level2.png");
        level3 = ImageLoader.loadImage("/resources/level3.png");

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
