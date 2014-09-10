package ex22_11;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadCSV {
	
	public static List<String[]> readCSVTable(Reader source, final int cellNum) throws IOException {
		StreamTokenizer in = new StreamTokenizer(source);
		
		List<String[]> vals = new ArrayList<String[]>();
		in.eolIsSignificant(true);
		in.ordinaryChars('0', '9');
		in.wordChars('0', '9');
		in.whitespaceChars(',', ',');
		in.ordinaryChar(' ');
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			if (in.ttype == StreamTokenizer.TT_EOL) {
				continue;
			}
			String[] cells = new String[cellNum];
			for (int i = 0; i < cellNum; i++) {
				if (in.ttype == StreamTokenizer.TT_WORD) {
					cells[i] = in.sval;
				}
				in.nextToken();
			}
			if (in.ttype != StreamTokenizer.TT_EOL) {
				throw new IOException("input format error");
			}
			vals.add(cells);
			in.pushBack();
		}
		
		return vals;
	}
	
	public static void main(String[] args) {
		try {
			FileReader file = new FileReader("./ch22/ex22_11/sample.txt");
			List<String[]> list = ReadCSV.readCSVTable(file, 3);
			Iterator<String[]> i = list.iterator();
			while (i.hasNext()) { 
				String[] strings = (String[])i.next();
				for (int j = 0; j < strings.length; j++) {
					System.out.println(strings[j]);
				}
			}
		} catch (IOException e) {
			// TODO Ž©“®¶¬‚³‚ê‚½ catch ƒuƒƒbƒN
			e.printStackTrace();
		}
	}
}
