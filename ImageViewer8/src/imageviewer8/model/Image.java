/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer8.model;

import java.io.InputStream;

/**
 *
 * @author YonePC
 */
public interface Image {
    public InputStream inputstream();
    public Image prev();
    public Image next();
}
