/*
 * This is the class for the clock hands.
 * 
 * TODO:
 * Add a boolean visible
 * 
 * --Jacob Allen
 */
import java.awt.Color;
public class Hand
{
    public int width;
    public double length;
    public Color color;
   
    public boolean smooth;
    public Hand(double length, int width, Color color)
    {
        this.length=length;
        this.width=width;
        this.color=color;
        this.smooth=false;
    }
    public Hand(double length, int width, Color color, boolean smooth)
    {
        this.length=length;
        this.width=width;
        this.color=color;
        this.smooth=smooth;
    }
}
