/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carlt.cookieclicker;

import java.awt.Graphics;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Carlt
 */
public class BackgroundImage extends JPanel {
    
    private static final long serialVersionUID = 1L;
    
    private ImageIcon bg;
    
    public BackgroundImage(String imagePath){
        //System.out.println("Background image instantiated.");
        bg = new ImageIcon(imagePath);
//        
//        if (bg.getImageLoadStatus() != MediaTracker.COMPLETE) {
//            System.out.println("Image not loaded properly: " + imagePath);
//        } else {
//            System.out.println("Image loaded successfully: " + imagePath);
//        }
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if (bg != null){
            g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), this);
            //System.out.println("Painting background image.");
            
        } else{
            //System.out.println("Background image is null.");
        }
    }
    
}