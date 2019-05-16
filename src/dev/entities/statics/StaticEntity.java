/* ****************************
* StaticEntity underutilized in this
* game. could have used for wall boxes
 **************************** */

package dev.entities.statics;

import dev.Handler;
import dev.entities.Entity;

import java.awt.*;

public class StaticEntity extends Entity {
    public StaticEntity(Handler handler, int x, int y) {
        super(handler, x, y);
    }

    @Override
    public void tick(){

    }

    @Override
    public void render(Graphics g){
    }

    @Override
    public void die() {

    }
}
