/* For insertion using iterative method, Queues can be used */

import java.util.Queue;
import java.util.LinkedList;

// This class can be either created outside or inside BinaryTree tree class. If inside then it needs to be static.
class Node {
	int data;
	Node left, right;
	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class BinaryTree {

	static Node root;


	public void insertElem(Node n, int val) {
		// Base condition
		if(n == null) {
			root = new Node(val);
			return;
		}
		Node curr = n;
		// Declare a queue
		Queue<Node> q = new LinkedList<Node>();
		q.add(curr);
		while(!q.isEmpty()) {
			curr = q.peek();
			q.remove();
			
			// Means current node left child is null so we can insert
			if(curr.left == null) {
				curr.left = new Node(val);
				break;
			}
			else {
				q.add(curr.left);
			}

			// Similarly check for right child
			if(curr.right == null) {
				curr.right = new Node(val);
				break;
			}
			else {
				q.add(curr.right);
			}
		}
	}


	public void printPreOrder(Node curr) {
		if(curr != null) {
			System.out.println(curr.data + " ");
			printPreOrder(curr.left);
			printPreOrder(curr.right);
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();

		// Let's assume a basic tree is given
		root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print("Preorder traversal before insertion: ");
        bt.printPreOrder(root);
        // To be inserted
        int val = 12;
        bt.insertElem(root, val);
        System.out.print("Preorder traversal after insertion: ");
        bt.printPreOrder(root);
 
	}
}