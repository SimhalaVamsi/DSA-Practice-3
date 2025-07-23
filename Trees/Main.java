package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		BinaryTree tree=new BinaryTree();
//		tree.populate(sc);
//		tree.display();
		
		BST t=new BST();
		int[] nums= {1,2,3,4,5,6,7,8,9,10};
		t.populateSorted(nums);
		List<Integer> list=new ArrayList<>();
		list=t.preorderTraversal();
		System.out.println(list);
		t.inOrder();
		
//		AVL tree=new AVL();
//		int[] nums= {1,2,3,4,5,6,7,8,9,10};
//		tree.populate(nums);
//		tree.display();
//		System.out.println(tree.balanced());
//		tree.populateSorted(nums);
//		System.out.println(tree.isBalanced());
//		tree.display();
//		System.out.println(tree.balanced());
//		
//		tree.preOrder();
//		tree.inOrder();
//		tree.postOrder();
//		
//		for(int i=0;i<1000;i++) {
//			tree.populate(nums);
//		}
//		System.out.println(tree.getHeight(tree.root));
	}

}
