package StacksAndQueues;

public class DynamicStack extends CustomStack{
	public DynamicStack() {
		super();  //it will the CustomStack constructor of default size.
	}
	
	public DynamicStack(int size) {
		super(size);
	}
	@Override
	public boolean push(int item) throws Exception {
		if(this.isFull()) {
			//double the size of array.
			int[] temp=new int[data.length*2];
			
			//copy all elements from data to temp.
			for(int i=0;i<data.length;i++) {
				temp[i]=data[i];
			}
			data=temp;
		}
		//at this point our stack is not full.
		//so call the CustomStack class push to add items;
		return super.push(item);
	}
}
