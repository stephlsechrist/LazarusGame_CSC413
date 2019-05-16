/* ******************************************
 * EntityManager manages entities array. Adds player
 * too entities array in constructor.
 ****************************************** */

package dev.entities;

import dev.Handler;
import dev.entities.movingObjects.Player;
import dev.entities.movingObjects.WallBox;
import dev.entities.statics.StopButton;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }

    // calls tick method implemented in each Entity subclass
    public void tick(){
        for (int i = 0; i < entities.size(); i++){
            Entity e = entities.get(i);
            e.tick();
        }
    }

    // calls render method implemented in each Entity subclass
    public void render(Graphics g){
        for (int i = 0; i < entities.size(); i++){
            Entity e = entities.get(i);
            e.render(g);
        }
    }

    // removes a specific entity
    public void removeEntity(Entity e){
        if (entities.contains(e)) {
            entities.remove(e);
        }
    }

    // clears entire entity array, unless it's a wall or stop button
    // intended to clear all boxes that have fallen, and player, so that
    // level can restart
    public void clearEntities(){
        for (int i = 0; i < entities.size(); i++){
            if (!(entities.get(i) instanceof WallBox) && !(entities.get(i) instanceof StopButton)) {
                    entities.remove(i);
//                    System.out.println("Current entities");
//                    printContents();
            }
        }

        // add player back
        addEntity(player);
    }

    // add entity
    public void addEntity(Entity e){
        entities.add(e);
    }

    // getters and setters

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }


    // used for debugging
    public void printContents(){

        for(int i = 0; i < entities.size(); i++){

            System.out.println(entities.get(i));
        }
    }
}
