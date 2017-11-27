
/*
 * Here are found a bunch of static variables, keeping track of clock settings.
 * The settings listed here are the defaults, they will be overwritten at startup with the read-in settings (if they are present)
 * 
 * TODO:
 * Just keep adding more settings as they become needed
 * Fill out save() and load()
 * 
 * --Jacob Allen
 */
/*
* Added contents to save method so it creates a file called settings.dat and saves settings to the file.
* --Michael Kent
*/
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Settings implements Serializable {
	public static void save() {
		ObjectOutputStream out = null;

		try {
			out = new ObjectOutputStream(new FileOutputStream("settings.dat"));
			out.writeObject(Settings);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void load() {
		ObjectInputStream in = null;

		try {

			in = new ObjectInputStream(new FileInputStream("settings.dat"));

			Settings me = (Settings) in.readObject();
			Settings = me;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static int diameter = 200;

	public static long timeOffset = 0;

	public static Color faceColor = new Color(255, 255, 255);

	public static Hand hour = new Hand(0.5, 10, new Color(0, 0, 0), true);
	public static Hand min = new Hand(0.9, 6, new Color(0, 0, 0), true);
	public static Hand sec = new Hand(0.8, 4, new Color(255, 0, 0), false);

	public static Mark cardinalMark = new Mark(new Font("TimesRoman", Font.BOLD, 32), false, 0.8, new Color(0, 0, 0), 3,
			0.05, new Color(0, 0, 0));// 3,6,9,12
	public static Mark hourMark = new Mark(3, 0.1, new Color(0, 0, 0));
	public static Mark minuteMark = new Mark(2, 0.05, new Color(0, 0, 0));
}
