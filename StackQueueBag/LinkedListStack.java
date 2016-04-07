package StackQueueBag;

import java.util.Iterator;
import StackQueueBag.Node;

public class LinkedListStack<T> implements Iterable<T> 
{
	private Node<T> first;	// top of stack
	private int N;			// size of stack

	public LinkedListStack() { }

	public LinkedListStack(Node<T> node) {
		this.first = node;
		N = 1;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void push(T data) {
		Node<T> second = first;
		first = new Node<T>(data);
		first.setNextNode(second);
		N++;
	}

	public T pop() {
		T data = first.getData();
		first = first.getNextNode();
		N--;
		return data;
	}

	public void reverseList() {
		recursiveReverse(first);
	}

	public void remove(T key) {
		// base case: go until you hit the last node
		if (first == null) {
			return;
		}
		
		// a holder variable to hold the place of the first node
		// and incrementing first to the next node to allow for
		// a recursive call to remove(key);
		Node origin = first;
		first = first.getNextNode();
		remove(key);

		// resetting first to the pre-incremented node and begin processing
		first = origin;
		Node nextNode = first.getNextNode();

		// change the current's next node to the 2nd node after if the next node's
		// data is equal to the key
		if (nextNode != null) {
			if (nextNode.getData() == key || nextNode.getData().equals(key)) {
				first.setNextNode(nextNode.getNextNode());
			}
		}
		if (first.getData() == key) {
			first = first.getNextNode();
		}
	}
 
	private void recursiveReverse(Node<T> current) {
		if (current == null)
			return;
		if (current.getNextNode() == null) {
			first = current;
			return;
		}

		recursiveReverse(current.getNextNode());
		current.getNextNode().setNextNode(current);
		current.setNextNode(null);
	}

	public Iterator<T> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<T> {
		private Node current = first;
		
		public boolean hasNext() {
			return current != null;			
		}

		public void remove() {	}

		public T next() {
			T data = (T) current.getData();
			current = current.getNextNode();
			return data;
		}
	}

	public static void main(String[] args) {
		LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
		System.out.println("This is the order of the stack when popped:");
		for (int i = 1; i <= 5; i++)
			stack.push(i);
		for (int number : stack)
			System.out.println(number);

		stack.reverseList();
		System.out.println("\nThis is the order of the reversed stack when popped:");
		for (int number : stack)
			System.out.println(number);

		System.out.println("\nAdding a few 3s:");
		stack.push(3);
		stack.push(3);
		for (int number : stack)
			System.out.println(number);

		System.out.println("\nRemoving all 3s:");
		stack.remove(3);
		for (int number : stack)
			System.out.println(number);
	}
}
