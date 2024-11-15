import org.junit.*;
import java.util.EmptyStackException;
import static org.junit.Assert.*;

public class StackTest {
	// Test that pop returns the correct element after a push
	@Test
	public void testPopAfterPush() {
		Stack stack = new Stack();
		stack.push("napis");
		String result = stack.pop();
		assertEquals("pop after push", "napis", result);
	}

	// Test that pop throws an exception when called on an empty stack
	@Test(expected = EmptyStackException.class)
	public void testPopOnEmptyStack() {
		Stack stack = new Stack();
		stack.pop();
	}

	// Test that peek returns the correct element after a push without removing it
	@Test
	public void testPeekAfterPush() {
		Stack stack = new Stack();
		stack.push("napis");
		String result = stack.peek();
		assertEquals("peek after push", "napis", result);
	}

	// Test that peek throws an exception when called on an empty stack
	@Test(expected = EmptyStackException.class)
	public void testPeekOnEmptyStack() {
		Stack stack = new Stack();
		stack.peek();
	}

	// Test that multiple push and pop operations work correctly
	@Test
	public void testPushAndPopMultipleElements() {
		Stack stack = new Stack();
		stack.push("first");
		stack.push("second");
		stack.push("third");
		assertEquals("third", stack.pop());
		assertEquals("second", stack.pop());
		assertEquals("first", stack.pop());
	}

	// Test that the stack resizes correctly when the initial capacity is exceeded
	@Test
	public void testResize() {
		Stack stack = new Stack();
		for (int i = 0; i < 20; i++) {
			stack.push("element" + i);
		}
		assertEquals("element19", stack.pop());
		assertEquals("element18", stack.pop());
	}
}
