package ex10_1;

public class escapeSequence {
	public String eacapeChar(String str) {
		if(str == "\n") {
			str = "\\n";
		}else if(str == "\t") {
			str = "\\t";
		}else if(str == "\b") {
			str = "\\b";
		}else if(str == "\r") {
			str = "\\r";
		}else if(str == "\f") {
			str = "\\f";
		}else if(str == "\\") {
			str = "\\\\";
		}else if(str == "\'") {
			str = "\\'";
		}else if(str == "\"") {
			str = "\\\"";
		}
		return str;
	}
	
	public static void main(String[] args) {
		escapeSequence es = new escapeSequence();
		System.out.println(es.eacapeChar("\n"));
		System.out.println(es.eacapeChar("\t"));
		System.out.println(es.eacapeChar("\b"));
		System.out.println(es.eacapeChar("\r"));
		System.out.println(es.eacapeChar("\f"));
		System.out.println(es.eacapeChar("\\"));
		System.out.println(es.eacapeChar("\'"));
		System.out.println(es.eacapeChar("\""));
	}
}
