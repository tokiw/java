package ex20_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByteEx {
	
	public static void translate(InputStream input, OutputStream output, byte from, byte to) throws IOException {
		int b;
		while((b = input.read()) != -1)
			output.write(b == from ? to : b);
	}
	
	public static void main(String args[]) throws IOException {
		byte from = (byte) args[0].charAt(0);
		byte to   = (byte) args[1].charAt(0);
		InputStream in = System.in;
		OutputStream out = System.out;
		translate(in, out, from, to);
	}
}
