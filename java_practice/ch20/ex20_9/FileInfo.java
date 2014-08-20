package ex20_9;

import java.io.File;
import java.util.Date;

public class FileInfo {
	public static void printFileInfo(String path) {
		String[] paths = new String[1];
		paths[0] = path;
		printFileInfo(paths);
	}
	
	public static void printFileInfo(String[] paths) {
		for(String path : paths) {
			File f = new File(path);
			System.out.println(f.getAbsolutePath());
			
			if(f.exists()) {
				System.out.println("FileName     : " + f.getName());
				System.out.println("LastModified : " + new Date(f.lastModified()));
				System.out.println("FileSize     : " + f.length());
				System.out.println("Readable     : " + f.canRead());
				System.out.println("Writable     : " + f.canWrite());
				System.out.println("Executable   : " + f.canExecute());
			}else {
				System.out.println("Not Found File");
			}
		}
	}
	
	public static void main(String[] args) {
		FileInfo.printFileInfo("sample.txt");
	}
}
