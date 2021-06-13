import Entity.Entity;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {

    Window window;
    JButton play = new JButton();

    public MainMenu(Window window) {
        this.window = window;

        setMinimumSize(new Dimension(window.WIDTH, window.HEIGHT));
        setSize(window.WIDTH, window.HEIGHT);
        setBackground(new Color(150, 245, 105));
        setLayout(null);

        play.setText("Play");
        play.setSize(100, 30);
        play.setLocation((int) window.WIDTH/2 - 55, 50);

        add(play);
    }

}
