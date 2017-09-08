package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> object = new LinkedList();

    public Handler() {
    }

    public void tick() {
        for(int i = 0; i < this.object.size(); ++i) {
            GameObject tempObject = (GameObject)this.object.get(i);
            tempObject.tick();
        }

    }

    public void render(Graphics g) {
        for(int i = 0; i < this.object.size(); ++i) {
            GameObject tempObject = (GameObject)this.object.get(i);
            tempObject.render(g);
        }

    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
}
