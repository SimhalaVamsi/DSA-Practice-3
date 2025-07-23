package Trees;

import java.util.*;

public class PrintInLevelOrder {
	
	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5,6,7,8,9,10};
		PrintInLevelOrder pilo=new PrintInLevelOrder();
		pilo.populateSorted(nums);
//		pilo.display();
		List<List<Integer>> list=new ArrayList<>();
		list=pilo.zigzagLevelOrder();
		System.out.println(list);
	}

	private class Node {
        private int value;
        private Node left;
        private Node right;
        private Node next;
        
        public Node(int value){
            this.value = value;
        }
        
        public int getValue() {
        	return value;
        }

    }

    private Node root;
    
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
		
		return node;
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
	//Leetcode problem-102
	public List<List<Integer>> levelOrder(Node root){
		List<List<Integer>> list=new ArrayList<>();
		if(root==null) {
			return list;
		}
		Queue<Node> queue=new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int levelsize=queue.size();
			List<Integer> currLevelList=new ArrayList<>();
			for(int i=0;i<levelsize;i++) {
				Node currNode=queue.poll();
				currLevelList.add(currNode.value);
				
				if(currNode.left!=null) {
					queue.offer(currNode.left);
				}
				if(currNode.right!=null) {
					queue.offer(currNode.right);
				}
			}
			list.add(currLevelList);
		}
		return list;
	}
	//Leetcode problem-637
	public List<Double> averageOfLevels(Node root) {
        List<Double> list=new ArrayList<>();
		if(root==null) {
			return list;
		}
		Queue<Node> queue=new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int levelsize=queue.size();
			double levelSum=0;
			for(int i=0;i<levelsize;i++) {
				Node currNode=queue.poll();
				levelSum=+currNode.value;
				if(currNode.left!=null) {
					queue.offer(currNode.left);
				}
				if(currNode.right!=null) {
					queue.offer(currNode.right);
				}
			}
			list.add(levelSum/levelsize);
		}
		return list;
    }
	public int findSuccessor(Node root,int num) {
		//find the next successor element on the same level on given number. if it is the last element on the level then return the first element on next level. 
		Queue<Node> queue=new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node currNode=queue.poll();
			if(currNode.left!=null) {
				queue.offer(currNode.left);
			}
			if(currNode.right!=null) {
				queue.offer(currNode.right);
			}
			if(currNode.value==num) {
				Node ansNode=queue.peek();
				return ansNode.value;
			}
		}	
		return 0;
	}
	//leetcode problem 103
	public List<List<Integer>> zigzagLevelOrder() {
		return zigzagLevelOrder(this.root);
	}
	public List<List<Integer>> zigzagLevelOrder(Node root) {
		List<List<Integer>> list=new ArrayList<>();
		if(root==null) {
			return list;
		}
		Deque<Node> dq=new ArrayDeque<>();
		dq.add(root);
		boolean rev=false;
		while(!dq.isEmpty()) {
			int levelsize=dq.size();
			List<Integer> currLevelList=new ArrayList<>();
			for(int i=0;i<levelsize;i++) {
				if(!rev) {
					Node currNode=dq.removeFirst();
					currLevelList.add(currNode.value);
					
					if(currNode.left!=null) {
						dq.addLast(currNode.left);
					}
					if(currNode.right!=null) {
						dq.addLast(currNode.right);
					}
				}else {
					Node currNode=dq.removeLast();
					currLevelList.add(currNode.value);
					if(currNode.right!=null) {
						dq.addFirst(currNode.right);
					}
					if(currNode.left!=null) {
						dq.addFirst(currNode.left);
					}
				}
			}
			rev=rev==false?true:false;
			list.add(currLevelList);
		}
		return list;
    }
	public Node connect(Node root) {
		if(root==null) {
			return null;
		}
		Node leftMost=root;
		while(leftMost!=null) {
			Node curr=leftMost;
			while(curr!=null) {
				curr.left.next=curr.right;
				if(curr.next!=null) {
					curr.right.next=curr.next.left;
				}
				curr=curr.next;
			}
			leftMost=leftMost.left;
		}
        return root;
    }
}
