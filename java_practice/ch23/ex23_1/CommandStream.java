package ex23_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/*
 * 無限ループが止まらない...
 * 
 */
public class CommandStream {
	
	public CommandStream(final InputStream input, final OutputStream output) {
		Runnable stream = new Runnable() {
			public void run() {
				try {
		            int b;
		            while ((b = input.read()) != -1) {
		                output.write(b);
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
				} finally {
				}
			}
		};
		new Thread(stream).start();
	}
	
	public static Process userProg(String cmd) throws IOException {
        Process proc = Runtime.getRuntime().exec(cmd);
        plugTogether(System.in, proc.getOutputStream());
        plugTogether(System.out, proc.getInputStream());
        plugTogether(System.err, proc.getErrorStream());
        return proc;
    }
	
	public static void plugTogether(InputStream input, OutputStream output) {
		new CommandStream(input, output);
	}
	
	public static void plugTogether(OutputStream output, InputStream input) {
		plugTogether(input, output);
	}
	
	
	
	public static void main(String[] args) {
		try {
			Process p = CommandStream.userProg("ipconfig");
			p.waitFor();
			p.destroy();
		} catch (IOException | InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
