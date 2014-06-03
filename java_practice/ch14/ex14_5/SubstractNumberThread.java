package ex14_5;

public class SubstractNumberThread implements Runnable {
	private static int sumNumber = 200;
	private int loop = 100;
	protected static final Object lock = new Object();
	
	public void run() {
		for(int i = 0; i < loop; i++) {
			substractNumber(1);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Ž©“®¶¬‚³‚ê‚½ catch ƒuƒƒbƒN
				e.printStackTrace();
			}
		}
	}
		
	public void substractNumber(int number) {
		synchronized(lock) {
			sumNumber -= number;
			System.out.println(sumNumber + " thread: " + Thread.currentThread().getName());
		}
		
	}
	
	public static void main(String[] args) {
		new Thread(new SubstractNumberThread()).start();
		new Thread(new SubstractNumberThread()).start();
	}
}

