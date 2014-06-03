package ex12_1;


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
	
	public LinkedList<T> find(T searchList) throws ObjectNotFoundException {
		long maxList = getListNum();
		LinkedList<T> obj = this;
		for(long i = 0; i < maxList; i++) {
			if(obj.list == searchList) {
				return obj;
			}
		}
		throw new ObjectNotFoundException(searchList);
	}
	
	public static void main(String[] args) throws ObjectNotFoundException {
		LinkedList<String> strLink = new LinkedList<String>("abc");
		strLink.nextList = new LinkedList<String>("def");
		strLink.nextList.nextList = new LinkedList<String>("ghi");
		
		LinkedList<String> l = strLink.find("ab");
		System.out.println(l.list);
	}
}