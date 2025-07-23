package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST {
	public class Node{
		private int value;
		private Node left;
		private Node right;
		private int height;

		public Node(int value) {
			this.value=value;
		}
		
		public int getValue() {
			return value;
		}
	}
	private Node root;
	
	public int getHeight(Node node) {
		if(node==null) {
			return -1;
		}
		return node.height;
	}
	public boolean isEmpty() {
		return root==null;
	}
	
	public void insert(int value) {
		root=insert(root,value);
	}
	public Node insert(Node node,int value) {
		if(node==null) {
			return new Node(value);
		}
		if(value<node.value) {
			node.left=insert(node.left,value);
		}
		if(value>node.value) {
			node.right=insert(node.right,value);
		}
		node.height=Math.max(getHeight(node.left), getHeight(node.right))+1;
		
		return node;
	}
	public void display() {
		display(root,"Root Node: ");
	}
	private void display(Node node, String details) {
		if(node==null) {
			return;
		}
		System.out.println(details+node.getValue());
		display(node.left,"Left Child of "+node.getValue()+" : ");
		display(node.right,"Right Child of "+node.getValue()+" : ");
	}
	public void populate(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			this.insert(nums[i]);
		}
	}
	public boolean balanced(){
		return balanced(root);
	}
	private boolean balanced(Node node) {
		if(node==null) {
			return true;
		}
		return Math.abs(getHeight(node.left)-getHeight(node.right))<=1 && balanced(node.left) && balanced(node.right);
	}
	public void populateSorted(int[] nums) {
		populateSorted(nums,0,nums.length-1);
	}
	private void populateSorted(int[] nums, int start, int end) {
		if(start>end) {
			return;
		}
		int mid=(start+end)/2;
		this.insert(nums[mid]);
		populateSorted(nums,start,mid-1);
		populateSorted(nums,mid+1,end);
	}
	public void preOrder() {
		preOrder(root);
		System.out.println();
	}
	public void preOrder(Node node) {
		if(node==null) {
			return;
		}
		System.out.print(node.value+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	public void inOrder() {
		inOrder(root);
		System.out.println();
	}
	public void inOrder(Node node) {
		if(node==null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.value+" ");
		inOrder(node.right);
	}
	public void postOrder() {
		postOrder(root);
		System.out.println();
	}
	public void postOrder(Node node) {
		if(node==null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value+" ");
	}
	public List<Integer> preorderTraversal() {
		List<Integer> list=new ArrayList<>();
		list=preorderTraversal(this.root);
		return list;
	}
	public List<Integer> preorderTraversal(Node root) {
        List<Integer> list=new ArrayList<>();
        Stack<Node> st=new Stack<>();
        if(root==null){
            return list;
        }
        st.push(root);
        while(!st.isEmpty()){
            root =st.pop();
            list.add(root.value);
            if(root.right!=null){
                st.push(root.right);
            }
            if(root.left!=null){
                st.push(root.left);
            }
        }
        return list;
    }
	
}
