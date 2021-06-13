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
            while(entity.getxVel() < 10) {
                entity.setxVel(current);
                current += 1;
            }
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            int current = 0;
            while(entity.getyVel() < 10) {
                entity.setyVel(current);
                current += 1;
            }
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            entity.setRotation(Math.toRadians(1));
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            entity.setRotation(-Math.toRadians(1));
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            entity.setxVel(0);
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            entity.setyVel(0);
        }
    }
}
