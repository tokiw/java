package ex14_3;

public class AddNumberThread implements Runnable {
	private int sumNumber = 0;
	private int loop = 100;
	
	public void run() {
		for(int i = 0; i < loop; i++) {
			addNumber(1);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Ž©“®¶¬‚³‚ê‚½ catch ƒuƒƒbƒN
				e.printStackTrace();
			}
		}
	}
	
	public int getSumNumber() {
		return sumNumber;
	}
	
	public synchronized void addNumber(int number) {
		sumNumber += number;
		System.out.println(getSumNumber() + " thread: " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		AddNumberThread at = new AddNumberThread();
		new Thread(at).start();
		new Thread(at).start();
	}
}
