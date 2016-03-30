package StackQueueBag;

import java.util.Iterator;
import StackQueueBag.Node;

// implementing a bag with a LIFO order
public class LinkedListBag<T> implements Iterable<T> 
{	
	private Node<T> first;	// top of stack
	private int N;			// size of stack
	
	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void add(T data) {
		Node<T> second = first;
		first = new Node<T>(data);
		first.setNextNode(second);
		N++;
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
		LinkedListBag<Integer> bag = new LinkedListBag<Integer>();
		for (int i = 1; i <= 5; i++)
			bag.add(i);
		for (int number : bag)
			System.out.println(number);
	}
}
