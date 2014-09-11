package ex22_10;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CommentSplit {
	public static List<String> split(Readable source) throws IOException {
		Scanner in = new Scanner(source);
		
		List<String> vals = new ArrayList<>();
		
		in.useDelimiter(in.delimiter().toString() + "|#.*");
		while (in.hasNext()) {
			String line = in.next();
			if (!line.equals("")) {
				vals.add(line);
			}
		}
		in.close();
		
		return vals;
	}
	
	
	public static void main(String[] args) {
		try {
			FileReader file = new FileReader("./ch22/ex22_10/sample.txt");

			List<String> list = split(file);
			Iterator<String> i = list.iterator();
			while (i.hasNext()) { 
				System.out.println((String)i.next());
			}
		} catch (IOException e) {
			// TODO é©ìÆê∂ê¨Ç≥ÇÍÇΩ catch ÉuÉçÉbÉN
			e.printStackTrace();
		}
	}
}
