package DoublelyLL;

public class Node {
	int value;
	Node prev;
	Node next;
	
	public Node(int value) {
		this.value=value;
	}
	public Node(int value,Node next, Node prev) {
		this.value=value;
		this.next=next;
		this.prev=prev;
	}
}
