package ex14_6;

public class Messenger {
	private int count = 0;
	private Object lock = new Object();
		
	public void createMessengerThread(final Object lock, final int interval) {	
		new Thread(new Runnable() {
			private final int messageIntervalTime = interval;
			public void run() {
				while(true) {
					while((count % messageIntervalTime) != 0) {
						synchronized(lock) {
							try{
								lock.wait();
							}catch(InterruptedException e) {
								return;
							}
						}
					}
					synchronized(lock) {
						if(count != 0)
							System.out.println("Elapsed " + messageIntervalTime + " second");
						try{
							lock.wait();
						}catch(InterruptedException e) {
							return;
						}
					}
				}
			}
		}).start();
	}
	
	public void createTimeCounterThread(final Object lock) {
		new Thread(new Runnable() {
			public void run() {
				while(true) {
					synchronized(lock){
						try {
							lock.notifyAll();
							lock.wait(1000);
							System.out.println(++count);
						}catch(InterruptedException e) {
							
						}
					}
				}
			}
		}).start();
	}
	
	public static void main(String[] args) {
		Messenger msg = new Messenger();
		msg.createMessengerThread(msg.lock, 15);
		msg.createMessengerThread(msg.lock, 7);
		msg.createTimeCounterThread(msg.lock);
	}
}