/*
 * This is a popup menu for changing the settings
 *
 * --Jacob Allen
 */
/*
 * TODO
 * TIME_OFFSET,
    
    CARD_MARK_FONT, CARD_MARK_FONT_EMP,
        CARD_MARK_TICK_WIDTH, CARD_MARK_TICK_LENGTH, CARD_MARK_TICK_COLOR,
    HOUR_MARK_FONT, HOUR_MARK_FONT_EMP,
        HOUR_MARK_TICK_WIDTH, HOUR_MARK_TICK_LENGTH, HOUR_MARK_TICK_COLOR,
    MIN_MARK_FONT, MIN_MARK_FONT_EMP,
        MIN_MARK_TICK_WIDTH, MIN_MARK_TICK_LENGTH, MIN_MARK_TICK_COLOR
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
        panel.setPreferredSize(new Dimension(width, 2000));
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
        //OPTION: hour present
        CheckBox hPresent=new CheckBox("Hour Hand Present", SettingField.HOUR_PRESENT, Settings.hour.visible);
        panel.add(hPresent.check);
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
        //OPTION: minute present
        CheckBox mPresent=new CheckBox("Minute Hand Present", SettingField.MIN_PRESENT, Settings.min.visible);
        panel.add(mPresent.check);
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
        //OPTION: second present
        CheckBox sPresent=new CheckBox("Second Hand Present", SettingField.SEC_PRESENT, Settings.sec.visible);
        panel.add(sPresent.check);
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
        
        panel.add(new JSeparator());
        
        panel.add(new JLabel("CARDINAL MARKS"));
        //OPTION: cardinal font size
        Slider cFontSize=new Slider("Cardinal Mark Font Size", SettingField.CARD_MARK_FONT_SIZE, 0, 72, Settings.cardinalMark.font.getSize());
        panel.add(cFontSize.label);
        panel.add(cFontSize.slider);
        //OPTION: cardinal roman
        CheckBox cRoman=new CheckBox("Use Roman Numerals", SettingField.CARD_MARK_ROMAN, Settings.cardinalMark.roman);
        panel.add(cRoman.check);
        //OPTION: cardinal mark distance
        Slider cmDist=new Slider("Cardinal Mark Distance", SettingField.CARD_MARK_DIST, 0, 100, (int)(Settings.cardinalMark.distance*100));
        panel.add(cmDist.label);
        panel.add(cmDist.slider);
        //OPTION: cardinal mark color
        ColorSelect cmColor=new ColorSelect("Cardinal Mark Color", SettingField.CARD_MARK_COLOR, Settings.cardinalMark.numberColor);
        panel.add(cmColor.label);
        panel.add(cmColor.button);
        
        panel.add(new JSeparator());
        
        panel.add(new JLabel("CARDINAL TICKS"));
        
        panel.add(new JSeparator());
        
        panel.add(new JLabel("HOUR MARKS"));
        //OPTION: hour font size
        Slider hFontSize=new Slider("Hour Mark Font Size", SettingField.HOUR_MARK_FONT_SIZE, 0, 72, Settings.hourMark.font.getSize());
        panel.add(hFontSize.label);
        panel.add(hFontSize.slider);
        //OPTION: hour roman
        CheckBox hRoman=new CheckBox("Use Roman Numerals", SettingField.HOUR_MARK_ROMAN, Settings.hourMark.roman);
        panel.add(hRoman.check);
        //OPTION: hour mark distance
        Slider hmDist=new Slider("Hour Mark Distance", SettingField.HOUR_MARK_DIST, 0, 100, (int)(Settings.hourMark.distance*100));
        panel.add(hmDist.label);
        panel.add(hmDist.slider);
        //OPTION: hour mark color
        ColorSelect hmColor=new ColorSelect("Hour Mark Color", SettingField.HOUR_MARK_COLOR, Settings.hourMark.numberColor);
        panel.add(hmColor.label);
        panel.add(hmColor.button);
        
        panel.add(new JSeparator());
        
        panel.add(new JLabel("HOUR TICKS"));
        
        panel.add(new JSeparator());
        
        panel.add(new JLabel("MINUTE MARKS"));
        //OPTION: minute font size
        Slider mFontSize=new Slider("Minute Mark Font Size", SettingField.MIN_MARK_FONT_SIZE, 0, 72, Settings.minuteMark.font.getSize());
        panel.add(mFontSize.label);
        panel.add(mFontSize.slider);
        //OPTION: minute roman
        CheckBox mRoman=new CheckBox("Use Roman Numerals", SettingField.MIN_MARK_ROMAN, Settings.minuteMark.roman);
        panel.add(mRoman.check);
        //OPTION: minute mark distance
        Slider mmDist=new Slider("Minute Mark Distance", SettingField.MIN_MARK_DIST, 0, 100, (int)(Settings.minuteMark.distance*100));
        panel.add(mmDist.label);
        panel.add(mmDist.slider);
        //OPTION: minute mark color
        ColorSelect mmColor=new ColorSelect("Minute Mark Color", SettingField.MIN_MARK_COLOR, Settings.minuteMark.numberColor);
        panel.add(mmColor.label);
        panel.add(mmColor.button);
        
        panel.add(new JSeparator());
        
        panel.add(new JLabel("MINUTE TICKS"));
        
        

        //put it on the screen
        this.setVisible(true);
    }
}
