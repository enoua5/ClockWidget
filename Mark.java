/*
 * This keeps track of settings for tick marks.
 * They can have a number, a tick, or both.
 * The number can be replaced with a roman numeral.
 * 
 * This class is used thrice. Once for the cardinal hours (3, 6, 9, and 12), once for the other hour marks, and once for the minute/second marks.
 * 
 * --Jacob Allen
 */
import java.awt.*;
public class Mark
{
    //numbering
    public boolean hasNumber;
    public Font font;
    public Color numberColor;
    public boolean roman; //true=roman numerals, false=arabic numerals
    public double distance;
    //tick mark
    public boolean hasTick;
    public int width;
    public double length;
    public Color tickColor;
    //number and tick
    public Mark(Font font, boolean roman, double distance, Color numberColor,
        int width, double length, Color tickColor)
    {
        this.hasNumber=true;
        this.hasTick=true;
        
        this.font=font;
        this.roman=roman;
        this.distance=distance;
        this.numberColor=numberColor;
        
        this.width=width;
        this.length=length;
        this.tickColor=tickColor;
    }
    //just number
    public Mark(Font font, boolean roman, double distance, Color numberColor)
    {
        this.hasNumber=true;
        this.hasTick=false;
        
        this.font=font;
        this.roman=roman;
        this.distance=distance;
        this.numberColor=numberColor;
        
        //default tick
        this.width=2;
        this.length=4;
        this.tickColor=new Color(0,0,0);
    }
    //just tick
    public Mark(int width, double length, Color tickColor)
    {
        this.hasNumber=false;
        this.hasTick=true;
        
        this.width=width;
        this.length=length;
        this.tickColor=tickColor;
        
        //default number
        this.font=new Font("TimesRoman", Font.PLAIN, 16);
        this.roman=false;
        this.distance=0.8;
        this.numberColor=new Color(0,0,0);
        
    }
}
