package gui2_2;

import java.awt.Color;


public enum ColorTable {
	BLACK("black"),
	BLUE("blue"),
	CYAN("cyan"),
	DARKGRAY("darkGray"),
	GRAY("gray"),
	GREEN("green"),
	LIGHTGRAY("lightGray"),
	MAGENTA("magenta"),
	ORANGE("orange"),
	PINK("pink"),
	RED("red"),
	WHITE("white"),
	YELLOW("yellow");
	
	String name;
	static Color color;
	ColorTable(String name) {
		this.name = name;
	}
	public static Color getColor(String name) {
		switch (name) {
			case "black":     color = Color.black;     break;
			case "blue":      color = Color.blue;      break;
			case "cyan":      color = Color.cyan;      break;
			case "darkGray":  color = Color.darkGray;  break;
			case "gray":      color = Color.gray;      break;
			case "green":     color = Color.green;     break;
			case "lightGray": color = Color.lightGray; break;
			case "magenta":   color = Color.magenta;   break;
			case "orange":    color = Color.orange;    break;
			case "pink":      color = Color.pink;      break;
			case "red":       color = Color.red;       break;
			case "white":     color = Color.white;     break;
			case "yellow":    color = Color.yellow;    break;
			default:          color = null;            break;
		}
		return color;
	}
	public String toString() {return name;}
}
