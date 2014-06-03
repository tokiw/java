package java_practice;

public class practice1_9 {
	static final String TITLE = "Fibonacci";
	static final int MAX_INDEX = 9;
	public static void main(String[] args) {
		System.out.println(TITLE);
		int values[];
		values = new int[MAX_INDEX];
		int lo = 1,
			hi = 1;
		values[0] = lo;
		
		for (int i = 2; i <= MAX_INDEX; i++ ) {
			values[i-1] = hi;
			hi = hi + lo;
			lo = hi - lo;
		}
		for (int i = 1; i <= MAX_INDEX; i++ ) {
			System.out.println(i + ": " + values[i-1]);
		}
	}
}

class Data {
	int[] values;
}