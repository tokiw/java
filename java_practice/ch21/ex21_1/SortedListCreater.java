package ex21_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SortedListCreater {
	public static void main(String[] args) {
		String str;
		Boolean addFlag = false;
		ArrayList<String> array = new ArrayList<String>();
		File file = new File("C:\\Users\\tokiwa\\git\\java\\java_practice\\ch21\\ex21_1\\strings.txt");
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			str = br.readLine();
			array.add(str);
			while((str = br.readLine()) != null) {
				int arraySize = array.size();
				for(int i = 0; i < arraySize; i++) {
					if(array.get(i).compareTo(str) > 0) {
						array.add(i, str);
						addFlag = true;
						i = arraySize;
					}
				}
				if(!addFlag) {
					array.add(str);
				}
				addFlag = false;
			}
			System.out.println("");
			for(String str1 : array) {
				System.out.println(str1);
			}
			br.close();
		} catch (IOException e) {
			// TODO é©ìÆê∂ê¨Ç≥ÇÍÇΩ catch ÉuÉçÉbÉN
			e.printStackTrace();
		}
	}
}
