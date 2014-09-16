package gui2_4;


import gui1_4.ColorTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;

public class DigitalWatch extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Preferences prefs = Preferences.userNodeForPackage(this.getClass());
	static DigitalWatchPanel panel;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("menu");
	private JMenuItem property = new JMenuItem("property");
	private JMenuItem exit = new JMenuItem("exit");
	private SettingDialog settingDialog;
	private DigitalWatchSetting setting;
	private static String digitalWatchFont;
	private static int digitalWatchFontSize;
	private Color digitalWatchColor;
	private Color watchBackGroundColor;
	
	boolean watchRun = true;

	
	public DigitalWatch() {
		digitalWatchFont = prefs.get("font", "Century");
		digitalWatchFontSize = prefs.getInt("fontSize", 48);
		digitalWatchColor = new Color(prefs.getInt("fontColor", -16777216));
		watchBackGroundColor = new Color(prefs.getInt("backGroundColor", -1));
		setting = new DigitalWatchSetting();
		setting.setFont(digitalWatchFont);
		setting.setFontSize(digitalWatchFontSize);
		setting.setFontColor(digitalWatchColor);
		setting.setBGColor(watchBackGroundColor);
		setBounds(prefs.getInt("x", 0), prefs.getInt("y", 0), getSize().width, getSize().height);
		
		menu.add(property);
		menu.add(exit);
		property.addActionListener(this);
		exit.addActionListener(this);
		
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		this.setResizable(false);
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
	
	@Override
	public void actionPerformed(final ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == this.property) {
			showDialog();
		}
		if(obj == this.exit) {
			System.exit(0);
		}
	}
	
	public void showDialog() {
		settingDialog = new SettingDialog(new Frame());
		settingDialog.setVisible(true);
	}
	
	public void setFrame() {
		panel.setPanelSetting(setting);
		getContentPane().setPreferredSize(panel.getSize());
		pack();
		repaint();
	}
	
	public static void main(String args[]){
		DigitalWatch clock = new DigitalWatch();
		clock.setVisible(true);
	}
	
	class SettingDialog extends JDialog implements ActionListener, MouseListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JButton okBtn;
		private JButton cancelBtn;
		private GridBagLayout gbl = new GridBagLayout();
		private GridBagConstraints gbc = new GridBagConstraints();
		private DefaultListModel<String> fontsModel = new DefaultListModel<>();
		private DefaultListModel<String> fontSizesModel = new DefaultListModel<>();
		private DefaultListModel<String> fontColorsModel = new DefaultListModel<>();
		private DefaultListModel<String> bgColorsModel = new DefaultListModel<>();
		private JLabel fontLabel = new JLabel("Font  ");
		private JLabel fontSizeLabel = new JLabel("FontSize  ");
		private JLabel fontColorLabel = new JLabel("FontColor  ");
		private JLabel backGroundColorLabel = new JLabel("BackGroundColor  ");
		private JPanel buttons = new JPanel();
		private JList<String> fontsList = new JList<>(fontsModel);
		private JList<String> fontSizesList = new JList<>(fontSizesModel);
		private JList<String> fontColorsList = new JList<>(fontColorsModel);
		private JList<String> bgColorsList = new JList<>(bgColorsModel);
		private JScrollPane fontsSp = new JScrollPane();
		private JScrollPane fontSizesSp = new JScrollPane();
		private JScrollPane fontColorsSp = new JScrollPane();
		private JScrollPane bgColorsSp = new JScrollPane();
		private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		private String currentFont;
		private int currentFontSize;
		private Color currentFontColor;
		private Color currentBackGroundColor;
		
		public SettingDialog(Frame frame) {
			super(frame);
			setSize(330, 700);
			setResizable(false);
			setLayout(gbl);
			MyCellRenderer<String> renderer = new MyCellRenderer<>();
			
			currentFont = digitalWatchFont;
			currentFontSize = digitalWatchFontSize;
			currentFontColor = digitalWatchColor;
			currentBackGroundColor = watchBackGroundColor;
			
			/* font */
			setConstraints(gbc, 0, 0, GridBagConstraints.NORTHEAST);
			gbl.setConstraints(fontLabel, gbc);
			for(String str : ge.getAvailableFontFamilyNames()) {
				fontsModel.addElement(str);
			}
			fontsSp.getViewport().setView(fontsList);
			fontsList.addMouseListener(this);
			fontsSp.setPreferredSize(new Dimension(160, 150));
			setConstraints(gbc, 1, 0, GridBagConstraints.WEST);
			gbl.setConstraints(fontsSp, gbc);
			
			/* font size */
			setConstraints(gbc, 0, 1, GridBagConstraints.NORTHEAST);
			gbl.setConstraints(fontSizeLabel, gbc);
						
			for(String str : getFontSizes()) {
				fontSizesModel.addElement(str);
			}
			fontSizesSp.getViewport().setView(fontSizesList);
			fontSizesList.addMouseListener(this);
			fontSizesSp.setPreferredSize(new Dimension(160, 150));
			setConstraints(gbc, 1, 1, GridBagConstraints.WEST);
			gbl.setConstraints(fontSizesSp, gbc);
			
			/* font color */
			setConstraints(gbc, 0, 2, GridBagConstraints.NORTHEAST);
			gbl.setConstraints(fontColorLabel, gbc);
			ColorTable[] ct = ColorTable.values();
			for(int i = 0; i < ct.length; i++) {
				fontColorsModel.addElement(ct[i].toString());
				bgColorsModel.addElement(ct[i].toString());
			}
			fontColorsSp.getViewport().setView(fontColorsList);
			fontColorsList.addMouseListener(this);
			fontColorsSp.setPreferredSize(new Dimension(160, 150));
			setConstraints(gbc, 1, 2, GridBagConstraints.WEST);
			gbl.setConstraints(fontColorsSp, gbc);
			fontColorsList.setCellRenderer(renderer);
			
			/* background color */
			setConstraints(gbc, 0, 3, GridBagConstraints.NORTHEAST);
			gbl.setConstraints(backGroundColorLabel, gbc);
			
			bgColorsSp.getViewport().setView(bgColorsList);
			bgColorsList.addMouseListener(this);
			bgColorsSp.setPreferredSize(new Dimension(160, 150));
			setConstraints(gbc, 1, 3, GridBagConstraints.WEST);
			gbl.setConstraints(bgColorsSp, gbc);
			bgColorsList.setCellRenderer(renderer);
			
			okBtn = new JButton("OK");
			cancelBtn = new JButton("cancel");
			okBtn.addActionListener(this);
			cancelBtn.addActionListener(this);
			buttons.add(okBtn);
			buttons.add(cancelBtn);
			
			setConstraints(gbc, 1, 4, GridBagConstraints.SOUTHEAST);
			gbl.setConstraints(buttons, gbc);
			add(fontLabel);
			add(fontsSp);
			add(fontSizeLabel);
			add(fontSizesSp);
			add(fontColorLabel);
			add(fontColorsSp);
			add(backGroundColorLabel);
			add(bgColorsSp);
			add(buttons);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e){
					setVisible(false);
				}
			});
		}
		
		void setConstraints(GridBagConstraints constraints, int x, int y, int position) {
			constraints.gridx = x;
			constraints.gridy = y;
			constraints.anchor = position;
		}
		
		private String[] getFontSizes() {
			String[] fs = new String[20];
			for (int i = 0; i < fs.length; i++) {
				if (i == 0) {
					fs[i] = "64";
				}else {
					fs[i] = Integer.toString(Integer.valueOf(fs[i-1]) + 4);
				}
			}
			return fs;
		}
		
		public void setSetting() {
			setting.setFont(digitalWatchFont);
			setting.setFontSize(digitalWatchFontSize);
			setting.setFontColor(digitalWatchColor);
			setting.setBGColor(watchBackGroundColor);
			setFrame();
		}
		public void selectSetting() {
			if(fontsList.getSelectedValue() != null) {
				digitalWatchFont = fontsList.getSelectedValue();
			}
			if(fontSizesList.getSelectedValue() != null) {
				digitalWatchFontSize = Integer.valueOf(fontSizesList.getSelectedValue());
			}
			if(fontColorsList.getSelectedValue() != null) {
				digitalWatchColor = ColorTable.getColor(fontColorsList.getSelectedValue());
			}
			if(bgColorsList.getSelectedValue() != null) {
				watchBackGroundColor = ColorTable.getColor(bgColorsList.getSelectedValue());
			}
			setSetting();
		}
		
		public void actionPerformed(final ActionEvent ae) {
			Object obj = ae.getSource();
			if(obj == okBtn) {
				setVisible(false);
			}
			if(obj == cancelBtn) {
				resetProperty();
				setSetting();
				setVisible(false);
			}
		}
		
		public void resetProperty() {
			digitalWatchFont = currentFont;
			digitalWatchFontSize = currentFontSize;
			digitalWatchColor = currentFontColor;
			watchBackGroundColor = currentBackGroundColor;
			
			setFrame();
		}


		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			selectSetting();
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

	}
	
	class MyCellRenderer<E> implements ListCellRenderer<E> {
		JLabel label;
		ColorTable[] ct = ColorTable.values();
		
		public MyCellRenderer() {
			label = new JLabel();
			label.setOpaque(true);
		}

		@Override
		public Component getListCellRendererComponent(JList<? extends E> list,
				E value, int arg2, boolean isSelected, boolean cellHasFocus) {
			label.setText(value.toString());
			label.setBackground(ColorTable.getColor(value.toString()));
			
			if (isSelected) {
				label.setBorder(new LineBorder(Color.black, 3));
			}else {
				label.setBorder(null);
			}
			
			return label;
		}
		
		
	}


	class myWindowAdapter extends WindowAdapter {
		public void windowClosing(WindowEvent e){
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
