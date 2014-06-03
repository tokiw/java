package ex20_3;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class EncryptOutputStream extends FilterOutputStream {
	private byte xor = 0x0F;
	
	public EncryptOutputStream(OutputStream output) {
		super(output);
	}
	
	public void write(int data) throws IOException {
		super.write(data ^ xor);
	}
}
