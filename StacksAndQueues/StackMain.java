package StacksAndQueues;

public class StackMain extends CustomStack{

	public static void main(String[] args) throws Exception {
		CustomStack stack =new CustomStack(10);
		
		stack.push(3);
		stack.push(11);
		stack.push(56);
		stack.push(1);
		stack.push(89);

		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println(stack.peek());
	}

}
