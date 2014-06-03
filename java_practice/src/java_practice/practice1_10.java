package java_practice;

public class practice1_10 {
	static final int MAX_INDEX = 9;
	/**
	 * 偶数要素に'*'を付けて、フィボナッチ数列の
	 * 最初の方の要素を表示する
	 */
	public static void main (String[] args) {
		int lo = 1,
			hi = 1;
		FibonacciParam data =new FibonacciParam();
		data.values = new int[MAX_INDEX];
		data.bools = new boolean[MAX_INDEX];
		
		data.values[0] = 1;
		data.bools[0] = false;
		
		for (int i = 2; i <= MAX_INDEX; i++) {
			data.values[i-1] = hi;
			if (hi % 2 == 0)
				data.bools[i-1] = true;
			else
				data.bools[i-1] = false;
			
			hi = hi + lo;
			lo = hi - lo;
		}
		
		for (int i = 1; i <= MAX_INDEX; i++) {
			if (data.bools[i-1] == true)
				System.out.println(i + ": " + data.values[i-1] + " *");
			else
				System.out.println(i + ": " + data.values[i-1]);
		}
	}
}

class FibonacciParam {
	int	values[];
	boolean bools[];
}