package ex14_1;

public class MainThread {
	public static void main(String[] args) {
		System.out.println("main: " + Thread.currentThread().getName());
		Thread t1 = new Thread();
		t1.start();
		System.out.println("ti: " + t1.getName());
	}
}
	