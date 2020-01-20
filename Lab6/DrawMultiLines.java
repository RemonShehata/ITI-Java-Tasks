import java.applet.Applet; 
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class DrawMultiLines extends Applet {
	
	int x1;
	int x2;
	int y1;
	int y2;
	Vector <Line> lines;
	boolean hasDraggedMouse;

	public void init() {
		
		this.addMouseListener(new AppletListener());
		this.addMouseMotionListener(new AppletListener());
		
		lines = new Vector(0, 1);
	}
	
	public void paint(Graphics g) {
		
			for(Line line : lines) {
				g.drawLine(line.x1, line.y1, line.x2, line.y2);
			}
			
				g.drawLine(x1, y1, x2, y2);	
	}

	class AppletListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			x1 = e.getX();
			y1 = e.getY();
		}
		
		public void mouseDragged(MouseEvent e) {
			x2 = e.getX();
			y2 = e.getY();
			hasDraggedMouse = true;
			repaint();
		}
		
		public void mouseReleased(MouseEvent e) {
			if(hasDraggedMouse){
				Line ln = new Line(x1, x2, y1, y2);
				lines.add(ln);
			}
			
		}

	}

	class Line {
		int x1;
		int x2;
		int y1;
		int y2;
		
		Line(int x1, int x2, int y1, int y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
	}
}
