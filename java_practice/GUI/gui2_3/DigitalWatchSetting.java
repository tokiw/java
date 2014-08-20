package gui2_3;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;

public class DigitalWatchSetting {
	private String font;
	private int fontSize;
	private Color fontColor;
	private Color bgColor;
	private String[] availableFont = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	
	public DigitalWatchSetting() {
		this.font = "TimesRoman";
		this.fontSize = 64;
		this.fontColor = Color.BLACK;
		this.bgColor = Color.WHITE;
	}
	
	public void setFont(String font) {
		if(Arrays.asList(availableFont).contains(font)) {
			this.font = font;
		}
	}
	
	public String getFont() {
		return font;
	}
	
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	
	public int getFontSize() {
		return fontSize;
	}
	
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}
	
	public Color getFontColor() {
		return fontColor;
	}
	
	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}
	
	public Color getBGColor() {
		return bgColor;
	}
	
	public DigitalWatchSetting getSetting() {
		try {
			return (DigitalWatchSetting) this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new AssertionError();
		}
	}
}
