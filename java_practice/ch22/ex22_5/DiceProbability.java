package ex22_5;

import java.util.Random;

public class DiceProbability {
	private final int DICE_FACES = 6;
	
	private double[] calculateProbability(int diceNum) {
		double[] probabilities = new double[diceNum * DICE_FACES + 1];
		double denominator = Math.pow(DICE_FACES, diceNum);
		int[] numerator;
		if(diceNum <= 0) {
			throw new IllegalArgumentException();
		}
		numerator = calculatePattern(diceNum);
		for(int i = 0; i < numerator.length; i++) {
			probabilities[i] = numerator[i] / denominator;
		}
		
		return probabilities;
	}
	
	private int[] calculatePattern(int diceNum) {
		int[] dicesVals = new int[diceNum * DICE_FACES + 1];
		if(diceNum == 1) {
			for(int i = 1; i < dicesVals.length; i++) {
				dicesVals[i] = 1;
			}
			return dicesVals;
		}else {
			int[] array = calculatePattern(diceNum-1);
			for(int i = 1; i <= DICE_FACES; i++) {
				for(int j = 0; j < array.length; j++) {
					if(array[j] != 0) {
						dicesVals[i + j] += 1;
					}
				}
			}
			return dicesVals;
		}
	}
	
	private double[] randomProbability(int diceNum, int count) {
		double[] probabilities = new double[diceNum * DICE_FACES + 1];
		int[] dicesVals = new int[diceNum * DICE_FACES + 1];
		Random r = new Random();
		for(int i = 0; i < count; i++) {
			int val = 0;
			for(int j = 0; j < diceNum; j++) {
				val += r.nextInt(DICE_FACES) + 1;
			}
			dicesVals[val] += 1; 
		}
		
		for(int i = 0; i < dicesVals.length; i++) {
			probabilities[i] = dicesVals[i] / (double)count;
		}
		return probabilities;
	}
	
	public static void printComparison(double[] array1, double[] array2) {
		if(array1.length != array2.length) {
			throw new IllegalArgumentException();
		}
		for(int i = 0; i < array1.length; i++) {
			System.out.printf("%3d: %.3f %.3f%n", i, array1[i], array2[i]);
		}
	}
	
	public static void main(String[] args) {
		DiceProbability dice = new DiceProbability();
		double[] probability1 = dice.calculateProbability(3);
		double[] probability2 = dice.randomProbability(3, 10000);
		
		printComparison(probability1, probability2);
	}
}
