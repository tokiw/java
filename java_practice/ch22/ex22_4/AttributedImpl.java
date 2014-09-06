package ex22_4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

public class AttributedImpl<T> extends Observable implements Attributed<T>, Iterable<Attr<T>> {
	protected Map<String, Attr<T>> attrTable = new HashMap<String, Attr<T>>();
	
	@Override
	public Iterator<Attr<T>> iterator() {
		// TODO 自動生成されたメソッド・スタブ
		return attrs();
	}

	@Override
	public void add(Attr<T> newAttr) {
		// TODO 自動生成されたメソッド・スタブ
		attrTable.put(newAttr.getName(), newAttr);
		setChanged();
		notifyObservers(newAttr);
	}

	@Override
	public Attr<T> find(String attrName) {
		// TODO 自動生成されたメソッド・スタブ
		return attrTable.get(attrName);
	}

	@Override
	public Attr<T> remove(String attrName) {
		// TODO 自動生成されたメソッド・スタブ
		Attr<T> result = attrTable.remove(attrName);
		if (result != null) {
			setChanged();
			notifyObservers(result);
		}
		return result;
	}

	@Override
	public Iterator<Attr<T>> attrs() {
		// TODO 自動生成されたメソッド・スタブ
		return attrTable.values().iterator();
	}
}
