package ex21_4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class ShortStringsExTest {
	private ArrayList<String> list;
	private ListIterator<String> it;
	private ShortStringsEx ss; 
	
	@Before
	public void setUp() {
		list = new ArrayList<String>();
		list.add("aaaa5");
		list.add("bbbbb6");
		list.add("ccccccc8");
		list.add("d2");
		list.add("eee4");
		list.add("ffffffff9");
		list.add("gggggg7");
		list.add("hh3");
		it = list.listIterator();
		ss = new ShortStringsEx(it, 4);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testAdd() {
		ss.add("zzz");
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testSet() {
		ss.set("zzz");
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testRemove() {
		ss.remove();
	}

	@Test
	public void testNext() {
		String str = ss.next();
		assertEquals(str, "d2");
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testNextToLast() {
		ss.next();
		ss.next();
		ss.next();
		ss.next();
	}
	
	@Test
	public void testPrevious() {
		String str1 = ss.next();
		String str2 = ss.previous();
		assertEquals(str1, str2);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testNextToFirst() {
		ss.previous();
	}
	
	public void testExistNext() {
		assertTrue(ss.hasNext());
	}
	
	@Test
	public void testNotExistNext() {
		try{
			ss.next();
			ss.next();
			ss.next();
			ss.next();
		}catch(NoSuchElementException e) {
			assertFalse(ss.hasNext());
		}
	}
	
	public void testExistPrevious() {
		ss.next();
		assertTrue(ss.hasPrevious());
	}
	
	@Test
	public void testNotExistPrevious() {
		assertFalse(ss.hasPrevious());
	}
	
	@Test
	public void testNextIndex() {
		int index = ss.nextIndex();
		assertEquals(index, 3);
		try{
			ss.next();
			ss.next();
			ss.next();
			ss.next();
		}catch(NoSuchElementException e) {
			index = ss.nextIndex();
			assertEquals(index, 8);
		}
	}
	
	@Test
	public void testpreviousIndex() {
		int index = ss.previousIndex();
		assertEquals(index, -1);
		ss.next();
		index = ss.previousIndex();
		assertEquals(index, 3);
	}
}
