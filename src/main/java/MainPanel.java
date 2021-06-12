import Entity.Entity;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    Window window;

    public MainPanel(Window window) {
        this.window = window;

        setSize(window.WIDTH, window.HEIGHT);
        setBackground(new Color(150, 245, 105));
    }

}
