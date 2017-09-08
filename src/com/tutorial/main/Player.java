package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject {
    Random r = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    public void tick() {
        this.x += this.velX;
        this.y += this.velY;
        this.x = Game.clamp(this.x, 0, 602);
        this.y = Game.clamp(this.y, 0, 417);
    }

    public void render(Graphics g) {
        if (this.id == ID.Player) {
            g.setColor(Color.white);
        }

        g.fillRect(this.x, this.y, 32, 32);
    }
}
