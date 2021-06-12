package Entity;

import javax.swing.*;
import java.awt.*;

public class Entity extends JPanel {

    private int xPos;
    private int yPos;
    private double rotation;

    public Entity(int xPos, int yPos, double rotation) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rotation = rotation;
    }

    public void render(Graphics2D g) {
        drawEntity(g);
    }

    public void drawEntity(Graphics2D entity) {
        entity.setBackground(Color.BLACK);
        entity.rotate(rotation, xPos+16, yPos+16);
        entity.drawRect(xPos, yPos, 32, 32);
        entity.fillRect(xPos, yPos, 32, 32);
    }

    public void setxPos(int xPos) {
        this.xPos += xPos;
    }
    public void setyPos(int yPos) {
        this.yPos += yPos;
    }
    public void setRotation(double rotation) {
        this.rotation += rotation;
    }

    public int getxPos() {
        return xPos;
    }
    public int getyPos() {
        return yPos;
    }
    public double getRotation() {
        return rotation;
    }

}
