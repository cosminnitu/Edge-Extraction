/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.EdgeDetection;
import Controller.ImgBmp;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Form extends javax.swing.JFrame {
  
    private final ImgBmp img = new ImgBmp(); //o noua instanta de imagine curenta
    private final EdgeDetection edgeDetection = new EdgeDetection(); //ne vom utiliza de aceasta instanta pentru a realiza procesul de edge extraction
    private File selectedFile = null;
    private Image image = null;
    
    public Form() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        FilterType = new javax.swing.JComboBox<>();
        ChooseImage = new javax.swing.JButton();
        Detect = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        InputLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        OutputLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FilterType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horizontal Filter", "Vertical Filter", "Sobel Vertical Filter", "Sobel Horizontal Filter", "Scharr Vertical Filter", "Scharr Horizontal Filter" }));
        FilterType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterTypeActionPerformed(evt);
            }
        });

        ChooseImage.setText("Choose Image");
        ChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseImageActionPerformed(evt);
            }
        });

        Detect.setText("Detect Edges");
        Detect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(FilterType, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(Detect, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Detect, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(FilterType, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(InputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InputLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OutputLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OutputLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(498, 498, 498)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FilterTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FilterTypeActionPerformed

    private void ChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseImageActionPerformed
        //utilizare nanoTime pentru aflarea timpului de citire al imaginii
        long startTime = System.nanoTime();
        selectedFile = img.readImage(); //extragem path-ul imaginii din instanta curenta si il vom folosi pentru a afisa continutul in JLabel 
        try{
                image = ImageIO.read(selectedFile);
                ImageIcon imIcon = new ImageIcon(image);
                //realizam resize in functie de dimensiunea label-ului pentru a nu avea imagini ce depasesc limitele impuse
                image = imIcon.getImage().getScaledInstance(InputLabel.getWidth(),InputLabel.getHeight(), Image.SCALE_SMOOTH);
                InputLabel.setIcon(new ImageIcon(image)); // intr-un label putem pune doar un ImageIcon
                //utilizam setter pentru a salva imaginea in instanta, impreuna cu dimensiunile acesteia
                OutputLabel.setIcon(null);
                img.setImage(ImageIO.read(new File(selectedFile.getPath())));
                img.setWidth(img.getImage().getWidth());
                img.setHeigth(img.getImage().getHeight());
                
           }catch(IOException e) {
                e.printStackTrace();
           }
        //aflam timpul final, apoi calculam cat a durat procesul de citire a imaginii
        long endTime = System.nanoTime();
        double totalTime = (double)(endTime - startTime);
        System.out.println("Timp de executie - ReadImage: " + totalTime / 1.0E9D + " secunde");
    }//GEN-LAST:event_ChooseImageActionPerformed

    private void DetectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetectActionPerformed
        long startTime = System.nanoTime();
        try {
            //am trimis spre procesare imaginea de tip bufferimage, impreuna cu filtrul ales ce va determina forma finala a contururilor
            File convolvedFile = edgeDetection.detectEdges(img.detectEdges(), (String) FilterType.getSelectedItem());   
            //convolved File - obiect de timp File in care am extras rezultatul dupa procesare
            //in continuare, pentru a afisa noua imagine intr-un jlabel, trebuie sa o transformam in ImageIcon
            image = ImageIO.read(convolvedFile);
            ImageIcon imIcon = new ImageIcon(image);
            image = imIcon.getImage().getScaledInstance(OutputLabel.getWidth(),OutputLabel.getHeight(), Image.SCALE_SMOOTH);
            OutputLabel.setIcon(new ImageIcon(image));
            
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        //afiasre timp executie pentru detectarea marginilor
        long endTime = System.nanoTime();
        double totalTime = (double)(endTime - startTime);
        System.out.println("Timp de executie - detectEdges: " + totalTime / 1.0E9D + " secunde");
        System.out.println();
    }//GEN-LAST:event_DetectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChooseImage;
    private javax.swing.JButton Detect;
    private javax.swing.JComboBox<String> FilterType;
    private javax.swing.JLabel InputLabel;
    private javax.swing.JLabel OutputLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
