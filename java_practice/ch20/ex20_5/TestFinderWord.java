package ex20_5;

import java.io.FileWriter;
import java.io.IOException;

public class TestFinderWord {
	public static void main(String[] args) {
		String filePath = "sample.txt";
		try {
			FileWriter fr = new FileWriter(filePath);
			fr.write("aa\nss\ndd\nff\ngg\nhh\njj\nkk\nll");
			fr.close();
			
			FinderWord.findWord(filePath, "dd");
			
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
