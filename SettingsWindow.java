/*
 * This is a popup menu for changing the settings
 *
 * --Jacob Allen
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
public class SettingsWindow extends JFrame
{
	public SettingsWindow()
	{
		//set title
		super("Settings");
		//make it closable
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//put it on the screen
		this.setVisible(true);
	}
}
