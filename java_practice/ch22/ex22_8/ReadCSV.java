package ex22_8;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ReadCSV {
	
	public static List<String[]> readCSVTable(Readable source, final int cellNum) throws IOException {
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();
		String exp = "^";
		
		if (cellNum < 1) {
			in.close();
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < cellNum; i++) {
			exp += "(.*),";
		}
		exp = exp.substring(0, exp.length()-1);
		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				if (line.split(",").length != cellNum) {
					in.close();
					throw new IOException("input format error");
				}
				String[] cells = new String[cellNum];
				MatchResult match = in.match();
				for (int i = 0; i < cellNum; i++) {
					cells[i] = match.group(i+1);
				}
				vals.add(cells);
				in.nextLine();
			}else {
				if (!in.nextLine().matches("\\s*")) {
					in.close();
					throw new IOException("input format error");
				}
				
			}
		}
		in.close();

		return vals;
	}
	
	public static void main(String[] args) {
		try {
			FileReader file = new FileReader("./ch22/ex22_8/sample.txt");
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
