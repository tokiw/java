package gui2_2;


import gui1_4.ColorTable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DigitalWatch extends JFrame implements ActionListener {
	static DigitalWatchPanel panel;
	private JMenuItem stopButton = new JMenuItem("stop");
	private JMenuItem startButton = new JMenuItem("start");
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("menu");
	private JMenuItem property = new JMenuItem("property");
	private JMenuItem exit = new JMenuItem("exit");
	private SettingDialog settingDialog;
	private DigitalWatchSetting setting;

	boolean watchRun = true;

	
	public DigitalWatch() {
		setting = new DigitalWatchSetting();
		menu.add(property);
		menu.add(exit);
		property.addActionListener(this);
		exit.addActionListener(this);
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		
		menuBar.add(menu);
		menuBar.add(startButton);
		menuBar.add(stopButton);
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
		if(obj == this.stopButton) {
			panel.stop();
		}
		if(obj == this.startButton) {
			panel.start();
		}
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
	
	class SettingDialog extends JDialog implements ActionListener, ItemListener {
		private JButton okBtn;
		private JButton cancelBtn;
		private GridBagLayout gbl = new GridBagLayout();
		private GridBagConstraints gbc = new GridBagConstraints();
		private JLabel fontLabel = new JLabel("Font");
		private JLabel fontSizeLabel = new JLabel("FontSize");
		private JLabel fontColorLabel = new JLabel("FontColor");
		private JLabel backGroundColorLabel = new JLabel("BackGroundColor");
		private JPanel buttons = new JPanel();
		private JPanel fontColorPanel = new JPanel();
		private JPanel bgColorPanel = new JPanel();
		private List fonts = new List(7);
		private List fontSizes = new List(7);
		private List fontColors = new List(7);
		private List backGroundColors = new List(7);
		private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		private JTextField fontColorChip = new JTextField();
		private JTextField bgColorChip = new JTextField();
		
		public SettingDialog(Frame frame) {
			super(frame);
			setSize(330, 550);
			fontColorChip.setPreferredSize(new Dimension(300, 300));
			setLayout(gbl);
			
			fontColors.addItemListener(this);
			backGroundColors.addItemListener(this);
		
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.NORTH;
			gbl.setConstraints(fontLabel, gbc);
			for(String str : ge.getAvailableFontFamilyNames()) {
				fonts.add(str);
			}
			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.WEST;
			gbl.setConstraints(fonts, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.NORTH;
			gbl.setConstraints(fontSizeLabel, gbc);
						
			for(String str : getFontSizes()) {
				fontSizes.add(str);
			}
			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.WEST;
			gbl.setConstraints(fontSizes, gbc);
			
			fontColorChip.setEditable(false);
			fontColorChip.setBackground(Color.BLACK);
			fontColorChip.setPreferredSize(new Dimension(40, 40));
			fontColorPanel.setPreferredSize(new Dimension(100, 100));
			fontColorPanel.add(fontColorLabel);
			fontColorPanel.add(fontColorChip);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.anchor = GridBagConstraints.CENTER;
			gbl.setConstraints(fontColorPanel, gbc);
			ColorTable[] ct = ColorTable.values();
			for(int i = 0; i < ct.length; i++) {
				fontColors.add(ct[i].toString());
				backGroundColors.add(ct[i].toString());
			}
			
			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.anchor = GridBagConstraints.WEST;
			gbl.setConstraints(fontColors, gbc);
			
			bgColorChip.setEditable(false);
			bgColorChip.setBackground(Color.BLACK);
			bgColorChip.setPreferredSize(new Dimension(40, 40));
			bgColorPanel.setPreferredSize(new Dimension(100, 100));
			bgColorPanel.add(backGroundColorLabel);
			bgColorPanel.add(bgColorChip);
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.anchor = GridBagConstraints.NORTHEAST;
			gbl.setConstraints(bgColorPanel, gbc);
			gbc.gridx = 1;
			gbc.gridy = 3;
			gbc.anchor = GridBagConstraints.WEST;
			gbl.setConstraints(backGroundColors, gbc);
			
			okBtn = new JButton("OK");
			cancelBtn = new JButton("cancel");
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
			add(fontColorPanel);
			add(fontColors);
			add(bgColorPanel);
			add(backGroundColors);
			add(buttons);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e){
					setVisible(false);
				}
			});
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
		
		public void selectSetting() {
			if(fonts.getSelectedItem() != null) {
				setting.setFont(fonts.getSelectedItem());
			}
			if(fontSizes.getSelectedItem() != null) {
				setting.setFontSize(Integer.valueOf(fontSizes.getSelectedItem()));
			}
			if(fontColors.getSelectedItem() != null) {
				setting.setFontColor(ColorTable.getColor(fontColors.getSelectedItem()));
			}
			if(backGroundColors.getSelectedItem() != null) {
				setting.setBGColor(ColorTable.getColor(backGroundColors.getSelectedItem()));
			}
			setFrame();
		}
		
		public void actionPerformed(final ActionEvent ae) {
			Object obj = ae.getSource();
			if(obj == okBtn) {
				selectSetting();
				setVisible(false);
			}
			if(obj == cancelBtn) {
				setVisible(false);
			}
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object obj = e.getSource();
			if(obj == fontColors) {
				fontColorChip.setBackground(ColorTable.getColor(fontColors.getSelectedItem()));
				
			}
			if(obj == backGroundColors) {
				bgColorChip.setBackground(ColorTable.getColor(backGroundColors.getSelectedItem()));
			}
		}

	}
}

class myWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent e){   //�~�������ꂽ�Ƃ��̏���
		System.exit(0);
	}
}
