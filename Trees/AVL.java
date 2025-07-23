package Trees;

public class AVL {
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
	public Node root;
	
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
		
		return rotate(node);
	}
	public Node rotate(Node node) {
		if(getHeight(node.left)-getHeight(node.right)>1) {
			//left heavy
			if(getHeight(node.left.left)-getHeight(node.left.right)>0) {
				//left-left case
				return rightRotate(node);
			}
			if(getHeight(node.left.left)-getHeight(node.left.right)<0) {
				//left-right case
				node.left=leftRotate(node.left);
				return rightRotate(node);
			}
		}
		if(getHeight(node.left)-getHeight(node.right)<-1) {
			//right heavy
			if(getHeight(node.right.left)-getHeight(node.right.right)<0) {
				//right-right case
				return leftRotate(node);
			}
			if(getHeight(node.right.left)-getHeight(node.right.right)>0) {
				//right-left case
				node.right=rightRotate(node.right);
				return leftRotate(node);
			}
		}
		return node;
	}
	private Node leftRotate(Node p) {
		Node c=p.right;
		Node t=c.left;
		
		c.left=p;
		p.right=t;
		
		p.height=Math.max(getHeight(p.left), getHeight(p.right)+1);
		c.height=Math.max(getHeight(c.left), getHeight(c.right)+1);
		
		return c;
	}
	private Node rightRotate(Node p) {
		Node c=p.left;
		Node t=c.right;
		
		c.right=p;
		p.left=t;
		
		p.height=Math.max(getHeight(p.left), getHeight(p.right)+1);
		c.height=Math.max(getHeight(c.left), getHeight(c.right)+1);
		
		return c;
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
		for(int num:nums) {
			this.insert(num);
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
	public boolean isBalanced() {
		return isBalanced(this.root);
	}
	//This approach uses O(N^2) time complexity bcz we are computing height for every node and checking wheather it is balanced or not. 
    public boolean isBalanced(Node root) {
        if(root==null){
            return true;
        }
        int leftHeight= getHeight(root.left,0);
        int rightHeight=getHeight(root.right,0);
        int height=Math.abs(leftHeight-rightHeight);
        if(height>1){
            return false;
        }
        boolean left=isBalanced(root.left);
        boolean right=isBalanced(root.right);
        if(!left|| !right){
            return false;
        }
        return true;
    }
    public int getHeight(Node node,int height){
        if(node==null){
            return 0;
        }
        return Math.max(getHeight(node.left,height+1),getHeight(node.right,height+1))+1;
    }

    //this approach uses only O(N) time complexity bcz here we are returning -1 if it is not balanced even one part of the tree which reduces to compute other.
    public boolean isBalancedOrNot(Node root) {
        return getHeight(root)!=-1;
    }
    public int getHeight1(Node node){
        if(node==null){
            return 0;
        }
        int leftHeight = getHeight1(node.left);
        if(leftHeight==-1) return -1; //
        int rightHeight = getHeight1(node.right);
        if(rightHeight==-1) return -1;
    //If part of tree is not balanced then rest of the tree is also not balanced so we are returning -1 directly to root which says the whole the was to balanced. 
        if(Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
    
    //Maximum depth of binary tree Leetcode problem-104
    public int maxDepth(Node root) {
        int cnt=1;
        if(root==null){
            return 0;
        }
        return maxDepth(root,cnt);
    }
    public int  maxDepth(Node node,int cnt){
        if(node==null){
            return cnt;
        }
        if(node.left!=null || node.right!=null){
            cnt++;
        }
        return Math.max(maxDepth(node.left,cnt),maxDepth(node.right,cnt));
    }
}
