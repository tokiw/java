package ex17_1;

public class AvailableMemory {
	private static final int objNum = 10000;
	
	public static void main(String[] args) {
		AvailableMemory am = new AvailableMemory();
		Runtime rt = Runtime.getRuntime();

		System.out.println("Before Created Object " + rt.freeMemory());
		
		am.createObj(rt);
		
		System.gc();
		
		System.out.println("After Garbage Collection " + rt.freeMemory());
	}
	
	public void createObj(Runtime rt) {
		Object[] obj = new Object[objNum];
		for(int i = 0; i < objNum; i++) {
			obj[i] = new String("Object No." + i);
		}
		System.out.println("After Created Object " + rt.freeMemory());
	}
	
	public static void fullGC() {
		Runtime rt = Runtime.getRuntime();
		long isFree = rt.freeMemory();
		long wasFree;
		do {
			wasFree = isFree;
			rt.runFinalization();
			rt.gc();
			isFree = rt.freeMemory();
		} while (isFree > wasFree);
		
	}

}
