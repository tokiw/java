package ch16;

import static java.lang.System.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class SimleClassDesc {
	public static void main(String[] args) {
		Class type = null;
		try {
			type = Class.forName(args[0]);
		}catch(ClassNotFoundException e) {
			err.println(e);
			return;
		}
		out.print("class " + type.getSimpleName());
		Class superclass = type.getSuperclass();
		if(superclass != null)
			out.println(" extends " + superclass.getCanonicalName());
		else
			out.println();
		Method[] methods = type.getDeclaredMethods();
		for(Method m : methods)
			if(Modifier.isPublic(m.getModifiers()))
				out.println(" " + m);
	}
}
