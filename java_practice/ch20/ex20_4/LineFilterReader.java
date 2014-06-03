package ex20_4;

import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class LineFilterReader extends FilterReader {

	protected LineFilterReader(Reader in) {
		super(in);
		
	}

	private String readLine() throws IOException {
		StringBuilder str = new StringBuilder();
		int b;
		while((b = super.read()) != -1) {
			if((byte)b == '\n' || (byte)b == '\r') {
				return str.toString();
			}else {
				str.append((char)b);
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		LineFilterReader line = new LineFilterReader(new InputStreamReader(System.in));
		System.out.println(line.readLine());
	}
}
