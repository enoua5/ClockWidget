
/*
 * For setting the fonts
 * Changes Settings value on change
 * 
 * --Jacob Allen
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.deepak.jfontchooser.JFontChooser;

public class FontSelect implements ActionListener {
	public JLabel label;
	public SettingField field;
	public JButton button;
	public Font font;
	public Color color;

	public FontSelect(String name, SettingField fieldName, Font defFont, Color defColor) {
		// to keep track of what variable is being changed
		field = fieldName;
		// set the font and color to the default
		font = defFont;
		color = defColor;
		// build the components
		label = new JLabel(name);
		button = new JButton("Choose Font");
		button.setOpaque(true);
		button.setFont(font);
		button.setForeground(color);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFontChooser p = new JFontChooser("Choose Font");
		int selectedOption = p.showTextChooserDialog(font.getFontName(), font.getStyle(), font.getSize(), color,
				"Example text 1234");
		if (selectedOption == JFontChooser.APPROVE_OPTION) {
			font = p.getSelectedFont();
			button.setFont(font);
			color = p.getSelectedTextColor();
			button.setForeground(color);
			switch (field) {
			case CARD_MARK_FONT:
				Settings.cardinalMark.font = font;
				Settings.cardinalMark.numberColor = color;
				break;
			case HOUR_MARK_FONT:
				Settings.hourMark.font = font;
				Settings.hourMark.numberColor = color;
				break;
			case MIN_MARK_FONT:
				Settings.minuteMark.font = font;
				Settings.minuteMark.numberColor = color;
				break;
			}
		}
	}
}
