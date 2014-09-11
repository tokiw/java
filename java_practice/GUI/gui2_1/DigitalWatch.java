package gui2_1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DigitalWatch extends JFrame implements Runnable, ActionListener {
	static DigitalWatch clock = new DigitalWatch();
	static DigitalWatchPanel panel = new DigitalWatchPanel();
	private JButton stopButton = new JButton("stop");
	private JButton startButton = new JButton("start");

	static Thread th = new Thread(clock);
	private static final int windowWidth = 640;
	private static final int windowHeight = 400;
	boolean watchRun = true;

	
	public DigitalWatch() {
		this.setLayout(new FlowLayout());
		this.add(startButton);
		this.add(stopButton);
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		this.setResizable(false);
		
		this.addWindowListener(new myWindowAdapter());
	}
	
	public void run() {
		while(watchRun){
			panel.setPreferredSize(getSize());
			panel.repaint();
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
			}
		}
	}
	
	@Override
	public void actionPerformed(final ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == this.stopButton) {
			panel.flgStart = 0;
			panel.repaint();
		}
		if(obj == this.startButton) {
			panel.flgStart = 1;
			panel.repaint();
		}
	}
	
	public static void main(String args[]){
		clock.setSize(windowWidth, windowHeight);
		panel.setPreferredSize(clock.getSize());
		clock.add(panel);
		clock.setVisible(true);
		th.start();   //�X���b�h�X�^�[�g
	}
}

class myWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent e){   //�~�������ꂽ�Ƃ��̏���
		System.exit(0);
	}
}