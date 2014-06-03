package ex20_3;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream {
	private byte xor = 0x0F;
	
	public DecryptInputStream(InputStream input) {
		super(input);
	}
	
	public int read() throws IOException {
		int c = super.read();
		return (c == -1) ? c : c ^ xor;
	}
}
