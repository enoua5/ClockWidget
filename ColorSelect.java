
/*
 * Brings up a color select menu when clicked
 * Sets the Setting value when selected
 * 
 * --Jacob Allen
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorSelect implements ActionListener {
	public JLabel label;
	public SettingField field;
	public JButton button;
	public Color color;

	public ColorSelect(String name, SettingField fieldName, Color def) {
		// to keep track of what variable is being changed
		field = fieldName;
		// set the color to the default
		color = def;
		// build the components
		label = new JLabel(name);
		button = new JButton("Choose Color");
		button.setOpaque(true);
		button.setBackground(color);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color c = JColorChooser.showDialog(null, "Choose a Color", color);
		if (c != null) {
			color = c;
			button.setBackground(color);
			switch (field) {
			case FACE_COLOR:
				Settings.faceColor = color;
				break;
			case HOUR_COLOR:
				Settings.hour.color = color;
				break;
			case MIN_COLOR:
				Settings.min.color = color;
				break;
			case SEC_COLOR:
				Settings.sec.color = color;
				break;
			case CARD_MARK_TICK_COLOR:
				Settings.cardinalMark.tickColor = color;
				break;
			case HOUR_MARK_TICK_COLOR:
				Settings.hourMark.tickColor = color;
				break;
			case MIN_MARK_TICK_COLOR:
				Settings.minuteMark.tickColor = color;
				break;
			}
		}
	}
}
