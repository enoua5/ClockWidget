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
