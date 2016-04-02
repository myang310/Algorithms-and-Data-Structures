package StackQueueBag;

public class Node<T> {
	private T data;
	private Node nextNode;

	public Node(T data) {
		this.data = data;
	}

	public Node(T data, Node nextNode) {
		this.data = data;
		this.nextNode = nextNode;
	}

	public T getData() {
		return data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return "Data: " + this.data;
	}
}

