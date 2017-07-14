package com.zomDemo.zombies;

import com.zomDemo.Player;

import java.awt.*;

/**
 * Created by Nicholas on 7/11/2017.
 */
public class Zombie {
    Rectangle bounds;
    int speed;

    public Zombie(Rectangle bounds) {
        this.bounds = bounds;
        this.speed = 2;
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(bounds.x, bounds.y, 15, 15);
    }

    private void act(Player player) {
        if(contains(player.getBounds())){
            player.hit();
        }
    }

    public boolean contains(Rectangle rect) {
     return   bounds.intersects(rect);
    }

    public void move(Player player) {
        if(player.isAlive()) {
            Rectangle pBounds = player.getBounds();
            if (bounds.x < pBounds.x) {
                bounds.x += speed;
            }
            if (bounds.x > pBounds.x) {
                bounds.x -= speed;
            }
            if (bounds.y < pBounds.y) {
                bounds.y += speed;
            }
            if (bounds.y > pBounds.y) {
                bounds.y -= speed;
            }
        }
        act(player);

    }

}
