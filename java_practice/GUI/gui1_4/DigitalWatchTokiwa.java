package gui1_4;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.prefs.Preferences;

public class DigitalWatchTokiwa extends Frame implements Runnable, ActionListener{
	private Preferences prefs = Preferences.userNodeForPackage(this.getClass());

	static int h;
	static int m;
	static int s;
	boolean watchRun = true;
	static DigitalWatchTokiwa clock = new DigitalWatchTokiwa();
	static Thread th = new Thread(clock);
	Calendar now = Calendar.getInstance();	//calendarオブジェクトの作成
	private static MenuItem dialog;
	private static String digitalWatchFont;
	private static int digitalWatchFontSize;
	private static int windowWidth = digitalWatchFontSize * 7;
	private static int windowHeight = digitalWatchFontSize * 4;
	private Image clockImage;
	private Graphics gBuffer;
	private SettingDialog settingDialog;

	private Color digitalWatchColor;
	private Color watchBackGroundColor;
	

	public DigitalWatchTokiwa() {
		this.addWindowListener(new myWindowAdapter());
		digitalWatchFont = prefs.get("font", "Century");
		digitalWatchFontSize = prefs.getInt("fontSize", 48);
		digitalWatchColor = new Color(prefs.getInt("fontColor", -16777216));
		watchBackGroundColor = new Color(prefs.getInt("backGroundColor", -1));
		setBackground(watchBackGroundColor);
		setBounds(prefs.getInt("x", 0), prefs.getInt("y", 0), windowWidth, windowHeight);
		createMenuBar();
	}
	
	public void createMenuBar() {
		MenuBar mb = new MenuBar();
		Menu menu = mb.add(new Menu("Menu"));
		dialog = menu.add(new MenuItem("Property"));
		dialog.addActionListener(this);
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
	
	public void setFontSize(int size) {
		digitalWatchFontSize = size;
	}
	
	public void actionPerformed(final ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == DigitalWatchTokiwa.dialog) {
			showDialog();
		}
	}
	
	public void showDialog() {
		settingDialog = new SettingDialog(new Frame());
		settingDialog.setVisible(true);
	}
	public void paint(Graphics g) {
		Dimension size = getSize();
		clockImage = createImage(size.width, size.height);
		gBuffer = clockImage.getGraphics();
		gBuffer.setFont(new Font(digitalWatchFont, Font.BOLD, digitalWatchFontSize));
		gBuffer.setColor(digitalWatchColor);
		FontMetrics fm = gBuffer.getFontMetrics();
		
		if (m < 10 && s >= 10) {
			gBuffer.drawString(h+":0"+m+":"+s, (size.width - fm.stringWidth(h+":0"+m+":"+s)) / 2 , (size.height + fm.getHeight()) / 2);	//drawString(str, int x, int y)
			g.drawImage(clockImage, 0, 0, this);
		}else if (m >= 10 && s < 10) {
			gBuffer.drawString(h+":"+m+":0"+s, (size.width - fm.stringWidth(h+":"+m+":0"+s)) / 2, (size.height + fm.getHeight()) / 2);
			g.drawImage(clockImage, 0, 0, this);
		}else if (m < 10 && s < 10) {
			gBuffer.drawString(h+":0"+m+":0"+s, (size.width - fm.stringWidth(h+":0"+m+":0"+s)) / 2, (size.height + fm.getHeight()) / 2);
			g.drawImage(clockImage, 0, 0, this);
		}else {
			gBuffer.drawString(h+":"+m+":"+s, (size.width - fm.stringWidth(h+":"+m+":"+s)) / 2, (size.height + fm.getHeight()) / 2);
			g.drawImage(clockImage, 0, 0, this);
		}
	}
	
	/* main */
	public static void main(String args[]){
		clock.setSize(clock.windowWidth, clock.windowHeight);
		clock.setVisible(true);
		th.start();   //スレッドスタート
	}

	class SettingDialog extends Dialog implements ActionListener, ItemListener {
		private Button okBtn;
		private Button cancelBtn;
		private GridBagLayout gbl = new GridBagLayout();
		private GridBagConstraints gbc = new GridBagConstraints();
		private Label fontLabel = new Label("Font");
		private Label fontSizeLabel = new Label("FontSize");
		private Label fontColorLabel = new Label("FontColor");
		private Label backGroundColorLabel = new Label("BackGroundColor");
		private Panel buttons = new Panel();
		private List fonts = new List(5);
		private List fontSizes = new List(5);
		private List fontColors = new List(5);
		private List backGroundColors = new List(5);
		private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		private String currentFont;
		private int currentFontSize;
		private Color currentFontColor;
		private Color currentBackGroundColor;
		
		public SettingDialog(Frame frame) {
			super(frame);
			setSize(400, 400);
			
			setLayout(gbl);
			
			currentFont = digitalWatchFont;
			currentFontSize = digitalWatchFontSize;
			currentFontColor = digitalWatchColor;
			currentBackGroundColor = watchBackGroundColor;
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.NORTHEAST;
			gbl.setConstraints(fontLabel, gbc);
			for(String str : ge.getAvailableFontFamilyNames()) {
				fonts.add(str);
			}
			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.WEST;
			gbl.setConstraints(fonts, gbc);
			fonts.addItemListener(this);
			
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.NORTHEAST;
			gbl.setConstraints(fontSizeLabel, gbc);
			for(String str : getFontSizes()) {
				fontSizes.add(str);
			}
			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.WEST;
			gbl.setConstraints(fontSizes, gbc);
			fontSizes.addItemListener(this);
			
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.anchor = GridBagConstraints.NORTHEAST;
			gbl.setConstraints(fontColorLabel, gbc);
			ColorTable[] ct = ColorTable.values();
			for(int i = 0; i < ct.length; i++) {
				fontColors.add(ct[i].toString());
				backGroundColors.add(ct[i].toString());
			}
			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.anchor = GridBagConstraints.WEST;
			gbl.setConstraints(fontColors, gbc);
			fontColors.addItemListener(this);
			
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.anchor = GridBagConstraints.NORTHEAST;
			gbl.setConstraints(backGroundColorLabel, gbc);
			gbc.gridx = 1;
			gbc.gridy = 3;
			gbc.anchor = GridBagConstraints.WEST;
			gbl.setConstraints(backGroundColors, gbc);
			backGroundColors.addItemListener(this);
			
			okBtn = new Button("OK");
			cancelBtn = new Button("cancel");
			okBtn.addActionListener(this);
			cancelBtn.addActionListener(this);
			buttons.add(okBtn);
			buttons.add(cancelBtn);
			gbc.gridx = 1;
			gbc.gridy = 4;
			gbc.anchor = GridBagConstraints.SOUTHEAST;
			gbl.setConstraints(buttons, gbc);
			add(fontLabel);
			add(fonts);
			add(fontSizeLabel);
			add(fontSizes);
			add(fontColorLabel);
			add(fontColors);
			add(backGroundColorLabel);
			add(backGroundColors);
			add(buttons);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e){   //×を押されたときの処理
					setVisible(false);
				}
			});
		}
		
		private String[] getFontSizes() {
			String[] fs = new String[30];
			for (int i = 0; i < fs.length; i++) {
				if (i == 0) {
					fs[i] = "10";
				}else if (i == 1){
					fs[i] = "11";
				}else if (i == 2) {
					fs[i] = "12";
				}else if (Integer.valueOf(fs[i-1]) < 32){
					fs[i] = Integer.toString(Integer.valueOf(fs[i-1]) + 2);
				}else {
					fs[i] = Integer.toString(Integer.valueOf(fs[i-1]) + 4);
				}
			}
			return fs;
		}
		
		public void selectSetting() {
			if(fonts.getSelectedItem() != null) {
				digitalWatchFont = fonts.getSelectedItem();
			}
			if(fontSizes.getSelectedItem() != null) {
				setFontSize(Integer.valueOf(fontSizes.getSelectedItem()));
				clock.setSize(digitalWatchFontSize * 7, digitalWatchFontSize * 4);
			}
			if(fontColors.getSelectedItem() != null) {
				clock.digitalWatchColor = ColorTable.getColor(fontColors.getSelectedItem());
			}
			if(backGroundColors.getSelectedItem() != null) {
				watchBackGroundColor = ColorTable.getColor(backGroundColors.getSelectedItem());
				clock.setBackground(watchBackGroundColor);
			}
			repaint();
		}
		
		public void actionPerformed(final ActionEvent ae) {
			Object obj = ae.getSource();
			if(obj == okBtn) {
				//selectSetting();
				setVisible(false);
			}
			if(obj == cancelBtn) {
				resetProperty();
				setVisible(false);
			}
		}

		public void resetProperty() {
			digitalWatchFont = currentFont;
			digitalWatchFontSize = currentFontSize;
			clock.setSize(digitalWatchFontSize * 7, digitalWatchFontSize * 4);
			digitalWatchColor = currentFontColor;
			watchBackGroundColor = currentBackGroundColor;
			clock.setBackground(watchBackGroundColor);
			repaint();
		}
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			Object obj = e.getSource();
			if(obj == fonts) {
				digitalWatchFont = fonts.getSelectedItem();
				repaint();
			}
			if(obj == fontSizes) {
				setFontSize(Integer.valueOf(fontSizes.getSelectedItem()));
				clock.setSize(digitalWatchFontSize * 7, digitalWatchFontSize * 4);
				repaint();
			}
			if(obj == fontColors) {
				clock.digitalWatchColor = ColorTable.getColor(fontColors.getSelectedItem());
				repaint();
			}
			if(obj == backGroundColors) {
				watchBackGroundColor = ColorTable.getColor(backGroundColors.getSelectedItem());
				clock.setBackground(watchBackGroundColor);
				repaint();
			}
		}
	}
	class myWindowAdapter extends WindowAdapter {
		public void windowClosing(WindowEvent e){   //×を押されたときの処理
			prefs.putInt("x", getBounds().x);
			prefs.putInt("y", getBounds().y);
			prefs.put("font", digitalWatchFont);
			prefs.putInt("fontSize", digitalWatchFontSize);
			prefs.putInt("fontColor", digitalWatchColor.getRGB());
			prefs.putInt("backGroundColor", watchBackGroundColor.getRGB());
			System.exit(0);
		}
	}
}