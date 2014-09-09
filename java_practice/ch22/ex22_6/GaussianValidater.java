package ex22_6;

import java.util.*;

public class GaussianValidater {
	private int allocateValue(double value) {
		int index = (int)(value * 10);

		return index + 40;
	}
	
	private void validateGaussian(int count) {
		Random r = new Random();
		final int RANGE = 81;
		int[] values = new int[RANGE];

		for (int i = 0; i < count; i++) {
			double d = r.nextGaussian();
			int index = allocateValue(d);
			values[index] += 1;
		}
		printDistribution(values);
	}
	
	private void printDistribution(int[] values) {
		for (int i = 0; i < values.length; i++) {
			Double d = ((double)i - 40) / 10; 
			System.out.printf("%5.1f: ", d);
			for (int j = 0; j < values[i]; j++) {
				System.out.printf("*");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		GaussianValidater gv = new GaussianValidater();
		gv.validateGaussian(1000);
	}
}
