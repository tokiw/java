package java_practice;

public class practice1_7 {
	static final int MAX_INDEX = 9;
	/**
	 * 偶数要素に'*'を付けて、フィボナッチ数列の
	 * 最初の方の要素を表示する
	 */
	public static void main (String[] args) {
		int lo = 1,
			hi = 1;
		String mark;
		
		System.out.println(MAX_INDEX + ": " + lo);
		for (int i = MAX_INDEX-1; i >= 1; i--) {
			if (hi % 2 == 0)
				mark = " *";
			else
				mark = "";
			System.out.println(i + ": " + hi + mark);
			hi = hi + lo;
			lo = hi - lo;
		}
	}
}
