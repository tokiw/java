package gui1_2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class digitalWatch extends Frame implements Runnable, ActionListener{
	static int h;
	static int m;
	static int s;
	boolean watchRun = true;
	static digitalWatch clock = new digitalWatch();
	static Thread th = new Thread(clock);
	Calendar now = Calendar.getInstance();	//calendarオブジェクトの作成
	private static MenuItem  century, jokerman, broadWay, timesRoman, fs48, fs72, fs96, fs124, fcBlack, fcRed, fcWhite, bgRed, bgBlue, bgGreen, bgYellow;
	private String digitalWatchFont = "Century";
	private int digitalWatchFontSize = 48;
	private int windowWidth = digitalWatchFontSize * 7;
	private int windowHeight = digitalWatchFontSize * 4;

	private Color digitalWatchColor = Color.black;
	

	public digitalWatch() {
		this.addWindowListener(new myWindowAdapter());
		createMenuBar();
	}
	
	public void createMenuBar() {
		MenuBar mb = new MenuBar();
		Menu font = mb.add(new Menu("Font"));
		Menu fontSize = mb.add(new Menu("FontSize"));
		Menu fontColor = mb.add(new Menu("FontColor"));
		Menu bgColor = mb.add(new Menu("BackgroundColor"));
		
		century = font.add(new MenuItem("century"));
		jokerman = font.add(new MenuItem("Jokerman"));
		broadWay = font.add(new MenuItem("BroadWay"));
		timesRoman = font.add(new MenuItem("TimesRoman"));
		fs48 = fontSize.add(new MenuItem("48"));
		fs72 = fontSize.add(new MenuItem("72"));
		fs96 = fontSize.add(new MenuItem("96"));
		fs124 = fontSize.add(new MenuItem("124"));
		fcBlack = fontColor.add(new MenuItem("Black"));
		fcRed = fontColor.add(new MenuItem("Red"));
		fcWhite = fontColor.add(new MenuItem("White"));		
		bgRed = bgColor.add(new MenuItem("Red"));
		bgBlue = bgColor.add(new MenuItem("Blue"));
		bgGreen = bgColor.add(new MenuItem("Green"));
		bgYellow = bgColor.add(new MenuItem("Yellow"));
		
		century.addActionListener(this);
		jokerman.addActionListener(this);
		broadWay.addActionListener(this);
		timesRoman.addActionListener(this);
		fs48.addActionListener(this);
		fs72.addActionListener(this);
		fs96.addActionListener(this);
		fs124.addActionListener(this);
		fcBlack.addActionListener(this);
		fcRed.addActionListener(this);
		fcWhite.addActionListener(this);
		bgRed.addActionListener(this);
		bgBlue.addActionListener(this);
		bgGreen.addActionListener(this);
		bgYellow.addActionListener(this);
		this.setMenuBar(mb);
	}
	
	public void run(){
		while(watchRun){
			h = now.getInstance().get(now.HOUR_OF_DAY); //時を代入
			m = now.getInstance().get(now.MINUTE);      //分を代入
			s= now.getInstance().get(now.SECOND);       //秒を代入
			repaint();									//更新

			try{
				th.sleep(1000);  //スリープ１秒
			}catch(InterruptedException e){
			}
		}
	}
	
	public void actionPerformed(final ActionEvent ae) {
		Object obj = ae.getSource();
		if (obj == digitalWatch.century) {
			this.digitalWatchFont = "century";
			this.repaint();
		}
		if (obj == digitalWatch.jokerman) {
			this.digitalWatchFont = "Jokerman";
			this.repaint();
		}
		if (obj == digitalWatch.broadWay) {
			this.digitalWatchFont = "BroadWay";
			this.repaint();
		}
		if (obj == digitalWatch.timesRoman) {
			this.digitalWatchFont = "TimesRoman";
			this.repaint();
		}
		
		if (obj == digitalWatch.fs48) {
			this.digitalWatchFontSize = 48;
			this.setSize(digitalWatchFontSize * 7, digitalWatchFontSize * 4);
			this.repaint();
		}
		if (obj == digitalWatch.fs72) {
			this.digitalWatchFontSize = 72;
			this.setSize(this.digitalWatchFontSize * 7, this.digitalWatchFontSize * 4);
			this.repaint();
		}
		if (obj == digitalWatch.fs96) {
			this.digitalWatchFontSize = 96;
			this.setSize(this.digitalWatchFontSize * 7, this.digitalWatchFontSize * 4);
			this.repaint();
		}
		if (obj == digitalWatch.fs124) {
			this.digitalWatchFontSize = 124;
			this.setSize(this.digitalWatchFontSize * 7, this.digitalWatchFontSize * 4);
			this.repaint();
		}
		if (obj == digitalWatch.fcBlack) {
			this.digitalWatchColor = Color.black;
			this.repaint();
		}
		if (obj == digitalWatch.fcRed) {
			this.digitalWatchColor = Color.red;
			this.repaint();
		}
		if (obj == digitalWatch.fcWhite) {
			this.digitalWatchColor = Color.white;
			this.repaint();
		}
		if (obj == digitalWatch.bgRed) {
			this.setBackground(Color.red);
		}
		if (obj == digitalWatch.bgBlue) {
			this.setBackground(Color.blue);
		}
		if (obj == digitalWatch.bgGreen) {
			this.setBackground(Color.green);
		}
		if (obj == digitalWatch.bgYellow) {
			this.setBackground(Color.yellow);
		}
	}
	public void paint(Graphics g) {
		Dimension size = getSize();
		g.setFont(new Font(digitalWatchFont,Font.BOLD, digitalWatchFontSize));
		g.setColor(digitalWatchColor);
		FontMetrics fm = g.getFontMetrics();

		if (m < 10 && s >= 10)
			g.drawString(h+":0"+m+":"+s, (size.width - fm.stringWidth(h+":0"+m+":"+s)) / 2 , (size.height + fm.getHeight()) / 2);	//drawString(str, int x, int )
		else if (m >= 10 && s < 10)
			g.drawString(h+":"+m+":0"+s, (size.width - fm.stringWidth(h+":"+m+":0"+s)) / 2, (size.height + fm.getHeight()) / 2);
		else if (m < 10 && s < 10)
			g.drawString(h+":0"+m+":0"+s, (size.width - fm.stringWidth(h+":0"+m+":0"+s)) / 2, (size.height + fm.getHeight()) / 2);
		else
			g.drawString(h+":"+m+":"+s, (size.width - fm.stringWidth(h+":"+m+":"+s)) / 2, (size.height + fm.getHeight()) / 2);
	}
	
	/* main */
	public static void main(String args[]){
		clock.setSize(clock.windowWidth, clock.windowHeight);
		clock.setVisible(true);
		th.start();   //スレッドスタート
	}
}

class myWindowAdapter extends WindowAdapter
{
	public void windowClosing(WindowEvent e){   //×を押されたときの処理
		System.exit(0);
	}
}