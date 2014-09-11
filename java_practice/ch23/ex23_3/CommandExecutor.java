package ex23_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
	
	public static void main(String[] args) {
		if(args.length == 0) {
			System.err.println("No Argument!!");
			return;
		}
		String[] out;
		String killingWord = "IPv4";
		try {
			out = execCommand(args, killingWord);
			for(int i = 0; i < out.length; i++) {
				System.out.printf("%3d %s%n", i+1, out[i]);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}
	
	public static String[] execCommand(String[] cmd, String killingStr) throws IOException {
		try {
			Process proc = Runtime.getRuntime().exec(cmd);
			InputStream commandOut = proc.getInputStream();
			InputStreamReader r = new InputStreamReader(commandOut);
			BufferedReader in = new BufferedReader(r);
			
			List<String> lines = new ArrayList<String>();
			String line;
            while ((line = in.readLine()) != null) {
            	if(line.contains(killingStr)) {
            		proc.waitFor();
            		break;
            	}
                lines.add(line);
            }
            if (proc.waitFor() != 0) { // 失敗
                throw new IOException();
            }
            return lines.toArray(new String[lines.size()]);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new IOException();
		}
	}
}