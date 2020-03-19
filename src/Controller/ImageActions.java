
package Controller;

import java.awt.image.BufferedImage;
import java.io.File;

//interfata ce obliga o alta clasa sa implementeze metodele
//acestea definesc ''actiunile'' imaginii
public interface ImageActions {
    File readImage();
    BufferedImage detectEdges();
}
