
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
			Settings.current.hour.visible = val;
			break;
		case MIN_PRESENT:
			Settings.current.min.visible = val;
			break;
		case SEC_PRESENT:
			Settings.current.sec.visible = val;
			break;

		case CARD_MARK_ROMAN:
			Settings.current.cardinalMark.roman = val;
			break;
		case HOUR_MARK_ROMAN:
			Settings.current.hourMark.roman = val;
			break;
		case MIN_MARK_ROMAN:
			Settings.current.minuteMark.roman = val;
			break;

		case CARD_NUM_PRESENT:
			Settings.current.cardinalMark.hasNumber = val;
			break;
		case CARD_TICK_PRESENT:
			Settings.current.cardinalMark.hasTick = val;
			break;
		case HOUR_NUM_PRESENT:
			Settings.current.hourMark.hasNumber = val;
			break;
		case HOUR_TICK_PRESENT:
			Settings.current.hourMark.hasTick = val;
			break;
		case MIN_NUM_PRESENT:
			Settings.current.minuteMark.hasNumber = val;
			break;
		case MIN_TICK_PRESENT:
			Settings.current.minuteMark.hasTick = val;
			break;
		}
	}
}
