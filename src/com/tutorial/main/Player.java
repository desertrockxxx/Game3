package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    // the mask for the Player
    public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);

        handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.05f, handler));

        collison();
    }

    // If collide then lose Health
    private void collison(){
        for(int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            // if tempObject is BasicEnemy
            if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy)dw{
                // what to do if they collide/intersect
                if(getBounds().intersects(tempObject.getBounds())){
                    // Lose Health
                    HUD.HEALTH -= 2;

                }
            }
        }
    }

    public void render(Graphics g) {
        // draw the Player
        g.setColor(Color.white);
        g.fillRect(this.x, this.y, 32, 32);
    }
}
