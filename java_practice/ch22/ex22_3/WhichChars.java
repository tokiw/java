package ex22_3;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Set;

public class WhichChars {
	private HashMap<Byte, BitSet> used = new HashMap<>();
	
	public WhichChars(String str) {
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			Byte b = (byte) (c >>> 8);
			BitSet bs = used.get(b);
			if(bs == null) {
				bs = new BitSet(c & 0xFF);
				used.put(b, bs);
			}
			bs.set(c & 0x00FF);
		}
	}
	
	public String toString() {
		String desc = "[";
		Set<Byte> keyset = used.keySet();
		for(Byte key : keyset) {
			BitSet bs = used.get(key);
			for(int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i+1)) {
				desc += (char) ((key << 8) + i);
			}
		}
		return desc + "]";
	}
	
	public static void main(String[] args) {
		WhichChars wc = new WhichChars("H›");
		System.out.println(wc.toString());
		
	}
}
