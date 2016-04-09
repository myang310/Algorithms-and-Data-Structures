package StackQueueBag;

import java util.Iterator;
import StackQueueBag.Node;

public class Steque<T> implements Iterable<T>
{
	private Node<T> top;
	private Node<T> bottom;
	private int N;
	
	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return N;
	}
	
	public void push(T data) {
		if (top == null) {
			top = new Node(data);
			bottom = top;
		} else {
			newNode = new Node(data);
			newNode.setNextNode(top);
			top = newNode;
		}
		N++;
	}

	public T pop() {
		T data = top.getData();
		nextNode = top.getNextNode();
		if (nextNode != null) {
			top = top.getNextNode();
		} else {
			top = null;
			bottom = null;
		}
		N--;
		return data;
	}

	public void enqueue(T data) {
		if (top == null) {
			top = new Node(data);
			bottom = top;
		} else {
			newNode = new Node(data);
			bottom.setNextNode(newNode);
			bottom = bottom.getNextNode();
		}
		N++;
	}

	public Iterator<T> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<T> {
		private Node current = top;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {  }

		public T next() {
			T data = (T) current.getData();
			current = current.getNextNode();
			return data;
		}
	}
}
