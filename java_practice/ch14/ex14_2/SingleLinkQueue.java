package ex14_2;

public class SingleLinkQueue<E> {
	private Cell<E> head;
	private Cell<E> tail;
	
	static class Cell<E> {
		private Cell<E> next;
		private E element;
		public Cell(E element) {
			this.element = element;
		}
		
		public Cell(E element, Cell<E> next) {
			this(element);
			this.next = next;
		}
		public E getElement() {
			return element;
		}
		public void setElement(E element) {
			this.element = element;
		}
		public Cell<E> getNext() {
			return next;
		}
		public void setNext(Cell<E> next) {
			this.next = next;
		}
	}
	
	public void add(E item) {
		Cell<E> cell = new Cell<E>(item);
		if(tail == null)
			head = tail = cell;
		else {
			tail.setNext(cell);
			tail = cell;
		}
	}
	
	public E remove() {
		if(head == null)
			return null;
		Cell<E> cell = head;
		head = head.getNext();
		if(head == null)
			tail = null;
		return cell.getElement();
	}
	
	public int size() {
		int size = 0;
		for(Cell<E> cell = head; cell != null; cell = cell.next)
			size++;
		return size;
	}
}