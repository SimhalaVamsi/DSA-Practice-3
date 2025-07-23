package StacksAndQueues;

public class CircularQueue {
	protected int[] data;
	private static final int DEFAULT_SIZE=10;
	
	static int front=0, end=0, size=0;
	
	public CircularQueue() {
		this(DEFAULT_SIZE);
	}

	public CircularQueue(int size) {
		this.data=new int[size];
	}
	
	public boolean insert(int item) throws Exception {
		if(isFull()) {
			throw new Exception("Queue is full! Enable to insert.");
		}
		data[end++]=item;
		end = end % data.length;
		size++;
		return true;
	}
		
	public int remove() throws Exception{
		if(isEmpty()) {
			throw new Exception("Queue is empty! Enable to pop");
		}
		int removed=data[front++];
		front = front % data.length;
		size--;
		return removed;
	}
	
	public int front() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is empty! there is no front");
		}

		return data[front];
	}
	
	public void display() {
		int i=front;
		do {
			System.out.print(data[i]+" -> ");
			i++;
			i%=data.length;
		}while(i!=end);
		System.out.println("END");
	}
	
	public boolean isEmpty() {
		return size==0;
	}

	public boolean isFull() {
		return size==data.length;
	}
}
