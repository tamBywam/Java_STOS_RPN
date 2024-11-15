import java.util.EmptyStackException;

public class Stack {
	private String[] elements;
	private int size;

	public Stack() {
		// Initialize the stack with an initial capacity of 10
		elements = new String[10];
		size = 0;
	}

	public void push(String element) {
		// Resize the array if it is full
		if (size == elements.length) {
			resize();
		}
		// Add the new element to the stack
		elements[size++] = element;
	}

	public String pop() {
		// Throw an exception if the stack is empty
		if (size == 0) {
			throw new EmptyStackException();
		}
		// Remove and return the top element of the stack
		String element = elements[--size];
		elements[size] = null; // Avoid memory leak
		return element;
	}

	public String peek() {
		// Throw an exception if the stack is empty
		if (size == 0) {
			throw new EmptyStackException();
		}
		// Return the top element of the stack without removing it
		return elements[size - 1];
	}

	private void resize() {
		// Double the size of the array when it is full
		String[] newElements = new String[elements.length * 2];
		System.arraycopy(elements, 0, newElements, 0, elements.length);
		elements = newElements;
	}
}
