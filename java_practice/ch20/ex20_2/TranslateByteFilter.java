package ex20_2;

import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

public class TranslateByteFilter extends FilterReader {

	
	protected TranslateByteFilter(Reader in) {
		super(in);
		
	}

	public int read() throws IOException{
		int c = super.read();
		return c;
	}
	
	public static void main(String args[]) throws IOException, CloneNotSupportedException {
		byte from = (byte) args[0].charAt(0);
		byte to   = (byte) args[1].charAt(0);
		int b;
		
		TranslateByteFilter tf = new TranslateByteFilter(new InputStreamReader(System.in));
		OutputStream out = System.out;
		
		while((b = tf.read()) != -1)
			out.write(b == from ? to : b);
	}
}
