package Display;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;

public class Display {
    private JFrame frame;
    private Canvas canvas;
    //    private JPanel panel;

    private String title;
    private int width, height;

    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    private void createDisplay(){
        frame = new JFrame("Tank Game");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        //        panel = new JPanel();
        //        panel.setPreferredSize(new Dimension(width, height));
        //        panel.setMaximumSize(new Dimension(width, height));
        //        panel.setMinimumSize(new Dimension(width, height));
        //        panel.setFocusable(false);
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        //        frame.add(panel);
        frame.add(canvas);
        frame.pack();
    }

    //    public JPanel getPanel(){
    //        return panel;
    //    }
    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }
}
