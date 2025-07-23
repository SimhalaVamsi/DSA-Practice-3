package StacksAndQueues;

public class QueueMain {

	public static void main(String[] args) throws Exception {
		CircularQueue cq =new CircularQueue();
		cq.insert(34);
		cq.insert(12);
		cq.insert(90);
		cq.insert(3);
		cq.insert(67);
		cq.insert(7);
		cq.insert(14);
		cq.insert(6);
		cq.insert(99);
		cq.insert(32);
		System.out.println(cq.size);
		//cq.insert(20);
		
		
		cq.display();
		
		System.out.println("removed element is: " +cq.remove());
		System.out.println(cq.size);
		
		cq.insert(20);
		System.out.println(cq.size);
		
		cq.display();

	}

}
