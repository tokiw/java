package ex06_4;

import java.awt.Color;

public enum SignalColor  {
	RED(Color.RED),
	YELLOW(Color.YELLOW),
	BLUE(Color.BLUE);
	
	final Color color;
	
	SignalColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}
}
