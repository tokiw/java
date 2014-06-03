package ex9_1;

public class infinity {
	public static void main(String[] args) {
		float positive = Float.POSITIVE_INFINITY;
		float negative = Float.NEGATIVE_INFINITY;

		System.out.println("‡ + ‡ : " + (positive + positive));
		System.out.println("‡ - ‡ : " + (positive - positive));
		System.out.println("‡ * ‡ : " + (positive * positive));
		System.out.println("‡ / ‡ : " + (positive / positive));
		System.out.println("");
		
		System.out.println("‡ + -‡ : " + (positive + negative));
		System.out.println("‡ - -‡ : " + (positive - negative));
		System.out.println("‡ * -‡ : " + (positive * negative));
		System.out.println("‡ / -‡ : " + (positive / negative));
		System.out.println("");
		
		System.out.println("-‡ + -‡ : " + (negative + negative));
		System.out.println("-‡ - -‡ : " + (negative - negative));
		System.out.println("-‡ * -‡ : " + (negative * negative));
		System.out.println("-‡ / -‡ : " + (negative / negative));
	}
}
