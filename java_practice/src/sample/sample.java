package sample;

public class sample {
	public static void main(String[] args) throws Exception {
	try {
		Integer.bitCount(1);
	}catch(Exception e) {
		e.getCause().toString();
	}
		
	}
}