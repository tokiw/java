package gui2_3;


import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;

public class DigitalWatch extends JWindow implements ActionListener {
	static DigitalWatchPanel panel;
	JPopupMenu pm = new JPopupMenu();
	private DigitalWatchSetting setting;
	static DigitalWatch clock = new DigitalWatch(new JFrame());
	private static Point windowPoint = new Point(0, 0);
	private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private Point startPoint = new Point(0, 0);
	private JMenuItem exit;
	private JMenu font;
	private JMenu fontSize;
	private JMenu fontColor;
	private JMenu bgColor;
	
	public DigitalWatch(Window owner) {
		super(owner);
		this.addWindowListener(new myWindowAdapter());
		addMouseMotionListener(new myMouseAdapter(this));
		setting = new DigitalWatchSetting();
		
		createPopupMenu();
		panel = new DigitalWatchPanel(this);

		getContentPane().setLayout(null);
		getContentPane().add(panel);
		getContentPane().setPreferredSize(panel.getSize());
		pack();
		
		this.addWindowListener(new myWindowAdapter());
	}
	
	public DigitalWatchSetting getSetting() {
		return this.setting;
	}
	
	public void createPopupMenu() {
		font = (JMenu) pm.add(new JMenu("Font"));
		fontSize = (JMenu) pm.add(new JMenu("FontSize"));
		fontColor = (JMenu) pm.add(new JMenu("FontColor"));
		bgColor = (JMenu) pm.add(new JMenu("BackgroundColor"));
		exit = (JMenuItem) pm.add(new JMenuItem("exit"));
		setFont();
		setFontSize();
		setColor();
		add(pm);
		font.addActionListener(this);
		exit.addActionListener(this);
		addMouseListener(new myMouseAdapter(this));
	}
	
	private void setFont() {
		String[] str = ge.getAvailableFontFamilyNames();
		for(int i = 0; i < str.length; i=i+20) {
			font.add(new JMenuItem(str[i])).addActionListener(new FontListener());
		}
	}
	
	private void setFontSize() {
		String fs = "";
		for (int i = 0; i < 20; i++) {
			if (i == 0) {
				fs = "64";
			}else {
				fs = Integer.toString(Integer.valueOf(fs) + 4);
			}
			fontSize.add(new JMenuItem(fs)).addActionListener(new FontSizeListener());
		}
	}

	private void setColor() {
		ColorTable[] ct = ColorTable.values();
		JMenuItem color;
		for(int i = 0; i < ct.length; i++) {
			color = fontColor.add(new JMenuItem(ct[i].toString()));
			color.addActionListener(new FontColorListener());
			color.setBackground(ColorTable.getColor(ct[i].toString()));

			color = bgColor.add(new JMenuItem(ct[i].toString()));
			color.addActionListener(new BgColorListener());
			color.setBackground(ColorTable.getColor(ct[i].toString()));
		}
	}
	
	@Override
	public void actionPerformed(final ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == this.exit) {
			System.exit(0);
		}
	}
	
	public void setFrame() {
		panel.setPanelSetting(setting);
		getContentPane().setPreferredSize(panel.getSize());
		pack();
		repaint();
	}
	
	public static void main(String args[]){
		clock.setVisible(true);
	}
	
	class FontListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			setting.setFont(e.getActionCommand());
			setFrame();
		}
	}
	
	class FontSizeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			setting.setFontSize(Integer.valueOf(e.getActionCommand()));
			setFrame();
		}
	}
	
	class FontColorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			setting.setFontColor(ColorTable.getColor(e.getActionCommand()));
			setFrame();
		}
	}
	
	class BgColorListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			setting.setBgColor(ColorTable.getColor(e.getActionCommand()));
			setFrame();
		}
	}
	
	class myMouseAdapter extends MouseAdapter {
		Point draggingPoint = new Point(0, 0);
		int mouseButton;
		public myMouseAdapter(DigitalWatch win) {
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

class myWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent e){   //�~�������ꂽ�Ƃ��̏���
		System.exit(0);
	}
}
