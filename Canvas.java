/*
 * This is the drawing canvas for the clock.
 * It has the function update(), which is called indirectly from Canvas.repaint()
 * It also is responsible for getting the current time, and tranlating that to hand positions.
 * Also found here, near the bottom, is the code for dragging the clock and for displaying the right click menu.
 * 
 * TODO:
 * Add support for setting displayed time +/- some amount from the reported time
 * Add support for fluid hand movement
 * Add support for removing hands
 * 
 * --Jacob Allen
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener
{
    private double ratio;
    private int xOffset;
    private int yOffset;
    private int width;
    private int height;
    
    private Point down=new Point(0,0);
    
    public Canvas()
    {
        this.ratio=1;
        addMouseMotionListener(this);
        addMouseListener(this);
    }
    public void drawStringCentered(Graphics g, String text, Point point, Font font)
    {
        //get the size of the text
        FontMetrics metrics = g.getFontMetrics(font);
        //find the X coordinate for the text
        int x=point.x-(metrics.stringWidth(text)/2);
        //and the Y coordinate
        int y=point.y-(metrics.getHeight()/2)+metrics.getAscent();
        //draw it
        g.setFont(font);
        g.drawString(text, x, y);
    }
    public void paint(Graphics g)
    {
        //figure out drawing size
        //this code is from a generic template I created
        //I could probably remove this section
        int h=getSize().height;
        int w=getSize().width;
        if(w*ratio<h)
        {
            width=w;
            height=(int)(w*ratio);
        }
        else
        {
            height=h;
            width=(int)(h/ratio);
        }
        xOffset=(w-width)/2;
        yOffset=(h-height)/2;
        //start the actual drawing
        this.update(g);
    }
    public void update(Graphics g)
    {
        Graphics2D g2=(Graphics2D)g;
        g.clearRect(0, 0, Settings.diameter, Settings.diameter);
        //figure out time
        long milli=System.currentTimeMillis();
        long sec=milli/1000;
        long min=sec/60;
        long hour=min/60;
        //make units loop over their domain. We don't need to count the days in milliseconds.
        milli%=1000;
        sec%=60;
        min%=60;
        hour%=12;
        //time is grabbed from UTC±0. This line will be replaced with reading from settings
        hour+=6;
        //draw the face
        g.setColor(Settings.faceColor);
        g.fillOval(0, 0, Settings.diameter, Settings.diameter);
        //draw the numbers
        int rad=Settings.diameter/2;
        //3, 6, 9, 12
        for(int n=3; n<=12; n+=3)
        {
            //find angle
            double a=(((double)n/12)*2*Math.PI);
            //tick mark
            if(Settings.cardinalMark.hasTick)
            {
                //find c(1-onnection points
                int x1=(int)(rad+Math.sin(a)*rad);
                int y1=(int)(rad-Math.cos(a)*rad);
                
                int x2=(int)(rad+Math.sin(a)*(rad*(1-Settings.cardinalMark.length)));
                int y2=(int)(rad-Math.cos(a)*(rad*(1-Settings.cardinalMark.length)));
                //draw it
                g.setColor(Settings.cardinalMark.tickColor);
                g2.setStroke(new BasicStroke(Settings.cardinalMark.width));
                g2.drawLine(x1, y1, x2, y2);
            }
            //number
            if(Settings.cardinalMark.hasNumber)
            {
                //find text draw point
                int x=(int)(rad+Math.sin(a)*(rad*Settings.cardinalMark.distance));
                int y=(int)(rad-Math.cos(a)*(rad*Settings.cardinalMark.distance));
                //find the correct text
                String number="";
                if(Settings.cardinalMark.roman)
                {
                    String[] romanNumbers={"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII"};
                    number=romanNumbers[n-1];
                }
                else
                    number=n+"";
                //draw it
                g.setColor(Settings.cardinalMark.numberColor);
                drawStringCentered(g, number, new Point(x, y), Settings.cardinalMark.font);
            }
        }
        //all hour marks
        for(int n=1; n<=12; n++)
        {
            //don't draw what we already have
            if(n%3==0)
                continue;
            //find angle
            double a=(((double)n/12)*2*Math.PI);
            //tick mark
            if(Settings.hourMark.hasTick)
            {
                //find connection points
                int x1=(int)(rad+Math.sin(a)*rad);
                int y1=(int)(rad-Math.cos(a)*rad);
                
                int x2=(int)(rad+Math.sin(a)*(rad*(1-Settings.hourMark.length)));
                int y2=(int)(rad-Math.cos(a)*(rad*(1-Settings.hourMark.length)));
                //draw it
                g.setColor(Settings.hourMark.tickColor);
                g2.setStroke(new BasicStroke(Settings.hourMark.width));
                g2.drawLine(x1, y1, x2, y2);
            }
            //number
            if(Settings.hourMark.hasNumber)
            {
                //find text draw point
                int x=(int)(rad+Math.sin(a)*(rad*Settings.hourMark.distance));
                int y=(int)(rad-Math.cos(a)*(rad*Settings.hourMark.distance));
                //find the correct text
                String number="";
                if(Settings.hourMark.roman)
                {
                    String[] romanNumbers={"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII"};
                    number=romanNumbers[n-1];
                }
                else
                    number=n+"";
                //draw it
                g.setColor(Settings.hourMark.numberColor);
                drawStringCentered(g, number, new Point(x, y), Settings.hourMark.font);
            }
        }
        //minute marks
        for(int n=1; n<=60; n++)
        {
            //dont draw it if we already have
            if(n%5==0)
                continue;
            //find angle
            double a=(((double)n/60)*2*Math.PI);
            //tick mark
            if(Settings.minuteMark.hasTick)
            {
                //find connection points
                int x1=(int)(rad+Math.sin(a)*rad);
                int y1=(int)(rad-Math.cos(a)*rad);
                
                int x2=(int)(rad+Math.sin(a)*(rad*(1-Settings.minuteMark.length)));
                int y2=(int)(rad-Math.cos(a)*(rad*(1-Settings.minuteMark.length)));
                //draw it
                g.setColor(Settings.minuteMark.tickColor);
                g2.setStroke(new BasicStroke(Settings.minuteMark.width));
                g2.drawLine(x1, y1, x2, y2);
            }
            //number
            if(Settings.minuteMark.hasNumber)
            {
                //find text draw point
                int x=(int)(rad+Math.sin(a)*(rad*Settings.minuteMark.distance));
                int y=(int)(rad-Math.cos(a)*(rad*Settings.minuteMark.distance));
                //find the correct text
                String number="";
                if(Settings.minuteMark.roman)
                {
                    //no.
                }
                else
                    number=n+"";
                //draw it
                g.setColor(Settings.minuteMark.numberColor);
                drawStringCentered(g, number, new Point(x, y), Settings.minuteMark.font);
            }
        }
        //draw the hands
        //find angle of hour hand
        double a=(((double)hour/12)*2*Math.PI);
        double x=rad+Math.sin(a)*(rad*Settings.hour.length);
        double y=rad-Math.cos(a)*(rad*Settings.hour.length);
        //draw it
        g.setColor(Settings.hour.color);
        g2.setStroke(new BasicStroke(Settings.hour.width));
        g2.drawLine(rad, rad, (int)x, (int)y);
        
        //find angle of minute hand
        a=(((double)min/60)*2*Math.PI);
        x=rad+Math.sin(a)*(rad*Settings.min.length);
        y=rad-Math.cos(a)*(rad*Settings.min.length);
        //draw it
        g.setColor(Settings.min.color);
        g2.setStroke(new BasicStroke(Settings.min.width));
        g2.drawLine(rad, rad, (int)x, (int)y);
        
        //find angle of second hand
        a=(((double)sec/60)*2*Math.PI);
        x=rad+Math.sin(a)*(rad*Settings.sec.length);
        y=rad-Math.cos(a)*(rad*Settings.sec.length);
        //draw it
        g.setColor(Settings.sec.color);
        g2.setStroke(new BasicStroke(Settings.sec.width));
        g2.drawLine(rad, rad, (int)x, (int)y);
    }
    
    //getters
    public Point getOffset(){return new Point(xOffset, yOffset);}
    public Dimension getRealSize(){return new Dimension(width, height);}
    public double getRatio(){return ratio;}
    // https://docs.oracle.com/javase/tutorial/uiswing/events/mouselistener.html
    @Override
    public void mousePressed(MouseEvent e)
    {
        //point on the clock
        this.down=e.getPoint();
        //right click
        if(e.isPopupTrigger())
        {
            RightClickMenu menu=new RightClickMenu();
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
    @Override
    public void mouseReleased(MouseEvent e)
    {
        //right click
        if(e.isPopupTrigger())
        {
            RightClickMenu menu=new RightClickMenu();
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
    @Override
    public void mouseEntered(MouseEvent e){}
    @Override
    public void mouseExited(MouseEvent e){}
    @Override
    public void mouseClicked(MouseEvent e)
    {

    }
    
    @Override
    public void mouseMoved(MouseEvent e){}
    @Override
    public void mouseDragged(MouseEvent e)
    {
        //point on screen
        Point s=e.getLocationOnScreen();
        //to find point that the clock needs to go to
        Point n=new Point(s.x-this.down.x, s.y-this.down.y);
        //move it there
        Main.f.setLocation(n.x, n.y);
    }
}