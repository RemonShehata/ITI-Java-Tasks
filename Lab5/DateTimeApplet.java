import java.applet.Applet; 
import java.awt.Graphics;
import java.util.Date;

public class DateTimeApplet extends Applet implements Runnable{
	
	Thread th;
	
	public void init() {
		th = new Thread(this);
		th.start();
	}
	
	public void paint(Graphics g) {
		
		Date d = new Date();
		g.drawString(d.toString(), getHeight() / 2, getHeight() / 2 );
		
	}
	
	public void run() {
		while(true) {
			
			try {
				
				th.sleep(1000);
				repaint();
			} catch (InterruptedException ie) {
				
				ie.printStackTrace();
			}
			
		}
		
	}

}