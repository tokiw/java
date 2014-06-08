package ex21_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SortedListCreater {
	
	private void createSortedArray(ArrayList<String> array, BufferedReader br) {
		String str;
		Boolean addFlag = false;
		
		try {
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
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} 
	}
	
	private boolean isSorted(ArrayList<String> array) {
		ArrayList<String> sortedArray = new ArrayList<>(array);
		Collections.sort(sortedArray);
		for(String str : sortedArray) {
			System.out.println(str);
		}
		return sortedArray.equals(array);
	}
	
	private void readFile() {
		File file = new File("C:\\Users\\tokiwa\\git\\java\\java_practice\\ch21\\ex21_1\\strings.txt");
		FileReader fileReader;
		try {
			fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			ArrayList<String> array = new ArrayList<>();
			createSortedArray(array, br);
			System.out.println(isSorted(array));
			br.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SortedListCreater list = new SortedListCreater();
		list.readFile();
	}
}
