package ex10_4;

/** do-while‚Í[‚³0‚Ì‚Æ‚«‚Å‚«‚È‚¢‚Ì‚Å‘‚«’¼‚¹‚È‚¢ */

public class pascalsTriangle {
	private static final int DEPTH = 12;
	private int[][] triangle;
	
	public pascalsTriangle() {
		createTriangle(DEPTH);
	}
	
	public void createTriangle(int depth) {
		triangle = new int[depth][];
		int i = 0;
		while(i<triangle.length) {
			int j = 0;
			triangle[i] = new int[i+1];
			while(j<triangle[i].length) {
				if(i == 0 || i == j || j == 0) {
					triangle[i][j] = 1;
				}else{
					triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
				}
				j++;
			}
			i++;
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
