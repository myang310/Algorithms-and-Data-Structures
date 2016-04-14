package StackQueueBag;

import java.util.Iterator;
import StackQueueBag.DoublyNode;

public class Deque<T> implements Iterable<T> 
{
	private DoublyNode<T> leftEnd;
	private DoublyNode<T> rightEnd;
	private int N;

	public boolean isEmpty() {
		return leftEnd == null;
	}

	public int size() {
		return N;
	}

	public void pushLeft(T data) {
		if (leftEnd == null) {
			leftEnd = new DoublyNode(data);
			rightEnd = leftEnd;
		} else {
			newNode = new DoublyNode(data);
			newNode.setNextNode(leftEnd);

			nextNode = newNode.getNextNode();
			nextNode.setPreviousNode(newNode);
			leftEnd = newNode;
		}
		N++;
	}

	public void pushRight(T data) {
		if (rightEnd == null) {
			rightEnd = new DoublyNode(data);
			leftEnd = rightEnd;
		} else {
			newNode = new DoublyNode(data);
			newNode.setPreviousNode(leftEnd);

			previousNode = newNode.getPreviousNode();
			previousNode.setNextNode(newNode);
			rightEnd = newNode;
		}
		N++;
	}

	public T popLeft(T data) {

	}

	public T popRight(T data) {

	}
	
	public Iterator<T> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<T> {
		private DoublyNode current = left;

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

