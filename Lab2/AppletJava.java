import java.applet.Applet; 
import java.awt.Graphics;


public class AppletJava extends Applet{
	
	String n;
	
	public void init()
	{
		n = getParameter("name");
	}
	
	public void paint(Graphics g) {
		
		g.drawString("Hello there, " + n, getWidth() / 2, getHeight() / 2 );
	}

}