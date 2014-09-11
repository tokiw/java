package ex20_10;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
	public static Map<String, Integer> countWord(String path) throws IOException {
		HashMap<String, Integer> map = new HashMap<>();
		FileReader fr = new FileReader(path);
		StreamTokenizer in = new StreamTokenizer(fr);
		String key;
		
		while(in.nextToken() != StreamTokenizer.TT_EOF) {
			if(in.ttype == StreamTokenizer.TT_WORD) {
				key = in.sval;
				if(map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
				}else {
					map.put(key, 1);
				}
			}
		}
		for(String k : map.keySet()) {
			System.out.printf("%s: %d回%n", k, map.get(k));
		}
		return map;
	}
	
	public static void main(String[] args) {
		try {
			WordCounter.countWord("sample.txt");
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
