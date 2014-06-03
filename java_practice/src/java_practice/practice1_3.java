package java_practice;

public class practice1_3 {
	public static void main(String[] args) {
		System.out.println("Fibonacci");
		int lo = 1,
			hi = 1;
		System.out.println(lo);
		while(hi < 50) {
			System.out.println(hi);
			hi = hi + lo;
			lo = hi - lo;
		}
	}
}
