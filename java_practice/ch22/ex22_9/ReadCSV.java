package ex22_9;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ReadCSV {
	static final int CELLS = 3;
	
	public static List<String[]> readCSVTable(Readable source, String str) throws IOException {
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();
		String exp = str;
		
		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				String[] cells = new String[CELLS];
				MatchResult match = in.match();
				for (int i = 0; i < CELLS; i++) {
					cells[i] = match.group(i+1);
				}
				vals.add(cells);
				in.nextLine();
			}else {
				in.close();
				throw new IOException("input format error");
			}
		}
		in.close();
		
		IOException ex = in.ioException();
		if (ex != null) {
			throw ex;
		}
		
		return vals;
	}
	
	public static void measureTime(Readable file, String str) {
		Long start, stop;
		
		
		try {
			start = System.nanoTime();
			ReadCSV.readCSVTable(file, str);
			stop = System.nanoTime();
			
			System.out.printf("Time: %3dns, Pattern: %s%n", stop-start, str);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			FileReader file = new FileReader("./ch22/ex22_9/sampleShort.txt");
			
			System.out.println("SHORT STRINGS");
			System.out.printf("初回呼び出し(無効): ");
			ReadCSV.measureTime(file, "^(.*),(.*),(.*)");
			ReadCSV.measureTime(file, "^(.*),(.*),(.*)");
			ReadCSV.measureTime(file, "(.*),(.*),(.*)$");
			ReadCSV.measureTime(file, "^(.+?),(.+?),(.+?)");
			ReadCSV.measureTime(file, "^(.+),(.+),(.+)");
			
			file = new FileReader("./ch22/ex22_9/sampleLong.txt");
			
			System.out.println("SHORT STRINGS");
			System.out.printf("初回呼び出し(無効): ");
			ReadCSV.measureTime(file, "^(.*),(.*),(.*)");
			ReadCSV.measureTime(file, "^(.*),(.*),(.*)$");
			ReadCSV.measureTime(file, "^(.+?),(.+?),(.+?)");
			ReadCSV.measureTime(file, "^(.+),(.+),(.+)");
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
