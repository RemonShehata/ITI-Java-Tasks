import java.applet.Applet; 
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Font;
import java.util.Locale;
import java.awt.GraphicsEnvironment;

public class Fonts2 extends Applet{
	
	
	int x = 20;
	String[] fonts;
	Locale lc;
	
	public void init() {
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//lc = new Locale("en");
		fonts = ge.getAvailableFontFamilyNames();
		
		
	}
	
	
	public void paint(Graphics g) {
		
		for (String font : fonts) {
			g.drawString(font, 30, x);
			
			Font f = new Font(font, Font.PLAIN, 20);
			g.setFont(f);
			x += 20;
		}
		
	}

}