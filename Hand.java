
/*
 * This is the class for the clock hands.
 * 
 * --Jacob Allen
 */
/*
* Added "implements Serializable" to public class Hand so it can be put into the settings.dat file.
* --Michael Kent
*/
import java.awt.Color;
import java.io.Serializable;

public class Hand implements Serializable {
	public int width;
	public double length;
	public Color color;

	public boolean smooth;

	public boolean visible;

	public Hand(double length, int width, Color color) {
		this.length = length;
		this.width = width;
		this.color = color;
		this.smooth = false;
		this.visible = true;
	}

	public Hand(double length, int width, Color color, boolean smooth) {
		this.length = length;
		this.width = width;
		this.color = color;
		this.smooth = smooth;
		this.visible = true;
	}

	public Hand(boolean noHand) {
		this.visible = false;
	}
}
