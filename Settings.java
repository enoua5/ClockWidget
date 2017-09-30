/*
 * Here are found a bunch of static variables, keeping track of clock settings.
 * The settings listed here are the defaults, they will be overwritten at startup with the read-in settings (if they are present)
 * 
 * TODO:
 * Just keep adding more settings as they become needed
 * We may put the save() and load() functions here as well
 * 
 * --Jacob Allen
 */
import java.awt.*;
public class Settings
{
    public static int diameter=200;
    
    public static Color faceColor=new Color(255,255,255);
    
    public static Hand hour=new Hand(0.5, 10, new Color(0,0,0));
    public static Hand min=new Hand(0.9, 6, new Color(0,0,0));
    public static Hand sec=new Hand(0.8, 4, new Color(255,0,0));
    
    public static Mark cardinalMark=new Mark(new Font("TimesRoman", Font.BOLD, 32),false, 0.8, new Color(0,0,0),
        3, 0.05, new Color(0,0,0));//3,6,9,12
    public static Mark hourMark=new Mark(3, 0.1, new Color(0,0,0));
    public static Mark minuteMark=new Mark(2, 0.05, new Color(0,0,0));
}
