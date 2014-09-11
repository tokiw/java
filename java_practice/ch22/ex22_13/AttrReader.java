package ex22_13;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class AttrReader {
	
	public static Attributed readAttrs(Reader source) throws IOException {
		Scanner in = new Scanner(source);
		AttributedImpl attrs = new AttributedImpl();
		String exp = "^(.*)=(.*)$";
		String comment = "^#.*";
		Pattern patMap = Pattern.compile(exp, Pattern.MULTILINE);
		Pattern patComment = Pattern.compile(comment, Pattern.MULTILINE);
		
		while (in.hasNextLine()) {
			if (in.hasNext(patComment)) {
				in.nextLine();
			}else if (in.hasNext(patMap)) {				
				String line = in.findInLine(patMap);
				if (line != null) {
					MatchResult match = in.match();
					if (line.indexOf('=') == 0) {
						in.close();
						throw new IOException("misplaced '='");
					}else {
						attrs.add(new Attr(match.group(1), match.group(2)));					
						in.nextLine();
					}
				}else {
					in.nextLine();
				}
			}else {
				if (!in.nextLine().matches("\\s*")) {
					in.close();
					throw new IOException("input format error");
				}
			}
		}
		in.close();
		return attrs;
		
	}
	
	public static void main(String[] args) {
		try {
			FileReader file = new FileReader("./ch22/ex22_13/sample.txt");
			Attributed attrs = AttrReader.readAttrs(file);
			Iterator<Attr> iterator = attrs.attrs();
			Attr attr;
			while (iterator.hasNext()) {
				attr = iterator.next();
				System.out.println(attr.getName());
				System.out.println(attr.getValue());
			}
		} catch (IOException e) {
			// TODO é©ìÆê∂ê¨Ç≥ÇÍÇΩ catch ÉuÉçÉbÉN
			e.printStackTrace();
		}
	}
}
