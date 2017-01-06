/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer8.persistence.file;

import imageviewer8.model.Image;
import imageviewer8.persistence.ImageLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YonePC
 */
public class FileImageLoader implements ImageLoader {

    File[] files;
    
    public FileImageLoader(String directory){
        files = new File(directory).listFiles(WithExtension());
    }

    public FileImageLoader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Image load() {
        return ImageAt(0);
    }

    private Image ImageAt(int i) {
        return new Image() {
            @Override
            public InputStream inputstream() {
                try {
                    return new FileInputStream(files[i]);
                } catch (FileNotFoundException ex) {
                    return null;
                }
            }

            @Override
            public Image prev() {
                if(i==0) return ImageAt(files.length-1);
                return ImageAt(i-1);
            }

            @Override
            public Image next() {

                if(i==files.length-1) return ImageAt(0);
                return ImageAt(i+1);
            }
        };
    }

    private FilenameFilter WithExtension() {
        return new FilenameFilter() {
            @Override
            public boolean accept(File file, String string) {
                return file.getName().endsWith("jpg");
            }
        };
    }
    
}
