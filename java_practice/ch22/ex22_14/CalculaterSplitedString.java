package ex22_14;

import java.util.StringTokenizer;

public class CalculaterSplitedString {
	public double calulate(String str) {
		StringTokenizer tokens = new StringTokenizer(str);
		double value = 0.0;
		
		while(tokens.hasMoreTokens()) {
			value += Double.valueOf(tokens.nextToken());
		}
		
		return value;
	}
	
	public static void main(String[] args) {
		String str = "1.0 2.1 3.45";
		CalculaterSplitedString css = new CalculaterSplitedString();
		System.out.printf("合計: %.3f", css.calulate(str));
	}
}
