package StackQueueBag;

import java.util.Iterator;
import StackQueueBag.Node;

public class LinkedListStack<T> implements Iterable<T> 
{
	private Node<T> first;	// top of stack
	private int N;			// size of stack
	
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
		for (int i = 1; i <= 5; i++)
			stack.push(i);
		for (int number : stack)
			System.out.println(number);
	}
}
