package ex01_14;

public class WalkmanFirst {
	private int volume;
	private Object music;
	private String status = "off";
	
	public void start() {
		status = "on";
	}
	
	public void stop() {
		status = "off";
	}
	
	public void setMusic(Object music) {
		this.music = music;
	}
	
	public Object getMusic() {
		return music;
	}
	public int setVolume(int volume) {
		this.volume = volume;
		return volume;
	}
	
	public static void main(String[] args) {
		WalkmanFirst wm = new WalkmanFirst();
		System.out.println("���: " + wm.status);
		wm.setMusic("�N����");
		wm.volume = wm.setVolume(30);
		wm.start();
		System.out.println("�Ȗ�: " + wm.music + " ����: " + wm.volume + " ���: " + wm.status);
	}
}
