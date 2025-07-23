package CircularLL;

public class CLL {
	private Node head;
	private Node tail;
	
	private int size;
	
	public CLL() {
		this.size=0;
	}
	
	public void insert(int value) {
		Node node =new Node(value);
		if(head==null) {
			head=node;
			tail=node;
			return;
		}
		node.next=head;
		tail.next=node;
		tail=node;
		size+=1;
	}
	public void insertAtPos(int pos,int value) {
		if(pos==size || pos==0) {
			insert(value);
			return;
		}
		Node temp=get(pos);
		Node node=new Node(value);
		node.next=temp.next;
		temp.next=node;
		size++;
		
	}
	public int deleteFirst() {
		int value=head.value;
		head=head.next;
		tail.next=head;
		if(head==null) {
			tail=null;
		}
		size--;
		return value;
	}
	public int deleteLast() {
		if(size<=1) {
			return deleteFirst();
		}
		Node secondLast= get(size);
		int val=tail.value;
		tail =secondLast;
		tail.next=head;
		size--;
		return val;
	}
	public int delete(int index) {
		if(index==0) {
			return deleteFirst();
		}
		if(index==size) {
			return deleteLast();
		}
		Node prev=get(index);
		int value=prev.next.value;
		prev.next=prev.next.next;
		size--;
		return value;
	}
	public Node find(int value) {
		Node node=head;
		while(node!=null) {
			if(node.value==value) {
				return node;
			}
			node=node.next;
		}
		return null;
	}
	public Node get(int index) {
		Node node =head;
		for(int i=1;i<index;i++) {
			node=node.next;
		}
		return node;
	}
	public void display() {
		Node temp=head;
		System.out.println("List size: "+size);
		while(temp!=tail) {
			System.out.print(temp.value+" ");
			temp =temp.next;
		}
		System.out.print(temp.value+" ");
		System.out.println();
	}
}
