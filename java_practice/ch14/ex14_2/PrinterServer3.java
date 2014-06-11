package ex14_2;


public class PrinterServer3 implements Runnable{
	private final PrintQueue requests = new PrintQueue();
	private Thread printThread;
	private Thread observer;
	
	public PrinterServer3() {
		printThread = new Thread(this);
		observer = new Thread(this);
		printThread.start();
		observer.start();
	}
	public void run() {
		if(Thread.currentThread().equals(printThread)) {
			for(;;) {
				if(requests.size() > 0) {
					try {
						realPrint(requests.remove());
					} catch (InterruptedException e) {
						// TODO é©ìÆê∂ê¨Ç≥ÇÍÇΩ catch ÉuÉçÉbÉN
						e.printStackTrace();
					}
				}
			}
		}
		System.err.println("This is Illegal Thread");
	}
	
	public void print(PrintJob job) {
		requests.add(job);
	}
	private void realPrint(PrintJob job) {
		job.startPrint();
	}
	public static void main(String[] args) {
		PrinterServer3 ps3 = new PrinterServer3();
		PrintJob job = new PrintJob();
		ps3.print(job);
	}
}

class PrintJob {
	public void startPrint() {
		System.out.println("Print Start");
	}
}
