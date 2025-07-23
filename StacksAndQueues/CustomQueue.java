package StacksAndQueues;

public class CustomQueue {
	protected int[] data;
	private static final int DEFAULT_SIZE=10;
	
	static int end=0;
	
	public CustomQueue() {
		this(DEFAULT_SIZE);
	}

	public CustomQueue(int size) {
		this.data=new int[size];
	}
	
	public boolean insert(int item) throws Exception {
		if(isFull()) {
			throw new Exception("Queue is full! Enable to insert.");
		}
		data[end++]=item;
		return true;
	}
	public int remove() throws Exception{
		if(isEmpty()) {
			throw new Exception("Queue is empty! Enable to pop");
		}
		int removed=data[0];
		//shift all the elements of one position ahead.
		for(int i=1;i<end;i++) {
			data[i-1]=data[i];
		}
		end--;
		return removed;
	}
	public int front() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is empty! there is no front");
		}

		return data[0];
	}
	public void display() {
		for(int i=0;i<end;i++) {
			System.out.print(data[i]+" -> ");
		}
		System.out.println("END");
	}

	public boolean isEmpty() {
		return end==0;
	}

	public boolean isFull() {
		return end==data.length;
	}
}
