import java.applet.Applet; 
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayPauseAnimation extends Applet implements Runnable{
	
	int currentX;
	int currentY;
	Thread th;
	Button btnPlay;
	Button btnPause;
	Boolean hasStarted;
	Boolean isMovingForward;
	Boolean isMovingUpward;
	
	public void init() {
		currentX = getWidth() / 2;
		currentY = getHeight() /2;
		
		hasStarted = false;
		isMovingForward = true;
		isMovingUpward = true;
		btnPlay = new Button("Play");
		btnPause = new Button("Pause");
		
		add(btnPlay);
		add(btnPause);
		
		th = new Thread(this);
		
		btnPlay.addActionListener(new PlayButtonListener());
		btnPause.addActionListener(new PauseButtonListener());
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
	
	class PlayButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			if(hasStarted) {
				th.resume();
			}else {
				th.start();
				hasStarted = true;
			}
				
		}

	}
	
	class PauseButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			th.suspend();
		}

	}
		
}