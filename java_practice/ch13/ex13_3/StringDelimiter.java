package ex13_3;

import java.util.ArrayList;

public class StringDelimiter {
	public String[] delimitedString(String str, char start, char end) {
		ArrayList<String> strArray = new ArrayList<String>();
		if(str == null) {
			throw new NullPointerException();
		}
		int startPos = 0;
		int lastPos = 0;
		while(true) {
			startPos = str.indexOf(start, startPos);
			lastPos = str.indexOf(end, startPos + 1);
			if(startPos == -1 || lastPos == -1) {
				if(strArray.size() == 0) {
					strArray.add(null);
				}
				break;
			}
			strArray.add(str.substring(startPos, lastPos + 1));
			startPos = lastPos + 1;
		}
		return strArray.toArray(new String[strArray.size()]);
	}
	
	public static void main(String[] args) {
		StringDelimiter sd = new StringDelimiter();
		String[] sa;
		sa = sd.delimitedString("as>dfg<dfg>dfgda<dgf<g>", '<', '>');
		for(int i = 0; i < sa.length; i++) {
			System.out.println(sa[i]);
		}
	}
}
