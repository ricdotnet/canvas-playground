package Entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;

public class Entity extends JComponent {

    private int xPos;
    private int yPos;
    private int xVel;
    private int yVel;
    private double rotation;

    private BufferedImage image;

    public Entity(int xPos, int yPos, double rotation) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rotation = rotation;

//        image = new BufferedImage(0, 0, 0);
        try {
            image = ImageIO.read(getClass().getResource("/car.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        this.xPos += xVel;
        this.xPos -= yVel;
    }

    public void render(Graphics2D g) {
        drawEntity(g);
    }

    public void drawEntity(Graphics2D entity) {
        entity.setBackground(Color.BLACK);
        entity.rotate(rotation, xPos+16, yPos+16);
//        entity.drawRect(xPos, yPos, 32, 32);
//        entity.fillRect(xPos, yPos, 32, 32);
        entity.drawImage(image, xPos, yPos, this);

        entity.setColor(Color.WHITE);
        entity.drawString(String.valueOf(Math.toDegrees(getRotation())), (int) xPos, (int) yPos-10);
    }

    public void setxPos(int xPos) {
        this.xPos += xPos;
    }
    public void setyPos(int yPos) {
        this.yPos += yPos;
    }
    public void setxVel(int xVel) {
        this.xVel = xVel;
    }
    public void setyVel(int yVel) {
        this.yVel = yVel;
    }
    public void setRotation(double rotation) {
        if(Math.toDegrees(this.rotation) > 360) {
            this.rotation = 0;
            return;
        }
        if(Math.toDegrees(this.rotation) < -360) {
            this.rotation = 0;
            return;
        }
        this.rotation += rotation;
    }

    public int getxPos() {
        return xPos;
    }
    public int getyPos() {
        return yPos;
    }
    public double getxVel() {
        return xVel;
    }
    public double getyVel() {
        return yVel;
    }
    public double getRotation() {
        DecimalFormat newRotation = new DecimalFormat("0.00");
        return Double.parseDouble(newRotation.format(rotation));
    }

}
