
/*
 * This is the drawing canvas for the clock.
 * It has the function update(), which is called indirectly from Canvas.repaint()
 * It also is responsible for getting the current time, and tranlating that to hand positions.
 * Also found here, near the bottom, is the code for dragging the clock and for displaying the right click menu.
 * 
 * --Jacob Allen
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener {
	private double ratio;
	private int xOffset;
	private int yOffset;
	private int width;
	private int height;

	private Point down = new Point(0, 0);

	public Canvas() {
		this.ratio = 1;
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	public void drawStringCentered(Graphics g, String text, Point point, Font font) {
		// get the size of the text
		FontMetrics metrics = g.getFontMetrics(font);
		// find the X coordinate for the text
		int x = point.x - (metrics.stringWidth(text) / 2);
		// and the Y coordinate
		int y = point.y - (metrics.getHeight() / 2) + metrics.getAscent();
		// draw it
		g.setFont(font);
		g.drawString(text, x, y);
	}

	public void paint(Graphics g) {
		// figure out drawing size
		// this code is from a generic template I created
		// I could probably remove this section
		int h = getSize().height;
		int w = getSize().width;
		if (w * ratio < h) {
			width = w;
			height = (int) (w * ratio);
		} else {
			height = h;
			width = (int) (h / ratio);
		}
		xOffset = (w - width) / 2;
		yOffset = (h - height) / 2;
		// start the actual drawing
		this.update(g);
	}

	public void update(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(new Color(0, 0, 0, 0));
		g.fillRect(0, 0, Settings.current.diameter, Settings.current.diameter);
		// figure out time
		long utc = System.currentTimeMillis();
		int timeZoneOffset = TimeZone.getDefault().getOffset(utc);

		double milli = utc + timeZoneOffset + Settings.current.timeOffset;

		double sec = milli / 1000;
		double min = sec / 60;
		double hour = min / 60;
		// make units loop over their domain. We don't need to count the days in
		// milliseconds.
		milli %= 1000;
		sec %= 60;
		min %= 60;
		hour %= 12;
		// round down the ones whose hand does not move smoothly
		if (!Settings.current.sec.smooth)
			sec = Math.floor(sec);
		if (!Settings.current.min.smooth)
			min = Math.floor(min);
		if (!Settings.current.hour.smooth)
			hour = Math.floor(hour);
		// draw the face
		g.setColor(Settings.current.faceColor);
		g.fillOval(0, 0, Settings.current.diameter, Settings.current.diameter);
		// draw the numbers
		int rad = Settings.current.diameter / 2;
		// 3, 6, 9, 12
		for (int n = 3; n <= 12; n += 3) {
			// find angle
			double a = (((double) n / 12) * 2 * Math.PI);
			// tick mark
			if (Settings.current.cardinalMark.hasTick) {
				// find c(1-onnection points
				int x1 = (int) (rad + Math.sin(a) * rad);
				int y1 = (int) (rad - Math.cos(a) * rad);

				int x2 = (int) (rad + Math.sin(a) * (rad * (1 - Settings.current.cardinalMark.length)));
				int y2 = (int) (rad - Math.cos(a) * (rad * (1 - Settings.current.cardinalMark.length)));
				// draw it
				g.setColor(Settings.current.cardinalMark.tickColor);
				g2.setStroke(new BasicStroke(Settings.current.cardinalMark.width));
				g2.drawLine(x1, y1, x2, y2);
			}
			// number
			if (Settings.current.cardinalMark.hasNumber) {
				// find text draw point
				int x = (int) (rad + Math.sin(a) * (rad * Settings.current.cardinalMark.distance));
				int y = (int) (rad - Math.cos(a) * (rad * Settings.current.cardinalMark.distance));
				// find the correct text
				String number = "";
				if (Settings.current.cardinalMark.roman) {
					String[] romanNumbers = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
							"XII" };
					number = romanNumbers[n - 1];
				} else
					number = n + "";
				// draw it
				g.setColor(Settings.current.cardinalMark.numberColor);
				drawStringCentered(g, number, new Point(x, y), Settings.current.cardinalMark.font);
			}
		}
		// all hour marks
		for (int n = 1; n <= 12; n++) {
			// don't draw what we already have
			if (n % 3 == 0)
				continue;
			// find angle
			double a = (((double) n / 12) * 2 * Math.PI);
			// tick mark
			if (Settings.current.hourMark.hasTick) {
				// find connection points
				int x1 = (int) (rad + Math.sin(a) * rad);
				int y1 = (int) (rad - Math.cos(a) * rad);

				int x2 = (int) (rad + Math.sin(a) * (rad * (1 - Settings.current.hourMark.length)));
				int y2 = (int) (rad - Math.cos(a) * (rad * (1 - Settings.current.hourMark.length)));
				// draw it
				g.setColor(Settings.current.hourMark.tickColor);
				g2.setStroke(new BasicStroke(Settings.current.hourMark.width));
				g2.drawLine(x1, y1, x2, y2);
			}
			// number
			if (Settings.current.hourMark.hasNumber) {
				// find text draw point
				int x = (int) (rad + Math.sin(a) * (rad * Settings.current.hourMark.distance));
				int y = (int) (rad - Math.cos(a) * (rad * Settings.current.hourMark.distance));
				// find the correct text
				String number = "";
				if (Settings.current.hourMark.roman) {
					String[] romanNumbers = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
							"XII" };
					number = romanNumbers[n - 1];
				} else
					number = n + "";
				// draw it
				g.setColor(Settings.current.hourMark.numberColor);
				drawStringCentered(g, number, new Point(x, y), Settings.current.hourMark.font);
			}
		}
		// minute marks
		for (int n = 1; n <= 60; n++) {
			// dont draw it if we already have
			if (n % 5 == 0)
				continue;
			// find angle
			double a = (((double) n / 60) * 2 * Math.PI);
			// tick mark
			if (Settings.current.minuteMark.hasTick) {
				// find connection points
				int x1 = (int) (rad + Math.sin(a) * rad);
				int y1 = (int) (rad - Math.cos(a) * rad);

				int x2 = (int) (rad + Math.sin(a) * (rad * (1 - Settings.current.minuteMark.length)));
				int y2 = (int) (rad - Math.cos(a) * (rad * (1 - Settings.current.minuteMark.length)));
				// draw it
				g.setColor(Settings.current.minuteMark.tickColor);
				g2.setStroke(new BasicStroke(Settings.current.minuteMark.width));
				g2.drawLine(x1, y1, x2, y2);
			}
			// number
			if (Settings.current.minuteMark.hasNumber) {
				// find text draw point
				int x = (int) (rad + Math.sin(a) * (rad * Settings.current.minuteMark.distance));
				int y = (int) (rad - Math.cos(a) * (rad * Settings.current.minuteMark.distance));
				// find the correct text
				String number = "";
				if (Settings.current.minuteMark.roman) {
					// no.
				} else
					number = n + "";
				// draw it
				g.setColor(Settings.current.minuteMark.numberColor);
				drawStringCentered(g, number, new Point(x, y), Settings.current.minuteMark.font);
			}
		}
		// draw the hands
		double a, x, y;
		if (Settings.current.hour.visible) {
			// find angle of hour hand
			a = ((hour / 12) * 2 * Math.PI);
			x = rad + Math.sin(a) * (rad * Settings.current.hour.length);
			y = rad - Math.cos(a) * (rad * Settings.current.hour.length);
			// draw it
			g.setColor(Settings.current.hour.color);
			g2.setStroke(new BasicStroke(Settings.current.hour.width));
			g2.drawLine(rad, rad, (int) x, (int) y);
		}
		if (Settings.current.min.visible) {
			// find angle of minute hand
			a = (((double) min / 60) * 2 * Math.PI);
			x = rad + Math.sin(a) * (rad * Settings.current.min.length);
			y = rad - Math.cos(a) * (rad * Settings.current.min.length);
			// draw it
			g.setColor(Settings.current.min.color);
			g2.setStroke(new BasicStroke(Settings.current.min.width));
			g2.drawLine(rad, rad, (int) x, (int) y);
		}
		if (Settings.current.sec.visible) {
			// find angle of second hand
			a = (((double) sec / 60) * 2 * Math.PI);
			x = rad + Math.sin(a) * (rad * Settings.current.sec.length);
			y = rad - Math.cos(a) * (rad * Settings.current.sec.length);
			// draw it
			g.setColor(Settings.current.sec.color);
			g2.setStroke(new BasicStroke(Settings.current.sec.width));
			g2.drawLine(rad, rad, (int) x, (int) y);
		}
	}

	// getters
	public Point getOffset() {
		return new Point(xOffset, yOffset);
	}

	public Dimension getRealSize() {
		return new Dimension(width, height);
	}

	public double getRatio() {
		return ratio;
	}

	// https://docs.oracle.com/javase/tutorial/uiswing/events/mouselistener.html
	@Override
	public void mousePressed(MouseEvent e) {
		// point on the clock
		this.down = e.getPoint();
		// right click
		if (e.isPopupTrigger()) {
			RightClickMenu menu = new RightClickMenu();
			menu.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// right click
		if (e.isPopupTrigger()) {
			RightClickMenu menu = new RightClickMenu();
			menu.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// point on screen
		Point s = e.getLocationOnScreen();
		// to find point that the clock needs to go to
		Point n = new Point(s.x - this.down.x, s.y - this.down.y);
		// move it there
		Main.frame.setLocation(n.x, n.y);
	}
}
