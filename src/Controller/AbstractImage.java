
package Controller;

import java.awt.image.BufferedImage;

//clasa abstracta cu rol in pastrarea unor elemente cheie, valabile pentru mai multe clase de imagini, cum ar fi image width si height
//clasele ImgBmp si ImgJpg vor mosteni aceasta clasa

public abstract class AbstractImage implements ImageActions {
    private BufferedImage image;
    private double width;
    private double heigth;
    
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }
    
}
