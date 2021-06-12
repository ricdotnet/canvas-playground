import Entity.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Window extends JFrame {

    public final int WIDTH = 640;
    public final int HEIGHT = 480;
    private boolean RUNNING = true;

    private BufferStrategy bufferStrategy;

    static Window window = new Window();
    MainPanel mainPanel = new MainPanel(this);
    Entity entity;

    public Window() {
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        entity = new Entity(10, 100, Math.toRadians(0));

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
                    entity.setRotation(Math.toRadians(5));
                }
                if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
                    entity.setRotation(Math.toRadians(-5));
                }
                if(keyEvent.getKeyCode() == KeyEvent.VK_UP) {
                    entity.setyPos(5);
                }
                if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                    entity.setyPos(-5);
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
//                if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
//                    entity.setxPos(0);
//                }
            }
        });
    }

    public static void main(String args[]) {
        window.setVisible(true);
        window.add(window.mainPanel);

//        new Window().run();

        while (window.RUNNING) {
//            System.out.println("hey");
            window.render();
        }
    }

    public void render() {
        repaint();
    }

    /**
     * Render the graphics
     */
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        entity.render(g2d);
    }

//    @Override
//    public void run() {
//        while (RUNNING) {
////            System.out.println("hey");
//            render();
//        }
//    }
}