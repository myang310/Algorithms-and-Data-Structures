package StackQueueBag;

import java.util.Iterator;
import StackQueueBag.Node;

public class LinkedListQueue<Item> implements Iterable<Item> 
{
	private Node<Item> head;	// front of queue
	private Node<Item> tail;	// end of queue
	private int N;					// size of stack
	
	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return N;
	}

	public void enqueue(Item item) 
	{	// add item to the end of the queue
		Node<Item> newItem = new Node<Item>(item);
		if (isEmpty())
			head = newItem;
		else
			tail.setNextNode(newItem);
		tail = newItem;
		N++;
	}

	public Item dequeue() 
	{	// remove item from the front of the queue
		Item data = head.getData();
		head = head.getNextNode();
		if (isEmpty())
			tail = null;	
		N--;
		return data;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = head;
		
		public boolean hasNext() {
			return current != null;			
		}

		public void remove() {	}

		public Item next() {
			Item data = (Item) current.getData();
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
