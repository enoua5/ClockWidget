/*
 * Entry point of the program.
 * Initializes the canvas and frame, then starts and animation loop.
 * 
 * --Jacob Allen
 */

public class Main {
	public static Canvas canvas;
	public static Frame frame;

	public static void main(String[] args) throws java.lang.InterruptedException {
		// should be self explanatory
		new Settings();
		Settings.load();
		// set up and launch widget
		canvas = new Canvas();
		frame = new Frame(canvas);
		// animate
		while (true) {
			canvas.repaint();
			Thread.sleep(20);
		}
	}
}
