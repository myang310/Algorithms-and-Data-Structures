package StackQueueBag;

import java.util.Iterator;
import StackQueueBag.Node;

public class LinkedListStack<Item> implements Iterable<Item> 
{
	private Node<Item> first;	// top of stack
	private int N;			// size of stack
	
	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		Node<Item> second = first;
		first = new Node<Item>(item);
		first.setNextNode(second);
		N++;
	}

	public Item pop() {
		Item data = first.getData();
		first = first.getNextNode();
		N--;
		return data;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		
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
		LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
		for (int i = 1; i <= 5; i++)
			stack.push(i);
		for (int number : stack)
			System.out.println(number);
	}
}
