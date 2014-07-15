package ex22_6;

import java.util.*;

public class GaussianValidater {
	private int allocateValue(double value, int range) {
		int index = (int)(value * 10);
		index = index < 0 ? index - 1 : index;
		index = index + range * 10;

		return index;
	}
	
	private void validateGaussian(int count, int range) {
		Random r = new Random();
		int[] values = new int[range * 20];		//-3.0`2.9

		for(int i = 0; i < count; i++) {
			double d = r.nextGaussian();
			int index = allocateValue(d, range);
			values[index]++;
		}
		printDistribution(values);
	}
	
	private void printDistribution(int[] values) {
		
	}
	
	public static void main(String[] args) {
		GaussianValidater gv = new GaussianValidater();
		gv.validateGaussian(100, 3);
		
	}
}
