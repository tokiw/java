package ex10_5;

public class CompletionChar {
	public void showBetweenChar(Character c1, Character c2) {
		Character first = c1;
		Character last = c2;
		
		if(c1.compareTo(c2) > 0) {
			first = c2;
			last = c1;
		}else if(c1 == c2) {
			System.out.printf("%c", c1);
			return;
		}
		
		System.out.printf("%c", first);
		first++;
		while(first != last) {
			System.out.printf("%c", first);
			first++;
		}
		System.out.printf("%c", last);
	}
	
	public static void main(String[] args) {
		(new CompletionChar()).showBetweenChar('z', 'z');
	}
}
