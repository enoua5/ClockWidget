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
    public Hand(double length, int width, Color color)
    {
        this.length=length;
        this.width=width;
        this.color=color;
    }
}
