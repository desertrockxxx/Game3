package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < this.handler.object.size(); ++i) {
            GameObject tempObject = (GameObject)this.handler.object.get(i);
            if (tempObject.getId() == ID.Player) {
                if (key == 87) {
                    tempObject.setVelY(-5);
                }

                if (key == 83) {
                    tempObject.setVelY(5);
                }

                if (key == 68) {
                    tempObject.setVelX(5);
                }

                if (key == 65) {
                    tempObject.setVelX(-5);
                }
            }
        }

        if (key == 27) {
            System.exit(1);
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < this.handler.object.size(); ++i) {
            GameObject tempObject = (GameObject)this.handler.object.get(i);
            if (tempObject.getId() == ID.Player) {
                if (key == 87) {
                    tempObject.setVelY(0);
                }

                if (key == 83) {
                    tempObject.setVelY(0);
                }

                if (key == 68) {
                    tempObject.setVelX(0);
                }

                if (key == 65) {
                    tempObject.setVelX(0);
                }
            }
        }

    }
}
