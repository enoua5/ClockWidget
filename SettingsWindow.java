/*
 * This is a popup menu for changing the settings
 *
 * --Jacob Allen
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SettingsWindow extends JFrame
{
    private static final int width=300;
    public SettingsWindow()
    {
        //set title
        super("Settings");
        //make it closable
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //make a layout
        this.setLayout(new BorderLayout());
        //set the window size
        this.setSize(width+100, width);

        //add a panel
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setPreferredSize(new Dimension(width, 600));

        //add a scroll pane
        final JScrollPane scroll=new JScrollPane(panel);
        this.add(scroll, BorderLayout.CENTER);

        //OPTION: diameter
        Slider diameter=new Slider("Diameter", SettingField.DIAMETER, 10, 1000, Settings.diameter);
        panel.add(diameter.label);
        panel.add(diameter.slider);

        //put it on the screen
        this.setVisible(true);
    }
}
