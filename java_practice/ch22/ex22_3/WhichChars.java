package ex22_3;

import java.util.BitSet;
import java.util.HashMap;

public class WhichChars {
	private HashMap<Byte, BitSet> used = new HashMap<>();
	
	public WhichChars(String str) {
		for(int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			BitSet bs = null;
			Byte b = (byte) (c >> 8);
			if(!used.containsKey(c)) {
				bs = new BitSet();
				used.put(b, bs);
			}
			bs.set(c & 0x00FF);
		}
	}
	
	public String toString() {
		String desc = "[";
		for(Character c : used) {
			desc += c;
		}
		return desc + "]";
	}
	
	public static void main(String[] args) {
		WhichChars wc = new WhichChars("Testing 1 2 3");
		System.out.println(wc.toString());
	}
}
