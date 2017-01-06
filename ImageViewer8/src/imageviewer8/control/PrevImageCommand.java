/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer8.control;

import imageviewer8.ui.ImageDisplay;

/**
 *
 * @author YonePC
 */
public class PrevImageCommand implements Command {

    private final ImageDisplay imageDisplay;
    
    public PrevImageCommand(ImageDisplay imageDisplay){
        this.imageDisplay = imageDisplay;
    }
    
    @Override
    public String name() {
        return "prev";
    }

    @Override
    public void execute() {
        imageDisplay.display(imageDisplay.current().prev());
    }
    
}
