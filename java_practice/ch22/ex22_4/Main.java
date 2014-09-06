package ex22_4;

public class Main {
	public static void main(String[] args) {
		AttributedImpl<Integer> attributed = new AttributedImpl<>();
		attributed.add(new Attr<Integer>("a", 1));
		attributed.remove("a");
		
		AttributedObserver<Integer> obsever = new AttributedObserver<>(attributed);
		
		attributed.add(new Attr<Integer>("b", 2));
		attributed.remove("b");
		
		attributed.add(new Attr<Integer>("c", 3));
		attributed.remove("d");
	}
}
