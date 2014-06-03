package java_practice;

public class sample1_8 {
	public static void main(String[] args) {
		Points length = new Points();
		Points height = new Points();
		
		height.x = 2.0;
		height.y = 2.0;
		
		length.x = 1.0;
		length.y = 1.0;
		
		double aaa = height.distance(length);
	
		System.out.println(aaa);
	}
	
}

class Points {
	public double x, y;
	
	public double distance(Points that) {
		double xdiff = x - that.x;
		double ydiff = y - that.y;
		return Math.sqrt(xdiff * xdiff + ydiff * ydiff );
	}
}
