package dev.entities;

import dev.Handler;
import dev.entities.movingObjects.Player;
import dev.entities.movingObjects.WallBox;
import dev.entities.statics.StopButton;

import java.awt.*;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class EntityManager {
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        //        addEntity(new LifeBoost(handler, 100, 100));
        addEntity(player);
    }

    public void tick(){
        for (int i = 0; i < entities.size(); i++){
            Entity e = entities.get(i);
            e.tick();
        }
    }

    public void render(Graphics g){
        for (int i = 0; i < entities.size(); i++){

            Entity e = entities.get(i);
            e.render(g);
        }
    }

    public void removeEntity(Entity e){
        if (entities.contains(e)) {
            entities.remove(e);
        }
    }

    public void clearEntities(){
        for (int i = 0; i < entities.size(); i++){
            if (!(entities.get(i) instanceof WallBox) && !(entities.get(i) instanceof StopButton)) {
                    entities.remove(i);
//                    System.out.println("Current entities");
//                    printContents();
            }
        }

        addEntity(player);
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

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

    public void printContents(){

        for(int i = 0; i < entities.size(); i++){

            System.out.println(entities.get(i));
        }
    }
}
