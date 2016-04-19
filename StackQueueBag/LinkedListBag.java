package StackQueueBag;

import java.util.Iterator;
import StackQueueBag.Node;

// implementing a bag with a LIFO order
public class LinkedListBag<T> implements Iterable<T> 
{	
	private Node<T> head;	// top of stack
	private int N;			// size of stack

	public LinkedListBag() { }

	public LinkedListBag(Node<T> node) {
		this.head = node;
		N = 1;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return N;
	}

	public void add(T data) {
		Node<T> second = head;
		head = new Node<T>(data);
		head.setNextNode(second);
		N++;
	}

	public void reverseList() {
		recursiveReverse(head);
	}
	        
	private void recursiveReverse(Node<T> current) {
		if (current == null || current.getNextNode() == null) {
			head = current;
			return;
		}

		recursiveReverse(current.getNextNode());
		current.getNextNode().setNextNode(current);
		current.setNextNode(null);
	}
	
	// removes all instances of the key in the linked list
	public void remove(T key) {
		// base case: go until you hit the last node
		if (head == null) {
			return;
		}
		
		// a holder variable to hold the place of the head node
		// and incrementing head to the next node to allow for
		// a recursive call to remove(key);
		Node origin = head;
		head = head.getNextNode();
		remove(key);

		// resetting head to the pre-incremented node and begin processing
		head = origin;
		Node nextNode = head.getNextNode();

		// change the current's next node to the 2nd node after if the next node's
		// data is equal to the key
		if (nextNode != null) {
			if (nextNode.getData() == key || nextNode.getData().equals(key)) {
				head.setNextNode(nextNode.getNextNode());
			}
		}
		
		// if the current node's data is the key, then change the head of the
		// linked list to the next node so that the function doesn't end with
		// the head of the linked list pointing to a node with the key as its data
		if (head.getData() == key) {
			head = nextNode;
		}
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
		LinkedListBag<Integer> bag = new LinkedListBag<Integer>();
		for (int i = 1; i <= 5; i++)
			bag.add(i);
		for (int number : bag)
			System.out.println(number);
	}
}
