package ex22_4;

import java.util.Observable;
import java.util.Observer;

public class AttributedObserver<T> implements Observer {
	AttributedImpl<T> watching;
	
	public AttributedObserver(AttributedImpl<T> attributed) { 
		watching = attributed;
		watching.addObserver(this);
	}
	
	@Override
	public void update(Observable attributed, Object changeAttr) {
		// TODO 自動生成されたメソッド・スタブ
		if (attributed != watching) {
			throw new IllegalArgumentException();
		}
		
		Attr<T> attr = (Attr<T>) changeAttr;
		if (watching.attrTable.containsKey(attr.getName())) {
			System.out.printf("add   : name=%s value=%s%n", attr.getName(), attr.getValue().toString());
		}else {
			System.out.printf("delete: name=%s value=%s%n", attr.getName(), attr.getValue().toString());
		}
	}

}
