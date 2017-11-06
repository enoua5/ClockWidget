/*
 * This is a popup menu for changing the settings
 *
 * --Jacob Allen
 */
/*
 * Changed some label values
 */
/*
 * TODO
 * TIME_OFFSET,
    
    HOUR_COLOR, HOUR_PRESENT,
    MIN_COLOR, MIN_PRESENT,
    SEC_COLOR, SEC_PRESENT,
    
    CARD_MARK_FONT, CARD_MARK_FONT_EMP, CARD_MARK_FONT_SIZE, CARD_MARK_ROMAN, CARD_MARK_DIST,
        CARD_MARK_COLOR, CARD_MARK_TICK_WIDTH, CARD_MARK_TICK_LENGTH, CARD_MARK_TICK_COLOR,
    HOUR_MARK_FONT, HOUR_MARK_FONT_EMP, HOUR_MARK_FONT_SIZE, HOUR_MARK_ROMAN, HOUR_MARK_DIST,
        HOUR_MARK_COLOR, HOUR_MARK_TICK_WIDTH, HOUR_MARK_TICK_LENGTH, HOUR_MARK_TICK_COLOR,
    MIN_MARK_FONT, MIN_MARK_FONT_EMP, MIN_MARK_FONT_SIZE, MIN_MARK_ROMAN, MIN_MARK_DIST,
        MIN_MARK_COLOR, MIN_MARK_TICK_WIDTH, MIN_MARK_TICK_LENGTH, MIN_MARK_TICK_COLOR
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
        Slider diameter=new Slider("Clock Diameter", SettingField.DIAMETER, 10, 1000, Settings.diameter);
        panel.add(diameter.label);
        panel.add(diameter.slider);
        //OPTION: face color
        ColorSelect faceColor=new ColorSelect("Face Color", SettingField.FACE_COLOR, Settings.faceColor);
        panel.add(faceColor.label);
        panel.add(faceColor.button);
        
        panel.add(new JSeparator());
        
        panel.add(new JLabel("HOUR HAND"));
        //OPTION: hour length
        Slider hLen=new Slider("Hour Hand Length", SettingField.HOUR_LENGTH, 0, 100, (int)(Settings.hour.length*100));
        panel.add(hLen.label);
        panel.add(hLen.slider);
        //OPTION: hour width
        Slider hWid=new Slider("Hour Hand Width", SettingField.HOUR_WIDTH, 0, 20, (int)(Settings.hour.width));
        panel.add(hWid.label);
        panel.add(hWid.slider);
        //OPTION: hour color
        ColorSelect hColor=new ColorSelect("Hour Hand Color", SettingField.HOUR_COLOR, Settings.hour.color);
        panel.add(hColor.label);
        panel.add(hColor.button);
        
        panel.add(new JSeparator());
        
        panel.add(new JLabel("MINUTE HAND"));
        //OPTION: minute length
        Slider mLen=new Slider("Minute Hand Length", SettingField.MIN_LENGTH, 0, 100, (int)(Settings.min.length*100));
        panel.add(mLen.label);
        panel.add(mLen.slider);
        //OPTION: minute width
        Slider mWid=new Slider("Minute Hand Width", SettingField.MIN_WIDTH, 0, 20, (int)(Settings.min.width));
        panel.add(mWid.label);
        panel.add(mWid.slider);
        //OPTION: minute color
        ColorSelect mColor=new ColorSelect("Minute Hand Color", SettingField.MIN_COLOR, Settings.min.color);
        panel.add(mColor.label);
        panel.add(mColor.button);
        
        panel.add(new JSeparator());
        
        panel.add(new JLabel("SECOND HAND"));
        //OPTION: second length
        Slider sLen=new Slider("Second Hand Length", SettingField.SEC_LENGTH, 0, 100, (int)(Settings.sec.length*100));
        panel.add(sLen.label);
        panel.add(sLen.slider);
        //OPTION: second width
        Slider sWid=new Slider("Second Hand Width", SettingField.SEC_WIDTH, 0, 20, (int)(Settings.sec.width));
        panel.add(sWid.label);
        panel.add(sWid.slider);
        //OPTION: hour color
        ColorSelect sColor=new ColorSelect("Second Hand Color", SettingField.SEC_COLOR, Settings.sec.color);
        panel.add(sColor.label);
        panel.add(sColor.button);
        
        

        //put it on the screen
        this.setVisible(true);
    }
}
