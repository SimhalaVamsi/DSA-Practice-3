package DoublelyLL;

public class DLL {
	private Node head;
	
	int size;
	public DLL() {
		this.size=0;
	}
	
	public void insertFirst(int value) {
		Node node=new Node(value);
		node.next=head;
		node.prev=null;
		
		if(head!=null) {
			head.prev=node;
		}
		head=node;
		size++;
	}
	public void insertLast(int value) {
		Node node=new Node(value);
		Node temp=get(size);
		temp.next=node;
		node.next=null;
		node.prev=temp;
		size++;
	}

	public void insertAtpos(int pos,int value) {
		Node prevNode=get(pos);
		if(pos==0) {
			insertFirst(value);
			return;
		}
		if(pos==size) {
			insertLast(value);
			return;
		}
		Node node=new Node(value);
		prevNode.next.prev=node;
		node.prev=prevNode;
		node.next=prevNode.next;
		prevNode.next=node;
	}
	public Node get(int index) {
		Node node=head;
		for(int i=1;i<index;i++) {
			node =node.next;
		}
		return node;
	}
	public void display() {
		Node node=head;
		Node last=null;
		System.out.println(size);
		while(node!=null) {
			System.out.print(node.value+"->");
			last=node;
			node=node.next;
		}
		System.out.print("END");
		System.out.println();
		while(last!=null) {
			System.out.print(last.value+"->");
			last=last.prev;
		}
		System.out.print("START");
		
	}
}
