package ex06_5;

import java.awt.Color;

public enum SignalColor  {
	RED(){
		Color getColor() {
			return Color.RED;
		}
	},
	
	YELLOW(){
		Color getColor() {
			return Color.YELLOW;
		}
	},
	
	BLUE(){
		Color getColor() {
			return Color.BLUE;
		}
	};
	
	Color color;
		
	abstract Color getColor();
}
