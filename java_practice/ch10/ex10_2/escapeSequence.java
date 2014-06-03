package ex10_2;

public class escapeSequence {
	public String eacapeChar(String str) {
		switch(str) {
			case "\n":
				str = "\\n";
				break;
			case "\t":
				str = "\\t";
				break;
			case "\b":
				str = "\\b";
				break;
			case "\r":
				str = "\\r";
				break;
			case "\f":
				str = "\\f";
				break;
			case "\\":
				str = "\\\\";
				break;
			case "\'":
				str = "\\'";
				break;
			case "\"":
				str = "\\\"";
				break;
			default:
				throw new IllegalStateException();
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
		//System.out.println(es.eacapeChar("a"));
	}
}
