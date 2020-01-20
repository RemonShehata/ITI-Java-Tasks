import java.applet.Applet; 
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class CircleFollowingCursor extends Applet {
	
	int x1;
	int y1;
	
	boolean hasPressedMouse;
	boolean hasDraggedMouse;
	boolean hasReleasedMouse;
	public void init() {
		this.addMouseListener(new AppletListener());
		this.addMouseMotionListener(new AppletListener());
		hasPressedMouse = false;
		hasDraggedMouse = false;
		hasReleasedMouse = false;
		
	}
	
	public void paint(Graphics g) {
		if(hasReleasedMouse) {
			g.drawOval(x1, y1, 50, 50);
		}
		
	}
	
	
		class AppletListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			x1 = e.getX();
			y1 = e.getY();
			hasPressedMouse = true;
			repaint();
		}
		
		public void mouseDragged(MouseEvent e) {
			x1 = e.getX();
			y1 = e.getY();
			hasDraggedMouse = true;
			repaint();
		}
		
		public void mouseReleased(MouseEvent e) {
			hasReleasedMouse = true;
		}

	}

}