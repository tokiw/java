package ex21_7;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStack {

	@Test
	public void test() {
		Stack<String> stack = new Stack<>();
		assertTrue(stack.empty());
		stack.push("aaa");
		assertEquals(stack.peek(), "aaa");
		assertFalse(stack.empty());
		
		assertEquals(stack.pop(), "aaa");
		assertTrue(stack.empty());
		
		stack.push("sss");
		stack.push("www");
		stack.push("eee");
		stack.push("rrr");
		assertEquals(stack.search("eee"), 2);
	}

}
