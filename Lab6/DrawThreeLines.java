import java.applet.Applet; 
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class DrawThreeLines extends Applet {
	
	int x1;
	int x2;
	int y1;
	int y2;
	Line[] lines;
	boolean hasPressedMouse;
	boolean hasReleasedMouse;
	boolean hasDraggedMouse;
	int countOfLines;
	
	public void init() {
		
		this.addMouseListener(new AppletListener());
		this.addMouseMotionListener(new AppletListener());
		countOfLines = 0;
		lines = new Line[3];
		
		hasDraggedMouse = false;
	}
	
	public void paint(Graphics g) {
		
			for(int i = 0; i < lines.length; i++) {
				if(lines[i] != null) {
					g.drawLine(lines[i].x1, lines[i].y1, lines[i].x2, lines[i].y2);
				}	
			}
			
			if(countOfLines < lines.length && hasDraggedMouse) {
				g.drawLine(x1, y1, x2, y2);	
			}
	}

	class AppletListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {	
				x1 = e.getX();
				y1 = e.getY();
			
		}
		
		public void mouseDragged(MouseEvent e) {
			hasDraggedMouse = true;
			x2 = e.getX();
			y2 = e.getY();
			System.out.println("Dragged!");
			repaint();
		}
		
		public void mouseReleased(MouseEvent e) {
			
			if (countOfLines < lines.length && hasDraggedMouse) {
				Line ln = new Line(x1, x2, y1, y2);
				lines[countOfLines] = ln;
				countOfLines ++;
				hasDraggedMouse = false;
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
