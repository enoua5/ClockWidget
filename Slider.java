
/*
 * Slider for the setting
 * Changes Settings value on change
 * 
 * --Jacob Allen
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Slider implements ChangeListener {
	public JLabel label;
	public JSlider slider;
	public SettingField field;

	public Slider(String name, SettingField fieldName, int min, int max, int def) {
		// to keep track of what variable is being changed
		field = fieldName;
		// build the components
		label = new JLabel(name);
		slider = new JSlider(JSlider.HORIZONTAL, min, max, def);
		slider.addChangeListener(this);
	}

	// listen to the slider
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		int val = (int) source.getValue();
		switch (field) {
		case DIAMETER:
			Settings.diameter = val;
			Main.frame.setSize(val, val);
			break;

		case HOUR_LENGTH:
			Settings.hour.length = (double) val / 100;
			break;
		case HOUR_WIDTH:
			Settings.hour.width = val;
			break;

		case MIN_LENGTH:
			Settings.min.length = (double) val / 100;
			break;
		case MIN_WIDTH:
			Settings.min.width = val;
			break;

		case SEC_LENGTH:
			Settings.sec.length = (double) val / 100;
			break;
		case SEC_WIDTH:
			Settings.sec.width = val;
			break;
		}
	}
}
