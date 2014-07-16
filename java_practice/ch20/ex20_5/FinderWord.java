package ex20_5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FinderWord {
	public static void findWord(String filePath, String word) throws FileNotFoundException { 
		String line;
		try {
			FileReader fr = new FileReader(filePath);
			LineNumberReader lr = new LineNumberReader(fr);
			
			while((line = lr.readLine()) != null) {
				if(line.indexOf(word) != -1) {
					System.out.println(lr.getLineNumber() + " " + line);
				}
			}
			lr.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
