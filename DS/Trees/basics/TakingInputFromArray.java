/* For recusive level order insertion we use array */

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

	Node root;

	// Here we have to use recursive if we are just using array as we have to come back as we need to fill sibling nodes first before child nodes
	public Node insertElem(int[] arr, Node root, int i) {
		/*
		If we observe, we can see that if parent node is at index i in the array,
		then the left child of that node is at index (2*i + 1) and
		right child is at index (2*i + 2) in the array.
		Now, we can easily insert the left and right nodes by choosing its parent node.
		We will insert the first element present in the array as the root node at level 0 in the tree 
		and start traversing the array and for every node i we will insert its both childs left and right in the tree.
		*/

		// Instead of looping we are using this as we are using recursion
		if(i<arr.length) {
			Node new_node = new Node(arr[i]);
			// First node is assigned to root
			root = new_node;
			// Now for child nodes
			root.left = insertElem(arr, root.left, 2*i+1);
			root.right = insertElem(arr, root.right, 2*i+2);

		}
		return root;

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

		// Take input from Array
		int arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6 };
		/*
		Input: arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6}
		Output: Root of the following tree
                   1
                  / \
                 2   3
                / \ / \
               4  5 6  6
              / \ /
             6  6 6		
        */


		// We are inserting elements in level order
        Node nt = bt.insertElem(arr, bt.root, 0);
        // Printing in pre-order
		bt.printPreOrder(nt);
	}
}