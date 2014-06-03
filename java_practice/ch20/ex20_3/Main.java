package ex20_3;

import java.io.IOException;



public class Main {
	public static void main(String[] args) throws IOException {
		EncryptOutputStream es = new EncryptOutputStream(System.out);
		DecryptInputStream  ds = new DecryptInputStream(System.in);
		int b;
		
		while((b = ds.read()) != -1) {
			System.out.print(b);
			System.out.print(" ");
			es.write(b);
			System.out.println();
		}
	}
}
