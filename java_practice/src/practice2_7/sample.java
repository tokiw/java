package practice2_7;

class Body {
	public long idNum;
	public String name;
	public Body orbits;
	
	private static long nextID = 0;
	
	/*�R���X�g���N�^*/
	Body() {
				idNum = nextID++;
	}
	Body(String bodyName, Body orbitAround) {
		this();
		name = bodyName;
		orbits = orbitAround;
	}
	Body(String bodyName) {
		this(bodyName, null);
	}
}

public class sample {
	public static void main(String[] args) {
			Body sun = new Body("Sol");
			System.out.println("ID: " + sun.idNum + "���O: " + sun.name);
			Body earth = new Body("Earth", sun);
			System.out.println("ID: " + earth.idNum + "���O: " + earth.name);
	}

}