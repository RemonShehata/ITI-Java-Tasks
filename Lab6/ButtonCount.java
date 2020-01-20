import java.applet.Applet; 
import java.awt.Graphics;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ButtonCount extends Applet {
	
	Button btnIncrement;
	Button btnDecrement;
	int count;
	
	public void init() {
		btnIncrement = new Button("Increment");
		btnDecrement = new Button("Decrement");
		
		btnIncrement.addActionListener(new IncrementButtonListener());
		btnDecrement.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) { 
			count--;
			repaint();
		}
	});
		add(btnIncrement);
		add(btnDecrement);
		
	}
	
	public void paint(Graphics g) {
		
		g.drawString("" + count, getWidth() / 2, getHeight() / 2);
		
	}
	
	class IncrementButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			count++;
			repaint();
		}

	}

}