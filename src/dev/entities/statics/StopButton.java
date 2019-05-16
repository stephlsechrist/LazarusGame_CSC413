/* ****************************
* StopButton is a StaticEntity.
* Always drawn at same spots on levels.
 **************************** */

package dev.entities.statics;

import dev.Handler;
import dev.graphics.Assets;

import java.awt.*;

public class StopButton extends StaticEntity {
    public StopButton(Handler handler, int x, int y) {
        super(handler, x, y);
    }

    @Override
    public void tick() {
    }

    // draws button
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.stopButton, x, y, null);
    }
}
