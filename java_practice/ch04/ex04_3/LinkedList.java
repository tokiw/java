package ex04_3;

public interface LinkedList {
	public abstract Object getList();
	public abstract Object getNext();
	public abstract void setList(Object list);
	public abstract void setNextList(LinkedList nextList);
	public abstract int maxList();
	public abstract String toString();
	
}
