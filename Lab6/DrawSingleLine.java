import java.applet.Applet; 
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class DrawSingleLine extends Applet {
	
	int x1;
	int x2;
	int y1;
	int y2;
	
	public void init() {
		
		this.addMouseListener(new AppletListener());
		this.addMouseMotionListener(new AppletListener());
	}
	
	public void paint(Graphics g) {
		
			g.drawLine(x1, y1, x2, y2);
		
	}

	class AppletListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			x1 = e.getX();
			y1 = e.getY();
		}
		
		public void mouseDragged(MouseEvent e) {			x2 = e.getX();
			y2 = e.getY();
			repaint();
		}

	}		
}
