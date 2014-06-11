package gui1_1;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
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
	Button stopButton;
	Button startButton;
	private static final String button01 = "start";
	private static final String button02 = "stop";
	int flgStart = 1;
	private static final int windowWidth = 640;
	private static final int windowHeight = 400;
	private static String str;
	

	public digitalWatch() {
		this.setLayout(new FlowLayout());
		Button startButton = new Button(button01);
		Button stopButton = new Button(button02);
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		this.add(startButton);
		this.add(stopButton);
		this.addWindowListener(new myWindowAdapter());
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
		if (ae.getActionCommand() == digitalWatch.button01) {
			this.flgStart = 1;
			this.repaint();
		}
		if (ae.getActionCommand() == digitalWatch.button02) {
			this.flgStart = 0;
			this.repaint();
		}
	}
	public void paint(Graphics g)
	{
		Dimension size = getSize();
		g.setFont(new Font("TimesRoman",Font.ITALIC, 1 * size.width / 10));
		FontMetrics fm = g.getFontMetrics();
		g.clearRect(0, 0, digitalWatch.windowWidth - 1, digitalWatch.windowHeight - 1);
			
		if (this.flgStart == 1) {
			if (m < 10 && s >= 10)
				g.drawString(h+":0"+m+":"+s, (size.width - fm.stringWidth(h+":0"+m+":"+s)) / 2 , (size.height + fm.getHeight()) / 2);	//drawString(str, int x, int )
			else if (m >= 10 && s < 10)
				g.drawString(h+":"+m+":0"+s, (size.width - fm.stringWidth(h+":"+m+":0"+s)) / 2, (size.height + fm.getHeight()) / 2);
			else if (m < 10 && s < 10)
				g.drawString(h+":0"+m+":0"+s, (size.width - fm.stringWidth(h+":0"+m+":0"+s)) / 2, (size.height + fm.getHeight()) / 2);
			else
				g.drawString(h+":"+m+":"+s, (size.width - fm.stringWidth(h+":"+m+":"+s)) / 2, (size.height + fm.getHeight()) / 2);
		}
		if (this.flgStart == 0) {
			g.drawString(str, (size.width - fm.stringWidth(str)) / 2, (size.height + fm.getHeight()) / 2);

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
	
	/* main */
	public static void main(String args[]){
		clock.setSize(digitalWatch.windowWidth, digitalWatch.windowHeight);
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