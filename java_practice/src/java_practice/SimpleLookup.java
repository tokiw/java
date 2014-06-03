package java_practice;

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
	
	public Object find(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(name))
				return values[i];
		}
		return null;
	}
	
	public void add(String name, Object value) {
		tableId++;
		names[tableId] = name;
		values[tableId] = value;
	}
	
	public void remove(String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(name)) {
				names[i] = null;
				values[i] = null;
			}
		}
	}
	
	public static void main(String[] args) {
		SimpleLookup tables = new SimpleLookup();
		tables.add("aaa", 2);
		System.out.println(tables.names[1] + " : " + tables.values[1]);
		tables.remove("aaa");
		System.out.println(tables.names[1] + " : " + tables.values[1]);
	}
}