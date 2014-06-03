package ex12_1;

public class ObjectNotFoundException extends Exception {
	public ObjectNotFoundException(Object obj) {
		super("Not Found: " + obj.toString());
	}
}
