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
        //*shrugs*
        hour+=6;
        //draw the face
        g.setColor(Settings.faceColor);
        g.fillOval(0, 0, Settings.diameter, Settings.diameter);
        //draw the hands
        //find angle of hour hand
        int rad=Settings.diameter/2;
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
        if(e.isPopupTrigger())
        {
            RightClickMenu menu=new RightClickMenu();
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
    @Override
    public void mouseReleased(MouseEvent e)
    {
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