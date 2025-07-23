package Trees;

public class SegmentTree {
//this segment tree is used to find the sum,maximum,minimum,product in a array within the given range with O(log n) time.
	public static void main(String[] args) {
		int[] arr= {6,4,-2,5,-11,9,7,-3};
		SegmentTree st=new SegmentTree(arr);
		st.display();
		System.out.println(st.query(2,6));
		st.update(4,-6);
		System.out.println(st.query(2,6));

	}
	private class Node{
		int data;
		int startInterval;
		int endInterval;
		Node left;
		Node right;
		
		public Node(int startInterval,int endInterval) {
			this.startInterval=startInterval;
			this.endInterval=endInterval;
		}
	}
	
	Node root;
	
	public SegmentTree(int[] arr) {
		this.root=constructTree(arr,0,arr.length-1);
	}

	private Node constructTree(int[] arr, int start, int end) {
		if(start==end) {
			Node leaf=new Node(start,end);
			leaf.data=arr[start];
			return leaf;
		}
		Node node=new Node(start,end);
		int mid = (start + end)/ 2;
		
		node.left=this.constructTree(arr, start, mid);
		node.right=this.constructTree(arr, mid+1, end);
		
		node.data=node.left.data+node.right.data;
		
		return node;
	}
	public void display() {
		display(root);
	}

	private void display(Node node) {
		if(node==null) {
			return;
		}
		String str="";
		if(node.left!=null) {
			str="Intervals = ["+node.left.startInterval+","+node.left.endInterval+"] & "+ "data: "+node.left.data+" => ";
		}else {
			str="No left child ";
		}
		System.out.print(str);
		if(node!=null) {
			str="Intervals = ["+node.startInterval+","+node.endInterval+"] & "+"data: "+ node.data;
		}
		System.out.print(str);
		if(node.right!=null) {
			str=" <= Intervals = ["+node.right.startInterval+","+node.right.endInterval+"] & "+ "data: "+ node.right.data;
		}else {
			str=" No right child";
		}
		System.out.print(str);
		System.out.println();
		display(node.left);
		display(node.right);
		
	}
	//query to find the sum of the numbers from the given range for example query(2,6)
	public int query(int qsi,int qei) {
		return query(this.root,qsi,qei);
	}

	private int query(Node node, int qsi, int qei) {
		if(qsi<=node.startInterval && qei>=node.endInterval) {
			//node is completely inside
			return node.data;
		}else if(qei<node.startInterval || qsi>node.endInterval) {
			//node is completely out of bound.
			return 0;
		}else {
			return this.query(node.left,qsi,qei)+this.query(node.right,qsi,qei);
		}
	}
	
	public void update(int index,int value) {
		this.root.data=update(this.root,index,value);
	}
	//If we want to update any value in the array that can also be done in O(log n) time.
	private int update(Node node, int index, int value) {
		if(index>=node.startInterval && index<=node.endInterval) {
			if(index==node.startInterval && index==node.endInterval) {
				node.data=value;
				return node.data;
			}else {
				//this will update each the every node when the node value is changed.
				int leftAns=update(node.left,index,value);
				int rightAns=update(node.right,index,value);

				node.data=leftAns+rightAns;
				return node.data;
			}
		}
		return node.data;
	}

}
