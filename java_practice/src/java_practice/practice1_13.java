package java_practice;

public class practice1_13 {
	static final int MAX_INDEX = 9;
	/**
	 * 偶数要素に'*'を付けて、フィボナッチ数列の
	 * 最初の方の要素を表示する
	 */
	public static void main (String[] args) {
		int lo = 1,
			hi = 1;
		FibonacciPar data =new FibonacciPar();
		data.print_str = new String[MAX_INDEX];
		
		data.print_str[0] = "0: " + hi;
		
		for (int i = 2; i <= MAX_INDEX; i++) {
			if (hi % 2 == 0)
				data.print_str[i-1] = i + ": " + hi + " *";
			else
				data.print_str[i-1] = i + ": " + hi;
			
			hi = hi + lo;
			lo = hi - lo;
		}
		
		for (int i = 0; i < MAX_INDEX; i++) {
				System.out.printf("%s%n", data.print_str[i]);
		}
	}
}

class FibonacciPar {
	String print_str[];
}