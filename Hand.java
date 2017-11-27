/*
 * This is the class for the clock hands.
 * 
 * --Jacob Allen
 */
import java.awt.Color;
public class Hand implements Serializable
{
    public int width;
    public double length;
    public Color color;
   
    public boolean smooth;
    
    public boolean visible;
    public Hand(double length, int width, Color color)
    {
        this.length=length;
        this.width=width;
        this.color=color;
        this.smooth=false;
        this.visible=true;
    }
    public Hand(double length, int width, Color color, boolean smooth)
    {
        this.length=length;
        this.width=width;
        this.color=color;
        this.smooth=smooth;
        this.visible=true;
    }
    public Hand(boolean noHand)
    {
        this.visible=false;
    }
}
