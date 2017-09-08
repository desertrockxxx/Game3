package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1550691097823471818L;
    public static final int WIDTH = 640;
    public static final int HEIGHT = 477;
    private Thread thread;
    private boolean running = false;
    private Random r;
    private Handler handler = new Handler();
    private HUD hud;

    public Game() {
        this.addKeyListener(new KeyInput(this.handler));
        new Window(640, 477, "Let's Build a Game", this);
        this.hud = new HUD();
        this.r = new Random();
        this.handler.addObject(new Player(288, 206, ID.Player));
        this.handler.addObject(new BasicEnemy(this.r.nextInt(640), this.r.nextInt(477), ID.BasicEnemy));
    }

    public synchronized void start() {
        this.thread = new Thread(this);
        this.thread.start();
        this.running = true;
    }

    public synchronized void stop() {
        try {
            this.thread.join();
            this.running = false;
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0D;
        double ns = 1.0E9D / amountOfTicks;
        double delta = 0.0D;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(this.running) {
            long now = System.nanoTime();
            delta += (double)(now - lastTime) / ns;

            for(lastTime = now; delta >= 1.0D; --delta) {
                this.tick();
            }

            if (this.running) {
                this.render();
            }

            ++frames;
            if (System.currentTimeMillis() - timer > 1000L) {
                timer += 1000L;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }

        this.stop();
    }

    private void tick() {
        this.handler.tick();
        this.hud.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
        } else {
            Graphics g = bs.getDrawGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, 640, 477);
            this.handler.render(g);
            this.hud.render(g);
            g.dispose();
            bs.show();
        }
    }

    public static int clamp(int var, int min, int max) {
        if (var >= max) {
            return max;
        } else {
            return var <= min ? min : var;
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
