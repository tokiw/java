package ex22_3;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Set;

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
		Set<Byte> keys = used.keySet();
		for(Byte b : keys) {
			BitSet bs = used.get(keys);
			for(int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i + 1)) {
				
			}
		}
		return desc + "]";
	}
	
	public static void main(String[] args) {
		WhichChars wc = new WhichChars("Testing 1 2 3");
		System.out.println(wc.toString());
	}
}
