package ex21_2;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class DataHandlerTest {

	@Before
	public void setup() {
		File file = new File("test.txt");
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write("abcdefg");
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testReadFile() {
		DataHandler dh = new DataHandler();
		byte[] data;
		data = dh.readFile(new File("test.txt"));
		assertEquals(data, "abcdefg");
		
		Runtime.getRuntime().gc();
		//参照がなくなった確認したい
	}

}
