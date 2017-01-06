/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer8.ui.swing;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;
import imageviewer8.model.Image;
import imageviewer8.ui.ImageDisplay;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author YonePC
 */
public class SwingImageDiplay extends JFrame implements ImageDisplay {

    private Image image;

    @Override
    public void paint(Graphics g) {
        g.drawImage(bitmap(), 0, 0, this.getWidth(), this.getHeight(), null);
        
        
    }
    
    public BufferedImage bitmap(){
        try {
            return ImageIO.read(image.inputstream());
        } catch (IOException ex) {
            return null;
        }
    }
    

    
    @Override
    public void display(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    public Image current() {
        return image;
    }
    
}
