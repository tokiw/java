package gui1_2;

import java.awt.GraphicsEnvironment;

public class FontsList {
	public static void main(String[] args) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fs = ge.getAvailableFontFamilyNames();
		for(String name : fs){
			System.out.println(name);
		}
	}
}
