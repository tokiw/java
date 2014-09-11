package gui2_1;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JPanel;

public class DigitalWatchPanel extends JPanel{
	static int h;
	static int m;
	static int s;
	int flgStart = 1;
	private static String str ="";

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY); //Žž‚ð‘ã“ü
		m = Calendar.getInstance().get(Calendar.MINUTE);      //•ª‚ð‘ã“ü
		s = Calendar.getInstance().get(Calendar.SECOND);       //•b‚ð‘ã“ü
		
		Dimension size = getSize();
		g.setFont(new Font("TimesRoman",Font.ITALIC, 1 * size.width / 10));
		FontMetrics fm = g.getFontMetrics();
		g.clearRect(0, 0, size.width, size.height);
		if (this.flgStart == 1) {
			if (m < 10 && s >= 10)
				g.drawString(h+":0"+m+":"+s, (size.width - fm.stringWidth(h+":0"+m+":"+s)) / 2 , (size.height) / 2);	//drawString(str, int x, int )
			else if (m >= 10 && s < 10)
				g.drawString(h+":"+m+":0"+s, (size.width - fm.stringWidth(h+":"+m+":0"+s)) / 2, (size.height) / 2);
			else if (m < 10 && s < 10)
				g.drawString(h+":0"+m+":0"+s, (size.width - fm.stringWidth(h+":0"+m+":0"+s)) / 2, (size.height) / 2);
			else
				g.drawString(h+":"+m+":"+s, (size.width - fm.stringWidth(h+":"+m+":"+s)) / 2, (size.height) / 2);
		}
		if (this.flgStart == 0) {
			g.drawString(str, (size.width - fm.stringWidth(str)) / 2, (size.height) / 2);
			System.out.println(str);
		}else {
			if (m < 10 && s >= 10)
				str = h+":0"+m+":"+s;
			else if (m >= 10 && s < 10)
				str = h+":"+m+":0"+s;
			else if (m < 10 && s < 10)
				str = h+":0"+m+":0"+s;
			else
				str = h+":"+m+":"+s;
		}
	}
}
