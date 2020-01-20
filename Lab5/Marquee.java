import java.applet.Applet; 
import java.awt.Graphics;

public class Marquee extends Applet implements Runnable{
	
	int x = 0;
	Thread th;
	
	public void init() {
		th = new Thread(this);
		th.start();
	}
	
	public void paint(Graphics g) {
		
		g.drawString("Hello Java!", x, getHeight() / 2 );
		if(x >= getWidth()) {
			x = 0;
			
		} else {
			x += 30;
		}
		
	}
	
	public void run() {
		while(true) {
			
			try {
				
				th.sleep(500);
				repaint();
			} catch (InterruptedException ie) {
				
				ie.printStackTrace();
			}
			
		}
		
	}

}