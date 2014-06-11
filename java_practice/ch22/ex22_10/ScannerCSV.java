package ex22_10;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class ScannerCSV {
	public static ArrayList<String> readCSV(Readable source) throws IOException {
		Scanner in = new Scanner(source);
		ArrayList<String> arr = new ArrayList<>();
		
		in.useDelimiter("\\s|#.*");
		while(in.hasNext()) {
			String str = in.next();
			if(!str.equals("")) {
				arr.add(str);
			}
		}
		in.close();
		return arr;
	}
	
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder();
		str.append("test1 test2 #comment1 #comment2%n");
		Reader reader = new CharArrayReader(str.toString().toCharArray());
		
		try {
			ArrayList<String> arr = readCSV(reader);
			for(String s : arr) {
				System.out.printf(s);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
