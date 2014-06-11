package ex21_6;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Concat {
	public static void main(String[] args) throws IOException {
		if(args.length == 0) {
			showStream(System.in);
		}else {
			InputStream fileIn, bufIn;
			List<InputStream> inputs = new ArrayList<InputStream>(args.length);
			for(String arg : args) {
				fileIn = new FileInputStream(arg);
				bufIn = new BufferedInputStream(fileIn);
				inputs.add(bufIn);
			}
			Enumeration<InputStream> files = Collections.enumeration(inputs);
			
			while(files.hasMoreElements()) {
				showStream(files.nextElement());
			}
		}
	}
	
	private static void showStream(InputStream in) {
		int ch;
		try {
			while((ch = in.read()) != -1) {
				System.out.write(ch);
			}
		} catch (IOException e) {
			// TODO é©ìÆê∂ê¨Ç≥ÇÍÇΩ catch ÉuÉçÉbÉN
			e.printStackTrace();
		}
	}
}
