package ex22_12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AttributedImpl implements Attributed, Iterable<Attr> {
	protected Map<String, Attr> attrTable = new HashMap<String, Attr>();
	
	@Override
	public Iterator<Attr> iterator() {
		// TODO 自動生成されたメソッド・スタブ
		return attrs();
	}

	@Override
	public void add(Attr newAttr) {
		// TODO 自動生成されたメソッド・スタブ
		attrTable.put(newAttr.getName(), newAttr);
	}

	@Override
	public Attr find(String attrName) {
		// TODO 自動生成されたメソッド・スタブ
		return attrTable.get(attrName);
	}

	@Override
	public Attr remove(String attrName) {
		// TODO 自動生成されたメソッド・スタブ
		return attrTable.remove(attrName);
	}

	@Override
	public Iterator<Attr> attrs() {
		// TODO 自動生成されたメソッド・スタブ
		return attrTable.values().iterator();
	}
}
