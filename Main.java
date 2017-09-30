/*
 * Entry point of the program.
 * Initializes the canvas and frame, then starts and animation loop.
 * 
 * TODO:
 * Load in the settings from file before athe animation loop begins
 * 
 * Classes to add to project:
 * SettingsWindow
 * 
 * --Jacob Allen
 */

public class Main
{
    public static Canvas c;
    public static Frame f;
    public static void main(String[] args)
    throws java.lang.InterruptedException
    {
        //set up and launch widget
        c=new Canvas();
        f=new Frame(c);
        //animate
        while(true)
        {
            c.repaint();
            Thread.sleep(20);
        }
    }
}
