package ex22_1;

public class FormatterDoubleArray {
	
	public static void main(String[] args) {
        double[] data = {12, -1.234, 1.0 / 3, 12.3456e-7};
        new FormatterDoubleArray().printDoubleArray(data, 80);
    }
	
	public void printDoubleArray(double[] array, int row) { 
		if(array == null) {
			throw new NullPointerException();
		}
		if(row <= 0) {
			throw new IllegalArgumentException();
		}
		for(double a : array) {
			int i = (int)a;
			int d = row - String.valueOf(i).length();
			System.out.printf("%." + d + "f%n", a);
		}
	}
}
