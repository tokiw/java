package ex20_11;

import java.io.File;
import java.io.FilenameFilter;

public class SuffixFilter implements FilenameFilter {
	private String suffix;

	public SuffixFilter(String suffix) {
		this.suffix = suffix;
	}
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(suffix);
	}
	
	public static void main(String[] args) {
		File dir = new File("test");
		String[] files = dir.list(new SuffixFilter("suffix.txt"));
		System.out.println(files.length);
		for(String file : files) {
			System.out.println(file);
		}
	}
}
