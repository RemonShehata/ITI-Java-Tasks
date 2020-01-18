import java.applet.Applet; 
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Font;

public class Fonts1 extends Applet{
	
	
	int x = 20;
	String[] fonts;
	
	public void init() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		fonts = tk.getFontList();
		
	}
	
	
	public void paint(Graphics g) {
		
		for (String font : fonts) {
			g.drawString(font, 30, x);
			
			Font f = new Font(font, Font.PLAIN, 10);
			g.setFont(f);
			x += 20;
		}
		
	}

}