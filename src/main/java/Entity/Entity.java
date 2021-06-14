package Entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;

public class Entity extends JComponent {

    private double xPos;
    private double yPos;
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
//        this.xPos += xVel;
//        this.xPos -= yVel;

        if(xVel > 0) {
            move();
        }

//        double angle = getRotation();
//        this.xPos += Math.cos(angle);
//        this.yPos += Math.sin(angle);
    }

    public void move() {
        this.xPos += Math.cos(getRotation());
        this.yPos += Math.sin(getRotation());
    }

    public void render(Graphics2D g) {
        drawEntity(g);
    }

    public void drawEntity(Graphics2D entity) {
        entity.setBackground(Color.BLACK);
        entity.rotate(rotation, xPos+16, yPos+8);
//        entity.drawRect(xPos, yPos, 32, 32);
//        entity.fillRect(xPos, yPos, 32, 32);
        entity.drawImage(image, (int) xPos, (int) yPos, this);

        entity.setColor(Color.WHITE);
        entity.drawString(String.valueOf(Math.toDegrees(getRotation())), (int) xPos, (int) yPos-10);
    }

    public void setxPos(double xPos) {
        this.xPos += xPos;
    }
    public void setyPos(double yPos) {
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

    public double getxPos() {
        return xPos;
    }
    public double getyPos() {
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
