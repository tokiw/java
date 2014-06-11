package ex17_2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class DataHandler {
	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;
	
	byte[] readFile(File file) {
		byte[] data;
		
		if(file.equals(lastFile.get())) {
			data = lastData.get();
			if(data != null)
				return data;
		}
		
		data = readBytesFromFile(file);
		lastFile = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
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
		} finally {
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return output.toByteArray();
	}
}
