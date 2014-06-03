package ex04_3;

public class LinkedListImp implements LinkedList {
	private Object list;
	private LinkedList nextList;
	
	public LinkedListImp(Object list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		String str = this.list.toString();
		
		return str;
	}
	
	@Override
	public Object getList() {
		return list;
	}
	
	@Override
	public LinkedList getNext() {
		return nextList;
	}
	
	@Override
	public void setList(Object list) {
		this.list = list;
	}
	
	@Override
	public void setNextList(LinkedList nextList) {
		this.nextList = nextList;
	}
	
	@Override
	public int maxList() {
		int max = 1;
		if (this.nextList != null) {
			max += this.nextList.maxList();
		}
		return max;
	}
}
