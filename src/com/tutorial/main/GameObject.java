package com.tutorial.main;

import java.awt.Graphics;

public abstract class GameObject {
    protected int x;
    protected int y;
    protected ID id;
    protected int velX;
    protected int velY;

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();

    public abstract void render(Graphics var1);

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public ID getId() {
        return this.id;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelX() {
        return this.velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public int getvelY() {
        return this.velY;
    }
}
