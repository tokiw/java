package ex22_14;

import java.util.StringTokenizer;

public class Calculator {
	
	public static double sum(String str) {
		StringTokenizer in = new StringTokenizer(str);
		double value = 0.0;
		try {
			while (in.hasMoreTokens()) {
				value += Double.valueOf(in.nextToken());
			}
		}catch(NumberFormatException e) {
			throw new IllegalArgumentException("フォーマットが正しくありません");
			
		}
		return value;
	}
	
	public static void main(String[] args) {
		String str = "1.1 2.3 3.56";
		System.out.println("合計: " + sum(str));
	
		str = "a b c";
		System.out.println("合計: " + sum(str));
	}
}
