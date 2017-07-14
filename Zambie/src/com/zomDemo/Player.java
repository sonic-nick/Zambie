package com.zomDemo;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by Nicholas on 7/11/2017.
 */
public class Player {

    double vx, vy;
    double maxspeed;
    double acceleration;
    Rectangle bounds;
    boolean alive;

    public Player() {
        bounds = new Rectangle(20, 20, 10, 10);
        vx = 0;
        vy = 0;
        maxspeed = 50;
        acceleration = 3;
        alive = true;
    }

    public void draw(Graphics g) {
        if(alive){
        g.setColor(Color.BLACK);
        g.fillRect(bounds.x, bounds.y, 15, 15);
        }
    }
    public boolean isAlive(){
        return alive;
    }

    public void hit() {
        alive = false;
    }

    public void move(ArrayList<String> dirs) {
        for (int i = 0; i < dirs.size(); i++) {
            if (dirs.get(i).equals("up")) {
                vy -= acceleration;
            }
            if (dirs.get(i).equals("down")) {
                vy += acceleration;
            }
            if (dirs.get(i).equals("right")) {
                vx += acceleration;
            }
            if (dirs.get(i).equals("left")) {
                vx -= acceleration;
            }

        }
        if (vx > maxspeed)
            vx = maxspeed;
        if (vy > maxspeed)
            vy = maxspeed;
        if (vx < -maxspeed)
            vx = -maxspeed;
        if (vy < -maxspeed)
            vy = -maxspeed;
        bounds.x += (int)(vx);
        bounds.y += (int)(vy);
        vx *= .99;
        vy *= .99;
    }

    public Rectangle getBounds() {
        return bounds;
    }

}



