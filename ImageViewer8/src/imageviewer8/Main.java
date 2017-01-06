/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer8;

import imageviewer8.control.NextImageCommand;
import imageviewer8.control.PrevImageCommand;
import imageviewer8.persistence.ImageLoader;
import imageviewer8.persistence.file.FileImageLoader;

/**
 *
 * @author YonePC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ImageLoader loader = new FileImageLoader("C:\\Users\\YonePC\\Pictures");
        MainFrame mainFrame = new MainFrame();
        mainFrame.add(new NextImageCommand(mainFrame.getImageDisplay()));
        mainFrame.add(new PrevImageCommand(mainFrame.getImageDisplay()));
        mainFrame.getImageDisplay().display(loader.load());
    }
    
}
