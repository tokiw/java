package ex22_1;

public class FormatterDoubleArray {
	
	public static void main(String[] args) {
        double[] data = {12, -1.234, 1.0 / 3, 12.3456e-7};
        new FormatterDoubleArray().printDoubleArray(data, 10);
    }
	
	public void printDoubleArray(double[] array, int row) { 
		if(array == null) {
			throw new NullPointerException();
		}
		if(row <= 0) {
			throw new IllegalArgumentException();
		}
		for(double d : array) {
			int i = (int)d;
			int r = row - String.valueOf(i).length();
			System.out.printf("%." + r + "f%n", d);
		}
	}
}
