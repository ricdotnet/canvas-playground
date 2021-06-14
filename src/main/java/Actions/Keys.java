package Actions;

import Entity.Entity;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys implements KeyListener {

    Window window;
    Entity entity;

    public Keys(Window window, Entity entity) {
        this.window = window;
        this.entity = entity;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            int current = 0;
            while(entity.getxVel() < 5) {
                entity.setxVel(current);
                double angle = entity.getRotation();
                entity.setxPos(Math.cos(angle));
                entity.setyPos(Math.sin(angle));

                current += 1;
            }
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            int current = 0;
            while(entity.getxVel() < 5) {
                entity.setyVel(current);
                double angle = entity.getRotation();
                entity.setxPos(-Math.cos(angle));
                entity.setyPos(-Math.sin(angle));
                current += 1;
            }
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(entity.getxVel() != 0)
                entity.setRotation(Math.toRadians(5));
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            if(entity.getxVel() != 0)
                entity.setRotation(-Math.toRadians(5));
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            entity.setxVel(0);
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            entity.setxVel(0);
        }
    }
}
