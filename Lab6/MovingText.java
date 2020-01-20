import java.applet.Applet; 
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MovingText extends Applet {
	
	private String moveableString;
	private int currentX;
	private int currentY;
	
	public void init() {
		moveableString = "I am moveable!";
		currentX = getWidth() / 2;
		currentY = getHeight() /2;
		
		this.addKeyListener(new AppletListener());
	}
	
	public void paint(Graphics g) {
		
		g.drawString(moveableString, currentX, currentY);
	}
	
	
	class AppletListener implements KeyListener {
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
				case KeyEvent.VK_UP: 
					currentY -= 10;
					break;
					
				case KeyEvent.VK_DOWN:	
					currentY += 10;
					break;
					
				case KeyEvent.VK_LEFT:
					currentX -= 10;
					break;
					
				case KeyEvent.VK_RIGHT:
					currentX += 10;
					break;
			}	
			repaint();
			
		}
		
		public void keyReleased(KeyEvent e) {
			
			
		}
		
		public void keyTyped(KeyEvent e) {
			
		}

	}
	

}