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
    }
    //just tick
    public Mark(int width, double length, Color tickColor)
    {
        this.hasNumber=false;
        this.hasTick=true;
        
        this.width=width;
        this.length=length;
        this.tickColor=tickColor;
    }
}
