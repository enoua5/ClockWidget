import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
public class Frame extends JFrame
{
    public Canvas c;
    JLabel label;
    public Frame(Canvas c)
    {
        //no title
        super("Clock");
        //add canvas into frame
        this.c=c;
        double r=c.getRatio();
        this.c.setPreferredSize(new Dimension(Settings.diameter, Settings.diameter));
        this.add(c);
        //make it closable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //no resizing the window - in the normal way anyway
        this.setResizable(false);
        //no window border
        this.setUndecorated(true);
        //transparent
        this.setBackground(new Color(1f,1f,1f,0f));
        this.getContentPane().setBackground(new Color(1f,1f,1f,0f));
        //fit it all nicely
        this.pack();
        //put it on the screen
        this.setVisible(true);
    }
}
