
/*
 * toggles the Setting value when selected
 * 
 * --Jacob Allen
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CheckBox implements ChangeListener {
	public JLabel label;
	public SettingField field;
	public JCheckBox check;

	public CheckBox(String name, SettingField fieldName, boolean def) {
		// to keep track of what variable is being changed
		field = fieldName;
		check = new JCheckBox(name, def);
		check.addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		boolean val = check.isSelected();
		switch (field) {
		case HOUR_PRESENT:
			Settings.hour.visible = val;
			break;
		case MIN_PRESENT:
			Settings.min.visible = val;
			break;
		case SEC_PRESENT:
			Settings.sec.visible = val;
			break;

		case CARD_MARK_ROMAN:
			Settings.cardinalMark.roman = val;
			break;
		case HOUR_MARK_ROMAN:
			Settings.hourMark.roman = val;
			break;
		case MIN_MARK_ROMAN:
			Settings.minuteMark.roman = val;
			break;

		case CARD_NUM_PRESENT:
			Settings.cardinalMark.hasNumber = val;
			break;
		case CARD_TICK_PRESENT:
			Settings.cardinalMark.hasTick = val;
			break;
		case HOUR_NUM_PRESENT:
			Settings.hourMark.hasNumber = val;
			break;
		case HOUR_TICK_PRESENT:
			Settings.hourMark.hasTick = val;
			break;
		case MIN_NUM_PRESENT:
			Settings.minuteMark.hasNumber = val;
			break;
		case MIN_TICK_PRESENT:
			Settings.minuteMark.hasTick = val;
			break;
		}
	}
}
