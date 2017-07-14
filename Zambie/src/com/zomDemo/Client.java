package com.zomDemo;

import com.zomDemo.zombies.Zombie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by Nicholas on 7/11/2017.
 */
public class Client extends JApplet implements KeyListener {
    Player player;
    private Graphics bg;
    private Image offscreen;
    Timer timer;
    private ArrayList<String> dirs;
    ArrayList<Zombie>zeds;

    public void init() {
        Rectangle screen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        offscreen = createImage(screen.width, screen.height);
        bg = offscreen.getGraphics();
        zeds = new ArrayList<>();
        for(int i=0; i < 100; i++){
            zeds.add(new Zombie(new Rectangle((int)(Math.random()*screen.width),(int)(Math.random()*screen.height),15,15 )));
        }
        Timer timer = new Timer(30, ae -> {

            player.move(dirs);
            for(Zombie zed:zeds){
            zed.move(player);
            }
            repaint();

        });
        player = new Player();


        setFocusable(true);
        addKeyListener(this);
        dirs = new ArrayList<>();
        setSize(screen.width, screen.height);
        timer.start();
    }


    public void paint(Graphics g) {

        bg.clearRect(0, 0, offscreen.getWidth(this), offscreen.getHeight(this));

        player.draw(bg);
        for(Zombie zed:zeds){
        zed.draw(bg);}

        g.drawImage(offscreen, 0, 0, this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w'&& !dirs.contains("up")) {
            dirs.add("up");
        }
        if (e.getKeyChar() == 'd'&& !dirs.contains("right")) {
            dirs.add("right");
        }
        if (e.getKeyChar() == 'a'&& !dirs.contains("left")) {
            dirs.add("left");
        }
        if (e.getKeyChar() == 's'&& !dirs.contains("down")) {
            dirs.add("down");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            dirs.remove("up");
        }
        if (e.getKeyChar() == 'd') {
            dirs.remove("right");
        }
        if (e.getKeyChar() == 'a') {
            dirs.remove("left");
        }
        if (e.getKeyChar() == 's') {
            dirs.remove("down");
        }
    }
}