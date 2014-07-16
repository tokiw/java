package ex16_5;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;

public class ClassContents {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			printMembers(c.getFields(), c.getDeclaredFields());
			printMembers(c.getConstructors(), c.getDeclaredConstructors());
			printMembers(c.getMethods(), c.getDeclaredMethods());
			printAnnotations(c.getAnnotations());
		}catch(ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}
	
	private static void printMembers(Member[] mems, Member[] decs) {
		for(Member m : mems) {
			boolean flagShow = false;
			for(Member d: decs) {
				if(m.toString().equals(d.toString())) {
					continue;
				}
				if(!flagShow) {
					String decl = m.toString();
					System.out.print(" ");
					System.out.println(strip(decl, "java.lang."));
					flagShow = true;
				}
				
			}
			flagShow = false;
		}
	}
	
	private static void printAnnotations(Annotation[] annotations) {
		for(Annotation a : annotations) {
			System.out.println(" " + a);
		}
	}
		
	private static String strip(String str, String removedStr) {
		boolean flagReplace = true;
		while(flagReplace) {
			if(str != str.replaceFirst(removedStr, "")) {
				str = str.replaceFirst(removedStr, "");
				
			}else {
				flagReplace = false;
			}
		}
		return str;
	}
}
