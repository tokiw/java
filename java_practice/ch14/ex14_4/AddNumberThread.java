package ex14_4;

public class AddNumberThread implements Runnable {
	private static int sumNumber = 0;
	private int loop = 100;
	
	public void run() {
		for(int i = 0; i < loop; i++) {
			addNumber(1);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO �����������ꂽ catch �u���b�N
				e.printStackTrace();
			}
		}
	}
	
	public static int getSumNumber() {
		return sumNumber;
	}
	
	public static synchronized void addNumber(int number) {
		sumNumber += number;
		System.out.println(sumNumber + " thread: " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		new Thread(new AddNumberThread()).start();
		new Thread(new AddNumberThread()).start();
	}
}
