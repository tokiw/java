package gui2_4;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class DigitalWatchPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String TEMPLATE = "00:00:00";
	static int h;
	static int m;
	static int s;
	int flgStart = 1;
	private DigitalWatchSetting setting;
	Timer timer;
	TimerTask timerTask;
	

	public DigitalWatchPanel(DigitalWatch clock) {
		setting = clock.getSetting();
		setPanelSetting(setting);
		timer = new Timer();
		timerTask = new TimerTask() {
			@Override
			 public void run() {
				repaint();
			};
		};
		timer.schedule(timerTask, 0, 1000);
	}
	
	
	public void setPanelSetting(DigitalWatchSetting setting) {
		Dimension panelSize = getPanelDimension(setting.getFont(), setting.getFontSize());
		setBackground(setting.getBGColor());
		setSize(panelSize);
		setPreferredSize(panelSize);
	}
	
	private Dimension getTimeStrDimension(Font f, String str) {
		FontMetrics ft = this.getFontMetrics(f);
		
		return new Dimension((getWidth() - ft.stringWidth(str))/2, ft.getHeight() - 10);
	}
	
	private Dimension getPanelDimension(String font, int fontSize) {
		Font f = new Font(font, Font.PLAIN, fontSize);
		FontMetrics ft = this.getFontMetrics(f);
		
		return new Dimension(ft.stringWidth(TEMPLATE) + 10, ft.getHeight() + 10);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g.setColor(setting.getBGColor());
		g.fillRect(0, 0, getWidth(), getHeight());
		int h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int m = Calendar.getInstance().get(Calendar.MINUTE);
		int s = Calendar.getInstance().get(Calendar.SECOND);
		
		String time = String.format("%02d:%02d:%02d", h, m, s);
		Font f = new Font(setting.getFont(), Font.PLAIN, setting.getFontSize());
		g.setFont(f);
		g.setColor(setting.getFontColor());
		Dimension timeStrDimension = getTimeStrDimension(f, time);
		g.drawString(time, (int)timeStrDimension.getWidth(), (int)timeStrDimension.getHeight());
	}
}
