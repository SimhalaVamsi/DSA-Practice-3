package StacksAndQueues;

public class DynamicQueue extends CustomQueue{
	public DynamicQueue() {
		super();
	}
	
	public DynamicQueue(int size) {
		super(size);
	}
	@Override
	public boolean insert(int item) throws Exception {
		if(isFull()) {
			throw new Exception("Queue is full! Enable to insert.");
		}
		
		int[] temp=new int[data.length*2];
		
		for(int i=0;i<data.length;i++) {
			temp[i]=data[i];
		}
		data=temp;
		
		data[end++]=item;
		return true;
	}
}
