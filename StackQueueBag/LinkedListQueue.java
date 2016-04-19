package StackQueueBag;

import java.util.Iterator;
import StackQueueBag.Node;

public class LinkedListQueue<T> implements Iterable<T> 
{
	private Node<T> head;	// front of queue
	private Node<T> tail;	// end of queue
	private int N;					// size of stack
	
	public LinkedListQueue() { }

	public LinkedListQueue(Node<T> node) {
		head = node;
		tail = node;
		N = 1;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return N;
	}

	public void enqueue(T data) 
	{	// add data to the end of the queue
		Node<T> newData = new Node<T>(data);
		if (this.isEmpty())
			head = newData;
		else
			tail.setNextNode(newData);
		tail = newData;
		N++;
	}

	public T dequeue() 
	{	// remove data from the front of the queue
		T data = head.getData();
		head = head.getNextNode();
		if (this.isEmpty())
			tail = null;	
		N--;
		return data;
	}

	public void reverseList() {
		recursiveReverse(first);
	}
	        
	private void recursiveReverse(Node<T> current) {
		if (current == null || current.getNextNode() == null) {
			head = current;
			return;
		}

		recursiveReverse(current.getNextNode());
		current.getNextNode().setNextNode(current);
		current.setNextNode(null);
		tail = current;
	}

	public Iterator<T> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<T> {
		private Node current = head;
		
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
		LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
		for (int i = 1; i <= 5; i++)
			queue.enqueue(i);
		for (int number : queue)
			System.out.println(number);
	}
}
