
/*
 * This is a popup menu for changing the Settings
 *
 * --Jacob Allen
 */
/*
 * TODO
 * TIME_OFFSET
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SettingsWindow extends JFrame {
	private static final int width = 300;

	public SettingsWindow() {
		// set title
		super("Settings");
		// make it closable
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// make a layout
		this.setLayout(new BorderLayout());
		// set the window size
		this.setSize(width + 100, width);

		// add a panel
		JPanel panel = new JPanel();
		GridLayout gLay = new GridLayout(0, 1);
		panel.setLayout(gLay);

		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setPreferredSize(new Dimension(width, 2000));
		// add a scroll pane
		final JScrollPane scroll = new JScrollPane(panel);
		this.add(scroll, BorderLayout.CENTER);

		panel.add(new JLabel("CLOCK FACE"));
		// OPTION: diameter
		Slider diameter = new Slider("Clock Diameter", SettingField.DIAMETER, 10, 1000, Settings.current.current.diameter);
		panel.add(diameter.label);
		panel.add(diameter.slider);
		// OPTION: face color
		ColorSelect faceColor = new ColorSelect("Face Color", SettingField.FACE_COLOR, Settings.current.faceColor);
		panel.add(faceColor.label);
		panel.add(faceColor.button);

		panel.add(new JSeparator());

		panel.add(new JLabel("HOUR HAND"));
		// OPTION: hour present
		CheckBox hPresent = new CheckBox("Hour Hand Present", SettingField.HOUR_PRESENT, Settings.current.hour.visible);
		panel.add(hPresent.check);
		// OPTION: hour length
		Slider hLen = new Slider("Hour Hand Length", SettingField.HOUR_LENGTH, 0, 100,
				(int) (Settings.current.hour.length * 100));
		panel.add(hLen.label);
		panel.add(hLen.slider);
		// OPTION: hour width
		Slider hWid = new Slider("Hour Hand Width", SettingField.HOUR_WIDTH, 0, 20, (int) (Settings.current.hour.width));
		panel.add(hWid.label);
		panel.add(hWid.slider);
		// OPTION: hour color
		ColorSelect hColor = new ColorSelect("Hour Hand Color", SettingField.HOUR_COLOR, Settings.current.hour.color);
		panel.add(hColor.label);
		panel.add(hColor.button);

		panel.add(new JSeparator());

		panel.add(new JLabel("MINUTE HAND"));
		// OPTION: minute present
		CheckBox mPresent = new CheckBox("Minute Hand Present", SettingField.MIN_PRESENT, Settings.current.min.visible);
		panel.add(mPresent.check);
		// OPTION: minute length
		Slider mLen = new Slider("Minute Hand Length", SettingField.MIN_LENGTH, 0, 100,
				(int) (Settings.current.min.length * 100));
		panel.add(mLen.label);
		panel.add(mLen.slider);
		// OPTION: minute width
		Slider mWid = new Slider("Minute Hand Width", SettingField.MIN_WIDTH, 0, 20, (int) (Settings.current.min.width));
		panel.add(mWid.label);
		panel.add(mWid.slider);
		// OPTION: minute color
		ColorSelect mColor = new ColorSelect("Minute Hand Color", SettingField.MIN_COLOR, Settings.current.min.color);
		panel.add(mColor.label);
		panel.add(mColor.button);

		panel.add(new JSeparator());

		panel.add(new JLabel("SECOND HAND"));
		// OPTION: second present
		CheckBox sPresent = new CheckBox("Second Hand Present", SettingField.SEC_PRESENT, Settings.current.sec.visible);
		panel.add(sPresent.check);
		// OPTION: second length
		Slider sLen = new Slider("Second Hand Length", SettingField.SEC_LENGTH, 0, 100,
				(int) (Settings.current.sec.length * 100));
		panel.add(sLen.label);
		panel.add(sLen.slider);
		// OPTION: second width
		Slider sWid = new Slider("Second Hand Width", SettingField.SEC_WIDTH, 0, 20, (int) (Settings.current.sec.width));
		panel.add(sWid.label);
		panel.add(sWid.slider);
		// OPTION: second color
		ColorSelect sColor = new ColorSelect("Second Hand Color", SettingField.SEC_COLOR, Settings.current.sec.color);
		panel.add(sColor.label);
		panel.add(sColor.button);

		panel.add(new JSeparator());

		panel.add(new JLabel("CARDINAL MARKS"));
		// OPTION: cardinal mark present
		CheckBox cmPresent = new CheckBox("Cardinal Mark Present", SettingField.CARD_NUM_PRESENT,
				Settings.current.cardinalMark.hasNumber);
		panel.add(cmPresent.check);
		// OPTION: cardinal font
		FontSelect cmFont = new FontSelect("Cardinal Mark Font", SettingField.CARD_MARK_FONT,
				Settings.current.cardinalMark.font, Settings.current.cardinalMark.numberColor);
		panel.add(cmFont.label);
		panel.add(cmFont.button);
		// OPTION: cardinal roman
		CheckBox cRoman = new CheckBox("Use Roman Numerals", SettingField.CARD_MARK_ROMAN, Settings.current.cardinalMark.roman);
		panel.add(cRoman.check);
		// OPTION: cardinal mark distance
		Slider cmDist = new Slider("Cardinal Mark Distance", SettingField.CARD_MARK_DIST, 0, 100,
				(int) (Settings.current.cardinalMark.distance * 100));
		panel.add(cmDist.label);
		panel.add(cmDist.slider);

		panel.add(new JSeparator());

		panel.add(new JLabel("CARDINAL TICKS"));
		// OPTION: cardinal tick present
		CheckBox ctPresent = new CheckBox("Cardinal Tick Present", SettingField.CARD_TICK_PRESENT,
				Settings.current.cardinalMark.hasTick);
		panel.add(ctPresent.check);
		// OPTION: cardinal tick length
		Slider ctLen = new Slider("Cardinal Tick Length", SettingField.CARD_MARK_TICK_LENGTH, 0, 100,
				(int) (Settings.current.cardinalMark.length * 100));
		panel.add(ctLen.label);
		panel.add(ctLen.slider);
		// OPTION: cardinal tick width
		Slider ctWid = new Slider("Cardinal Tick Width", SettingField.CARD_MARK_TICK_WIDTH, 0, 20,
				(int) (Settings.current.cardinalMark.width));
		panel.add(ctWid.label);
		panel.add(ctWid.slider);
		// OPTION: cardinal tick color
		ColorSelect ctColor = new ColorSelect("Cardinal Tick Color", SettingField.CARD_MARK_TICK_COLOR,
				Settings.current.cardinalMark.tickColor);
		panel.add(ctColor.label);
		panel.add(ctColor.button);

		panel.add(new JSeparator());

		panel.add(new JLabel("HOUR MARKS"));
		// OPTION: hour mark present
		CheckBox hmPresent = new CheckBox("Hour Mark Present", SettingField.HOUR_NUM_PRESENT,
				Settings.current.hourMark.hasNumber);
		panel.add(hmPresent.check);
		// OPTION: hour font
		FontSelect hmFont = new FontSelect("Hour Mark Font", SettingField.HOUR_MARK_FONT, Settings.current.hourMark.font,
				Settings.current.hourMark.numberColor);
		panel.add(hmFont.label);
		panel.add(hmFont.button);
		// OPTION: hour roman
		CheckBox hRoman = new CheckBox("Use Roman Numerals", SettingField.HOUR_MARK_ROMAN, Settings.current.hourMark.roman);
		panel.add(hRoman.check);
		// OPTION: hour mark distance
		Slider hmDist = new Slider("Hour Mark Distance", SettingField.HOUR_MARK_DIST, 0, 100,
				(int) (Settings.current.hourMark.distance * 100));
		panel.add(hmDist.label);
		panel.add(hmDist.slider);

		panel.add(new JSeparator());

		panel.add(new JLabel("HOUR TICKS"));
		// OPTION: hour tick present
		CheckBox htPresent = new CheckBox("Hour Tick Present", SettingField.HOUR_TICK_PRESENT,
				Settings.current.hourMark.hasTick);
		panel.add(htPresent.check);
		// OPTION: hour tick length
		Slider htLen = new Slider("Hour Tick Length", SettingField.HOUR_MARK_TICK_LENGTH, 0, 100,
				(int) (Settings.current.hourMark.length * 100));
		panel.add(htLen.label);
		panel.add(htLen.slider);
		// OPTION: hour tick width
		Slider htWid = new Slider("Hour Tick Width", SettingField.HOUR_MARK_TICK_WIDTH, 0, 20,
				(int) (Settings.current.hourMark.width));
		panel.add(htWid.label);
		panel.add(htWid.slider);
		// OPTION: hour tick color
		ColorSelect htColor = new ColorSelect("Hour Tick Color", SettingField.HOUR_MARK_TICK_COLOR,
				Settings.current.hourMark.tickColor);
		panel.add(htColor.label);
		panel.add(htColor.button);

		panel.add(new JSeparator());

		panel.add(new JLabel("MINUTE MARKS"));
		// OPTION: minute mark present
		CheckBox mmPresent = new CheckBox("Minute Mark Present", SettingField.MIN_NUM_PRESENT,
				Settings.current.minuteMark.hasNumber);
		panel.add(mmPresent.check);
		// OPTION: minute font
		FontSelect mmFont = new FontSelect("Minute Mark Font", SettingField.MIN_MARK_FONT, Settings.current.minuteMark.font,
				Settings.current.minuteMark.numberColor);
		panel.add(mmFont.label);
		panel.add(mmFont.button);
		// OPTION: minute roman
		// CheckBox mRoman=new CheckBox("Use Roman Numerals",
		// SettingField.MIN_MARK_ROMAN, Settings.current.minuteMark.roman);
		// panel.add(mRoman.check);
		// OPTION: minute mark distance
		Slider mmDist = new Slider("Minute Mark Distance", SettingField.MIN_MARK_DIST, 0, 100,
				(int) (Settings.current.minuteMark.distance * 100));
		panel.add(mmDist.label);
		panel.add(mmDist.slider);

		panel.add(new JSeparator());

		panel.add(new JLabel("MINUTE TICKS"));
		// OPTION: minute tick present
		CheckBox mtPresent = new CheckBox("Minute Tick Present", SettingField.MIN_TICK_PRESENT,
				Settings.current.minuteMark.hasTick);
		panel.add(mtPresent.check);
		// OPTION: minute tick length
		Slider mtLen = new Slider("Minute Tick Length", SettingField.MIN_MARK_TICK_LENGTH, 0, 100,
				(int) (Settings.current.minuteMark.length * 100));
		panel.add(mtLen.label);
		panel.add(mtLen.slider);
		// OPTION: minute tick width
		Slider mtWid = new Slider("Minute Tick Width", SettingField.MIN_MARK_TICK_WIDTH, 0, 20,
				(int) (Settings.current.minuteMark.width));
		panel.add(mtWid.label);
		panel.add(mtWid.slider);
		// OPTION: minute tick color
		ColorSelect mtColor = new ColorSelect("Minute Tick Color", SettingField.MIN_MARK_TICK_COLOR,
				Settings.current.minuteMark.tickColor);
		panel.add(mtColor.label);
		panel.add(mtColor.button);

		// put it on the screen
		this.setVisible(true);
	}
}
