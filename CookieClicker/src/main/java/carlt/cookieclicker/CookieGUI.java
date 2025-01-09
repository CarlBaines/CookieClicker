/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carlt.cookieclicker;

// Imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Carlt
 */
public final class CookieGUI extends MouseAdapter {

    private static final long serialVersionUID = 1L;

    // Attributes
    private ImageIcon iconImg;
    private JFrame cookieFrame;
    private JPanel cookiePanel;
    private JLabel titleLabel;
    private transient ImageIcon cookieImage;
    private transient Image resizedCookieImage;
    private JLabel cookieImgLabel;
    private JLabel cookieCounter;

    // Constructor
    public CookieGUI() {
        
        // Creates new image icon.
        iconImg = new ImageIcon("Assets/subway_cookie.png");
        
        // Configure main frame.
        cookieFrame = new JFrame("Cookie Clicker");
        cookieFrame.setIconImage(iconImg.getImage());
        cookieFrame.setSize(750, 750);
        cookieFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cookieFrame.setResizable(false);

        // Create JPanel and configure its appearance.
        cookiePanel = new JPanel();
        cookiePanel.setBackground(new Color(33, 90, 127));
        cookiePanel.setLayout(new BorderLayout());
        cookiePanel.setOpaque(true);
        cookiePanel.setSize(750, 750);
        cookiePanel.setVisible(true);
        
        // Creates title label and configures its appearance
        titleLabel = new JLabel("Cookie Clicker");
        titleLabel.setBorder(new EmptyBorder(60, 0, 60, 0));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cookiePanel.add(titleLabel, BorderLayout.NORTH);

        // Method calls
        cookieImgLabel = setUpImages();
        cookieImgLabel.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                // If the mouse was clicked on the cookie image label.
                if (e.getSource() == cookieImgLabel) {
                    // Gets the cookie counter label text.
                    String labelText = cookieCounter.getText();
                    // Replaces all non-digits with empty text
                    // Extracts the number of cookies clicked from the cookie counter label text.
                    int cookiesClicked = Integer.parseInt(labelText.replaceAll("[^0-9]", ""));
                    // Adds one to the current value of cookies clicked.
                    cookiesClicked += 1;
                    // Updates the text to increment the number of cookies clicked.
                    cookieCounter.setText("Cookies Clicked: " + cookiesClicked);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //System.out.println(e.getSource());
                
                // If the mouse enters the cookie image label.
                if (e.getSource() == cookieImgLabel) {
                    // Creates resized cookie image by getting the icon width and height of the original cookie image
                    // and adding five pixels to each.
                    // Scales the image smoothly.
                    resizedCookieImage = cookieImage.getImage().getScaledInstance(
                                    cookieImage.getIconWidth() + 10,
                                    cookieImage.getIconHeight() + 10,
                                    Image.SCALE_SMOOTH);
                    ImageIcon resizedCookieIcon = new ImageIcon(resizedCookieImage);
                    // Sets the icon in the cookie image label to be the resized cookie icon.
                    cookieImgLabel.setIcon(resizedCookieIcon);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // If the mouse exits the cookie image label.
                if (e.getSource() == cookieImgLabel) {
                    // Sets the icon in the cookie image label to the original-sized cookie image.
                    cookieImgLabel.setIcon(cookieImage);
                }
            }
        });
        
        // Sets up the cookie counter label.
        cookieCounter = setUpCookieCounter();

        // Add the components to the cookie panel.
        cookiePanel.add(cookieImgLabel, BorderLayout.CENTER);
        cookiePanel.add(cookieCounter, BorderLayout.SOUTH);

        // Add the cookie panel to mainFrame.
        cookieFrame.add(cookiePanel);
        cookieFrame.setVisible(true);

    }

    public JLabel setUpImages() {
        // Creates and returns a cookie image as a JLabel.
        cookieImage = new ImageIcon("Assets/subway_cookie.png");
        return new JLabel(cookieImage);

    }

    public JLabel setUpCookieCounter() {
        // Create cookie counter label.
        cookieCounter = new JLabel("Cookies Clicked: 0");
        cookieCounter.setBorder(new EmptyBorder(0, 0, 150, 0));
        cookieCounter.setForeground(Color.WHITE);
        cookieCounter.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        // Center it
        cookieCounter.setHorizontalAlignment(SwingConstants.CENTER);

        return cookieCounter;

    }

}
