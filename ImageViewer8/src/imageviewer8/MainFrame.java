/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer8;

import imageviewer8.control.Command;
import imageviewer8.ui.ImageDisplay;
import imageviewer8.ui.swing.SwingImageDiplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Compiler.command;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author YonePC
 */
public class MainFrame extends JFrame {

    private ImageDisplay imageDisplay;
    private Map<String, Command> commands = new HashMap<>();

    
    public MainFrame(){
        setTitle("Image Viewer");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(image());
        add(toolbar(), BorderLayout.SOUTH);
        setVisible(true);
    }

    public void add(Command command){
        commands.put(command.name(), command);
    }
    
    public ImageDisplay getImageDisplay(){
        return imageDisplay;
    }
    
    private Component image() {
        final SwingImageDiplay display = new SwingImageDiplay();
        imageDisplay = display;
        return display;
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(button("prev"));
        panel.add(button("next"));
        return panel;
        
    }

    private Component button(String name) {
        JButton button = new JButton(icon(name));
        button.addActionListener(execute(name));
        return button;
    }

    private ActionListener execute(final String command) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.get(command).execute();
            }
        };
    }

    private ImageIcon icon(String name) {
        return new ImageIcon("res/" + name + ".png");
    }

}
