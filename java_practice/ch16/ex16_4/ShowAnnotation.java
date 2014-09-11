package ex16_4;

import java.lang.annotation.Annotation;

public class ShowAnnotation {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			Annotation[] annotations = c.getAnnotations();
			for(Annotation a : annotations) {
				System.out.println(a);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
