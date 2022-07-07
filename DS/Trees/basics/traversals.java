import java.util.Stack;

// This class can be either created outside or inside BinaryTree tree class. If inside then it needs to be static.
class Node {

	int key;
	Node left, right;
	Node(int val) {
		key = val;
		left = right = null;
	}
}

class BinaryTree {

	Node root;

	// Constructor to make root as null
	BinaryTree() { root = null; }

	void printPreorderRecur(Node root) {
		if(root == null)
			return;
		// Root, L, R
		System.out.print(root.key + " ");
		printPreorderRecur(root.left);
		printPreorderRecur(root.right);
	}

	void printInorderRecur(Node root) {
		if(root == null)
			return;
		// L, Root, R
		printInorderRecur(root.left);
		System.out.print(root.key + " ");
		printInorderRecur(root.right);
	}

	void printPostorderRecur(Node root) {
		if(root == null)
			return;
		// L, R, Root
		printPostorderRecur(root.left);
		printPostorderRecur(root.right);
		System.out.print(root.key + " ");
	}

	// We have to use Stack for iterative traversals
	void printPreorderIter(Node r) {
		// If tree is empty
		if(r == null) 
			return;
		Stack<Node> s = new Stack<Node>();
		Node curr = r;
		// Here pushing curr node as we have to print root first everytime
		s.push(curr);
	
		while(!s.empty()) { // Stack empty can also be checked as: s.size() > 0
			curr = s.pop();
			System.out.print(curr.key + " ");
			// push the right child of the popped node into the stack
            if (curr.right != null) {
                s.push(curr.right);
            }
    
            // push the left child of the popped node into the stack
            if (curr.left != null) {
                s.push(curr.left);
            }
            // The right child must be pushed first so that the left child is processed first (LIFO order)
		}
	}

	// This can be done using 2 stacks and also 1 stack; for 1 stack solution see 1 stack solution program
	void printPostorderIter(Node r) {
		// If tree is empty
		if(r == null) 
			return;
		// Create an empty stack and push the root node
        Stack<Node> s = new Stack<Node>();
        s.push(root);
    
        // Create another stack to store postorder traversal
        Stack<Integer> out = new Stack<Integer>();
    
        // Loop till stack is empty
        while (!s.empty())
        {
            // Pop a node from the stack and push the data into the output stack
            Node curr = s.pop();
            out.push(curr.key);
    
            // Push the left and right child of the popped node into the stack
            if (curr.left != null) {
                s.push(curr.left);
            }
    
            if (curr.right != null) {
                s.push(curr.right);
            }
            // The left child must be pushed first so that the right child is processed first (LIFO order)
        }
    
        // Print postorder traversal
        while (!out.empty()) {
            System.out.print(out.pop() + " ");
        }
	}

	void printInorderIter(Node r) {
		// If tree is empty
		if(r == null) 
			return;
		Stack<Node> s = new Stack<Node>();
		Node curr = r;
	
		while(!s.empty() || curr != null) { // Stack empty can also be checked as: s.size() > 0
			// We first have to print root and left
			if(curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			// If current node is null, pop an element from the stack, print it, and finally set the current node to its right child
			else {
				curr = s.pop();
				System.out.print(curr.key + " ");
				curr =  curr.right;
			}
		}
	}


	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
 
        System.out.println("Preorder traversal of binary tree is ");
        bt.printPreorderIter(bt.root);
        // bt.printPreorderRecur(bt.root);
 
        System.out.println("\nInorder traversal of binary tree is ");
        bt.printInorderIter(bt.root);
        // bt.printInorderRecur(bt.root);
 
        System.out.println("\nPostorder traversal of binary tree is ");
        bt.printPostorderIter(bt.root);
        // bt.printPostorderRecur(bt.root);
	}
}