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
        GridLayout gLay=new GridLayout(0,1);
        panel.setLayout(gLay);
        
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setPreferredSize(new Dimension(width, 600));
        //add a scroll pane
        final JScrollPane scroll=new JScrollPane(panel);
        this.add(scroll, BorderLayout.CENTER);

        panel.add(new JLabel("CLOCK FACE"));
        //OPTION: diameter
        Slider diameter=new Slider("Diameter", SettingField.DIAMETER, 10, 1000, Settings.diameter);
        panel.add(diameter.label);
        panel.add(diameter.slider);
        
        //OPTION: face color
        ColorSelect faceColor=new ColorSelect("Face Color", SettingField.FACE_COLOR, Settings.faceColor);
        panel.add(faceColor.label);
        panel.add(faceColor.button);
        
        panel.add(new JSeparator());
        
        panel.add(new JLabel("HOUR HAND"));
        //OPTION: hour length
        Slider hLen=new Slider("Length", SettingField.HOUR_LENGTH, 0, 100, (int)(Settings.hour.length*100));
        panel.add(hLen.label);
        panel.add(hLen.slider);
        

        //put it on the screen
        this.setVisible(true);
    }
}
