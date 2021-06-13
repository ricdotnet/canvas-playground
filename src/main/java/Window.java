import Actions.*;
import Entity.Entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Window extends JFrame implements Runnable {

    public final int WIDTH = 640;
    public final int HEIGHT = 480;

    private BufferStrategy bufferStrategy;
    private BufferedImage bg;

    GameLoop gameLoop = new GameLoop(this);
    Entity entity;

    MainMenu mainMenu = new MainMenu(this);

    public Window() {

    }

    public static void main(String args[]) {
        new Window().run();
    }

    public void init() {
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        mainWindow.add(mainMenu);
        setVisible(true);

        entity = new Entity(250, 250, Math.toRadians(0));
        try {
            bg = ImageIO.read(getClass().getResource("/bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addKeyListener(new Keys(this, entity));
    }

    @Override
    public void run() {
        init();
        gameLoop.loop();
    }

    public void tick() {
        entity.tick();
    }

    public void render() {
        bufferStrategy = getBufferStrategy();
        if(bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
        // ---------- //

        graphics.drawImage(bg, 0, 0, this);

        entity.render(graphics);

        // ---------- //
        graphics.dispose();
        bufferStrategy.show();
    }
}