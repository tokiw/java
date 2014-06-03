package threadPool;

/** 
 * 
 * 
 * @author p000524449
 *
 */

public class ThreadPool {
	private boolean startFlag = false;
	private ThreadWolker[] threads;
	private ThreadQueue threadQueue;
	
	public ThreadPool(int sizeOfQueue, int numberOfThreads) throws IllegalArgumentException {
		if(sizeOfQueue < 1 || numberOfThreads < 1) {
			throw new IllegalArgumentException();
		}else{
		}
		threads = new ThreadWolker[numberOfThreads];
		threadQueue = new ThreadQueue(sizeOfQueue);
	}
	
	public void start() throws IllegalStateException{
		if(startFlag) {
			throw new IllegalStateException();
		}else{
			for(int i = 0; i < threads.length; i++) {
				threads[i] = new ThreadWolker();
				threads[i].start();
			}
			startFlag = true;
		}
	}
	
	public void stop() throws IllegalStateException {
		if(!startFlag) {
			throw new IllegalStateException();
		}
		for(int i = 0; i < threads.length; i++) {
			try {
				if(threads[i].isAlive()) {
					threads[i].stopThread();
					//System.out.println("before join");
					threads[i].join();
				}
					
			} catch (InterruptedException e) {
				return;
			}
		}
	}
	
	public synchronized void dispatch(Runnable task) throws NullPointerException, IllegalStateException{
		if(task == null) {
			throw new NullPointerException();
		}
		if(!startFlag) {
			throw new IllegalStateException();
		}
		threadQueue.add(task);
		/*for(int i = 0; i < threads.length; i++) {
			System.out.println(threads[i].getState());
		}*/
	}
	
	class ThreadWolker extends Thread {
		private boolean stopFlag = false;
		
		public void run() {
			Runnable task = null;
			while(!stopFlag) {
				if(threadQueue.size() != 0) {
					task = threadQueue.remove();
					if(task != null) {
						task.run();
					}
				}
			}
		}
		
		public void stopThread() {
			stopFlag = true;
		}
	}
}
