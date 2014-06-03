package ex13_4;

import java.util.ArrayList;

public class ParserString {
	
	public void parse(String str) { 
		ArrayList<Object> list = new ArrayList<>();
		
		String[] strArray = str.split("\n");

		for(String s : strArray) {
			String type = s.split(" ")[0];
			String value = s.split(" ")[1];
			
			if("Byte".equals(type)) {
				list.add(Byte.parseByte(value));
				
			}else if("Short".equals(type)) {
				list.add(Short.parseShort(value));
				
			}else if("Integer".equals(type)) {
				list.add(Integer.parseInt(value));
				
			}else if("Long".equals(type)) {
				list.add(Long.parseLong(value));
				
			}else if("Float".equals(type)) {
				list.add(Float.parseFloat(value));
				
			}else if("Double".equals(type)) {
				list.add(Double.parseDouble(value));
				
			}else if("Boolean".equals(type)) {
				list.add(Boolean.parseBoolean(value));
				
			}else if("Character".equals(type)) {
				list.add(value.charAt(0));
				
			}
		}
		
		for(Object item : list) {
			System.out.println(item.getClass() + " " + item);
		}
	}
	
	
	public static void main(String[] args) {
		(new ParserString()).parse("Short 5\nDouble 1.2\nLong 234\nBoolean true\nInteger 12\nCharacter a\nByte 3");
	}
}
