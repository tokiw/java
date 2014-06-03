package gui1_3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class digitalWatch extends Window implements Runnable, ActionListener{
	static int h;
	static int m;
	static int s;
	boolean watchRun = true;
	static digitalWatch clock = new digitalWatch(new Frame());
	static Thread th = new Thread(clock);
	private static MenuItem closeClock, century, jokerman, broadWay, timesRoman, fs48, fs72, fs96, fs124, fcBlack, fcRed, fcWhite, bgRed, bgBlue, bgGreen, bgYellow;
	private String digitalWatchFont = "Century";
	private int digitalWatchFontSize = 48;
	private int windowWidth = digitalWatchFontSize * 7;
	private int windowHeight = digitalWatchFontSize * 4;
	PopupMenu pm = new PopupMenu();
	private Image clockImage;
	private Graphics gBuffer;
	private static Point windowPoint = new Point(0, 0);
	private Color digitalWatchColor = Color.black;
	private Point startPoint = new Point(0, 0);

	
	public digitalWatch(Window owner) {
		super(owner);
		this.addWindowListener(new myWindowAdapter());
		addMouseMotionListener(new myMouseAdapter(this));
		createPopupMenu();
	}
	
	public void createPopupMenu() {
		Menu font = (Menu) pm.add(new Menu("Font"));
		Menu fontSize = (Menu) pm.add(new Menu("FontSize"));
		Menu fontColor = (Menu) pm.add(new Menu("FontColor"));
		Menu bgColor = (Menu) pm.add(new Menu("BackgroundColor"));
		closeClock = pm.add(new MenuItem("EXIT"));
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
		closeClock.addActionListener(this);
		add(pm);
		addMouseListener(new myMouseAdapter(this));
	}
	
	public void run(){
		while(watchRun){
			h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY); //時を代入
			m = Calendar.getInstance().get(Calendar.MINUTE);      //分を代入
			s= Calendar.getInstance().get(Calendar.SECOND);       //秒を代入
			repaint();									//更新

			try{
				Thread.sleep(1000);  //スリープ１秒
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
		if (obj == digitalWatch.closeClock) {
			System.exit(0);
		}
	}
	public void paint(Graphics g) {
		Dimension size = getSize();
		clockImage = createImage(size.width, size.height);
		gBuffer = clockImage.getGraphics();
		gBuffer.setFont(new Font(digitalWatchFont,Font.BOLD, digitalWatchFontSize));
		gBuffer.setColor(digitalWatchColor);
		FontMetrics fm = gBuffer.getFontMetrics();
		
		if (m < 10 && s >= 10) {
			gBuffer.drawString(h+":0"+m+":"+s, (size.width - fm.stringWidth(h+":0"+m+":"+s)) / 2 , (size.height + fm.getHeight() / 2) / 2);	//drawString(str, int x, int y)
			g.drawImage(clockImage, 0, 0, this);
		}else if (m >= 10 && s < 10) {
			gBuffer.drawString(h+":"+m+":0"+s, (size.width - fm.stringWidth(h+":"+m+":0"+s)) / 2, (size.height + fm.getHeight() / 2) / 2);
			g.drawImage(clockImage, 0, 0, this);
		}else if (m < 10 && s < 10) {
			gBuffer.drawString(h+":0"+m+":0"+s, (size.width - fm.stringWidth(h+":0"+m+":0"+s)) / 2, (size.height + fm.getHeight() / 2) / 2);
			g.drawImage(clockImage, 0, 0, this);
		}else {
			gBuffer.drawString(h+":"+m+":"+s, (size.width - fm.stringWidth(h+":"+m+":"+s)) / 2, (size.height + fm.getHeight() / 2) / 2);
			g.drawImage(clockImage, 0, 0, this);
		}
	}
	
	
	
	/* main */
	public static void main(String args[]){
		clock.setSize(clock.windowWidth, clock.windowHeight);
		clock.setVisible(true);
		clock.setLocation(windowPoint.x, windowPoint.y);
		th.start();   //スレッドスタート
	}

	class myMouseAdapter extends MouseAdapter {
		Point draggingPoint = new Point(0, 0);
		int mouseButton;
		public myMouseAdapter(digitalWatch win) {
			clock = win;
		}
	
		public void mouseReleased(MouseEvent e) {
			if(e.isPopupTrigger()) {
				clock.pm.show(clock, e.getX(), e.getY());
			}
		}
	
		public void mousePressed(MouseEvent e) {
			mouseButton = e.getButton();
			startPoint = e.getPoint();
			//System.out.println(e.getButton());
			super.mousePressed(e);
		}
		
		public void mouseDragged(MouseEvent e) {
			//System.out.println(e.getButton());

			if(e.getButton() == MouseEvent.BUTTON1 || mouseButton == e.getButton()) {
				this.draggingPoint = e.getPoint();
				Point currentPoint = windowPoint;
				windowPoint.x = currentPoint.x + draggingPoint.x - startPoint.x;
				windowPoint.y = currentPoint.y + draggingPoint.y - startPoint.y;
				clock.setLocation(windowPoint.x, windowPoint.y);
			}
			super.mouseDragged(e);
		}
	}
}
	
class myWindowAdapter extends WindowAdapter
{
	public void windowClosing(WindowEvent e){   //×を押されたときの処理
		System.exit(0);
	}
}