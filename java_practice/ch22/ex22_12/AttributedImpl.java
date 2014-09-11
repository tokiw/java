package ex22_12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AttributedImpl implements Attributed, Iterable<Attr> {
	protected Map<String, Attr> attrTable = new HashMap<String, Attr>();
	
	@Override
	public Iterator<Attr> iterator() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return attrs();
	}

	@Override
	public void add(Attr newAttr) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		attrTable.put(newAttr.getName(), newAttr);
	}

	@Override
	public Attr find(String attrName) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return attrTable.get(attrName);
	}

	@Override
	public Attr remove(String attrName) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return attrTable.remove(attrName);
	}

	@Override
	public Iterator<Attr> attrs() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return attrTable.values().iterator();
	}
}
