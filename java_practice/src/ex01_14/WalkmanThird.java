package ex01_14;

public class WalkmanThird {
	private String talk1;
	private String talk2;
	
	public void communicate(String talk1, String talk2) {
		String talk_tmp = talk1;
		talk1 = talk2;
		talk2 = talk_tmp;
	}
}
