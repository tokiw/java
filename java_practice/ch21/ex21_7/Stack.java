package ex21_7;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
	private ArrayList<T> list = new ArrayList<>();
	
	public boolean empty() {
		return list.isEmpty();
	}
	
	public void push(T item) {
		list.add(item);
	}
	
	public T pop() {
		if(empty()) {
			throw new EmptyStackException();
		}
		return list.remove(list.size() - 1);
	}
	
	public T peek() {
		if(empty()) {
			throw new EmptyStackException();
		}
		return list.get(list.size() - 1);
	}
	
	int search(Object o) {
		int index = list.indexOf(o);
		return index == -1 ? -1 : list.size() - index;
	}
}
