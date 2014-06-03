package ex11_1;

public class LinkedList<T> {
	T list;
	LinkedList<T> nextList;
	private static long listNum = 0;
	
	public LinkedList(T list) {
		this.list = list;
		listNum++;
	}
	
	public long getListNum() {
		return listNum;
	}

	public void setNextLink(T list) {
		this.nextList = new LinkedList<T>(list);
	}
	
	public LinkedList<T> getNext() {
		return nextList;
	}
	
	public void showList() {
		long maxList = getListNum();
		LinkedList<T> obj = this;
		for(long i = 0; i < maxList; i++) {
			System.out.println(obj.list);
			obj = obj.getNext();
		}
	}
	public static void main(String[] args) {
		LinkedList<String> strLink = new LinkedList<String>("abc");
		strLink.nextList = new LinkedList<String>("def");
		strLink.nextList.nextList = new LinkedList<String>("ghi");
		strLink.showList();
	}
}