/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer8.ui;

import imageviewer8.model.Image;

/**
 *
 * @author YonePC
 */
public interface ImageDisplay {
    public void display(Image image);
    public Image current();
}
