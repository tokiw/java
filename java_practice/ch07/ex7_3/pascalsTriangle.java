package ex7_3;

public class pascalsTriangle {
	private static final int DEPTH = 12;
	private int[][] triangle;
	
	public pascalsTriangle() {
		createTriangle(DEPTH);
	}
	
	public void createTriangle(int depth) {
		triangle = new int[depth][];
		for(int i=0; i<triangle.length; i++ ) {
			triangle[i] = new int[i+1];
			for(int j=0; j<triangle[i].length; j++) {
				if(i == 0 || i == j || j == 0) {
					triangle[i][j] = 1;
				}else{
					triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
				}
			}
		}
	}
	
	public String toString() {
		String disp = "";
		for(int i=0; i<triangle.length; i++) {
			disp += "{ ";
			for(int j=0; j<triangle[i].length; j++) {
				disp += triangle[i][j] ;
				if(j == triangle[i].length-1) {
					disp += " },\n";
				}else {
					disp += ", ";
				}
			}
		}
		return disp;
	}
	
	public static void main(String[] args) {
		pascalsTriangle pTriangle = new pascalsTriangle();
		System.out.println(pTriangle);
	}
}

/*
1
1, 1
1, 2, 1
1, 3, 3, 1
1, 4, 6, 4, 1
1, 5,10,10, 5, 1
1, 6,15,20,15, 6, 1
...
*/