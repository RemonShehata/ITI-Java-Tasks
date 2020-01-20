import java.applet.Applet; 
import java.awt.Graphics;
import java.awt.Color;

public class AnimationBall extends Applet implements Runnable{
	
	Thread th;
	int currentX;
	int currentY;
	Boolean isMovingForward = true;
	Boolean isMovingUpward = true;
	
	public void init() {
		currentX = 0;
		currentY = 0;
		th = new Thread(this);
		th.start();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(currentX,currentY , 50,50);
		
		
		if(currentX >= getWidth()) {
			isMovingForward = false;
		} else if(currentX <= 0) {
			isMovingForward = true;
		}
		
		if(isMovingForward) {
			currentX += 20;
		}else {
			currentX -= 20;
		}
		
		
		if(currentY >= getHeight()) {
			isMovingUpward = false;
		} else if(currentY <= 0) {
			isMovingUpward = true;
		}
		
		if(isMovingUpward) {
			currentY += 20;
		}else {
			currentY -= 20;
		}
		
		
		
		
		
	}
	
	
	public void run() {
		while(true) {
			
			try {
				
				th.sleep(100);
				repaint();
			} catch (InterruptedException ie) {
				
				ie.printStackTrace();
			}
			
		}
		
	}


}