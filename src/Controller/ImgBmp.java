package Controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ImgBmp extends AbstractImage{
  
    File selectedFile = null;  
    
    //suprascriere metoda din interfata
    @Override
    public File readImage() {
        //ne folosim de JFileChooser pentru a cauta imaginea dorita
        //dupa ce gasim calea, o returnez pentru a insera imaginea in jlabelul din form
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("C:/Users/Cosmin/Desktop/Proiect_AWJ/resources"));
        int action = chooser.showOpenDialog(null);
           if (action == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();  
            }
           else if(action == JFileChooser.CANCEL_OPTION) {
               JOptionPane.showMessageDialog(null, "Nu s-a selectat nicio imagine");
           }
           return selectedFile;
    };
    
    //suprascriere metoda din interfata
    @Override
    public BufferedImage detectEdges() {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(selectedFile.getPath())); //utilizand calea aleasa anterior, transpunem imaginea intr-un
                                                                            //bufferImage si o trimited spre procesare pentru aflare edges
        } catch (IOException ex) {
            Logger.getLogger(ImgBmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bufferedImage;
    }
   
}
