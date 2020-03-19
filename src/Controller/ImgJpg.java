
package Controller;

import java.awt.image.BufferedImage;
import java.io.File;

//are rol de exemplu pentru a demonstra utilitatea clasei abstracte

public class ImgJpg extends AbstractImage {

    @Override
    public File readImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BufferedImage detectEdges() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
