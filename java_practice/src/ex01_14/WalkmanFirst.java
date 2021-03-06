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
		System.out.println("状態: " + wm.status);
		wm.setMusic("君が代");
		wm.volume = wm.setVolume(30);
		wm.start();
		System.out.println("曲名: " + wm.music + " 音量: " + wm.volume + " 状態: " + wm.status);
	}
}
