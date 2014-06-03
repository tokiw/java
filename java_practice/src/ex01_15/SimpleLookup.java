package ex01_15;

/* インターフェイス */
interface Lookup {
	/** nameと関連付けられた値を返す。 
	 *  そのような値がなければnullを返す */
	Object find(String name);
}

interface LookupEx extends Lookup {
	void add(String name, Object value);
	void remove(String name);
}


/* クラス */
public class SimpleLookup implements LookupEx{
	private String[] names;
	private Object[] values;
	static int tableId = 0;
	
	public static void main(String[] args) {
		SimpleLookup tables = new SimpleLookup();
		tables.names = new String[5];
		tables.values = new Object[5];
		
		tables.add("aaa", 2);
		System.out.println(tables.names[0] + " : " + tables.values[0]);
		tables.remove("aaa");
		System.out.println(tables.names[0] + " : " + tables.values[0]);
		
	}
	
	public Object find(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(name))
				return values[i];
		}
		return null;
	}
	
	public void add(String name, Object value) {
		names[tableId] = name;
		values[tableId] = value;
		tableId++;
	}
	
	public void remove(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i] == name) {
				names[i] = null;
				values[i] = null;
			}
		}
	}
}