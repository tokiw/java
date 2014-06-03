package ex14_2;


public class PrinterServer3 implements Runnable{
	private final PrintQueue requests = new PrintQueue();
	private Thread printerThread;
	
	public PrinterServer3() {
		printerThread = new Thread(this);
		printerThread.start();
	}
	public void run() {
		if(Thread.currentThread().equals(printerThread)) {
			System.err.println("Please call properly for run()");
			return;
		}
		for(;;) {
			try {
				realPrint(requests.remove());
			} catch (InterruptedException e) {
				// TODO é©ìÆê∂ê¨Ç≥ÇÍÇΩ catch ÉuÉçÉbÉN
				e.printStackTrace();
			}
		}
	}
	
	public void print(PrintJob job) {
		requests.add(job);
	}
	private void realPrint(PrintJob job) {
		
	}
	public static void main(String[] args) {
		PrinterServer3 ps3 = new PrinterServer3();
		ps3.run();
		System.out.println("aaa");
	}
}

class PrintJob {
	
}
