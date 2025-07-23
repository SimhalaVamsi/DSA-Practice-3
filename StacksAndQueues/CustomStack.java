package StacksAndQueues;

public class CustomStack {
	protected int[] data;
	private static final int DEFAULT_SIZE=10;
	int ptr=-1;    //here the ptr will get position to where it should insert or delete inside the array.
	public CustomStack() {
		this(DEFAULT_SIZE);
	}
	public CustomStack(int size) {
		this.data=new int[size];
	}
	
	public boolean push(int item) throws Exception{
		if(isFull()) {
			throw new Exception("Cannot push element because stack is full!");
		}
		ptr++;
		data[ptr]=item;
		return true;
	}
	public int pop() throws Exception{
		if(isEmpty()) {
			throw new Exception("Cannot pop element because stack is empty!");
		}
		
		return data[ptr--];
	}
	public int peek() throws Exception{
		if(isEmpty()) {
			throw new Exception("Cannot get peek element because stack is empty!");
		}
		return data[ptr];
	}
	public boolean isFull() {
		return ptr==data.length-1;
	}
	private boolean isEmpty() {
		return ptr==-1;
	}
}
