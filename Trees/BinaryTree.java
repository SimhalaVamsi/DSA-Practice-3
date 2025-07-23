package Trees;
import java.util.*;

public class BinaryTree {
    private static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int value){
            this.data = value;
        }
    }

    private static Node root;

    public static void populate(Scanner scanner) {
        System.out.println("Enter the root node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(root, scanner);
    }

    private static void populate(Node node, Scanner scanner) {
        System.out.println("Do you want to enter left of " + node.data + "? (true/false)");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the left value of " + node.data);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(node.left, scanner);
        }

        System.out.println("Do you want to enter right of " + node.data + "? (true/false)");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the right value of " + node.data);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(node.right, scanner);
        }
    }

    public static void display() {
        display(root, "");
    }

    private static void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.data);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }
}
