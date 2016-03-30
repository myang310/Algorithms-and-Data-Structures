package StackQueueBag;

public class Node<Item> {
	private Item data;
	private Node nextNode;

	public Node(Item data) {
		this.data = data;
	}

	public Item getData() {
		return data;
	}

	public Node<Item> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<Item> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return "Data: " + this.data;
	}
}

