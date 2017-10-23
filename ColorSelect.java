/*
 * Brings up a color select menu when clicked
 * Sets the Setting value when selected
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorSelect implements ActionListener
{
    public JLabel label;
    public SettingField field;
    public JButton button;
    public Color color;
    public ColorSelect(String name, SettingField fieldName, Color def)
    {
        //to keep track of what variable is being changed
        field=fieldName;
        //set the color to the default
        color=def;
        //build the components
        label=new JLabel(name);
        button=new JButton("Choose Color");
        button.setOpaque(true);
        button.setBackground(color);
        button.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Color c=JColorChooser.showDialog(null, "Choose a Color", color);
        if(c!=null)
        {
            color=c;
            button.setBackground(color);
            switch(field)
            {
                case FACE_COLOR:
                    Settings.faceColor=color;
                    break;
                case HOUR_COLOR:
                    break;
                case MIN_COLOR:
                    break;
                case SEC_COLOR:
                    break;
                case CARD_MARK_COLOR:
                    break;
                case CARD_MARK_TICK_COLOR:
                    break;
                case HOUR_MARK_COLOR:
                    break;
                case HOUR_MARK_TICK_COLOR:
                    break;
                case MIN_MARK_COLOR:
                    break;
                case MIN_MARK_TICK_COLOR:
                    break;
            }
        }
    }
}
