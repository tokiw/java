package java_practice;

public class practice1_8 {
	public static void main(String[] args) {
		Point num1 = new Point();
		Point num2 = new Point();
		
		num1.x = 2.0;
		num1.y = 2.0;
		
		num2.x = 1.0;
		num2.y = 1.0;
		
		num1.move(num2);
	
		System.out.println(num2.x);
		System.out.println(num2.y);
	}
	
}

class Point {
	public double x, y;
	
	public void move(Point that) {
		that.x = x;
		that.y = y;
	}
}
