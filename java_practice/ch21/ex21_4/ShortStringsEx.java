package ex21_4;

import java.util.*;

public class ShortStringsEx implements ListIterator<String> {
	private ListIterator<String> strings;
	private String nextShort;
	private String previousShort;
	private final int maxLen;
	
	public ShortStringsEx(ListIterator<String> strings, int maxLen) {
		this.strings = strings;
		this.maxLen = maxLen;
		nextShort = null;
		previousShort = null;
	}
	
	@Override
	public boolean hasNext() {
		if(nextShort != null) {
			return true;
		}
		while(strings.hasNext()) {
			nextShort = strings.next();
			System.out.println();
			if(nextShort.length() <= maxLen) {
				return true;
			}
		}
		nextShort = null;
		return false;
	}

	@Override
	public String next() {
		if(nextShort == null && !hasNext()) {
			throw new NoSuchElementException();
		}
		String n = nextShort;
		nextShort = null;
		return n;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(String e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPrevious() {
		if(previousShort != null) {
			return true;
		}
		while(strings.hasPrevious()) {
			previousShort = strings.previous();
			if(previousShort.length() <= maxLen) {
				return true;
			}
		}
		previousShort = null;
		return false;
	}

	@Override
	public int nextIndex() {
		return hasNext() ? strings.nextIndex() - 1 : strings.nextIndex();
	}

	@Override
	public String previous() {
		if(previousShort == null && !hasPrevious()) {
			throw new NoSuchElementException();
		}
		String n = previousShort;
		previousShort = null;
		return n;
	}

	@Override
	public int previousIndex() {
		return hasPrevious() ? strings.previousIndex() + 1 : -1;
	}

	@Override
	public void set(String e) {
		throw new UnsupportedOperationException();
	}
}
