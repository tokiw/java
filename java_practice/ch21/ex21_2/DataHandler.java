package ex21_2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.WeakHashMap;

public class DataHandler {
	private File lastFile;
	private WeakHashMap<String, byte[]> lastData = new WeakHashMap<>();
	
	byte[] readFile(File file) {
		byte[] data;
		String key = "key";
		
		if(file.equals(lastFile)) {
			if(lastData.containsKey(key)) {
				data = lastData.get(key);
				return data;
			}
		}
		
		data = readBytesFromFile(file);
		lastFile = file;
		lastData.put(key, data);
		return data;
	}

	private byte[] readBytesFromFile(File file) {
		byte[] b = null;
		FileInputStream input = null;
		ByteArrayOutputStream output = null;
		try {
			input = new FileInputStream(file);
			output = new ByteArrayOutputStream();
			while (input.read(b) > 0) {
				output.write(b);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		try {
			input.close();
			output.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return output.toByteArray();
	}
}
