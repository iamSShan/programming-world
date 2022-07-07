import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
	int data;
	TreeNode left, right;
	TreeNode(int d)  {
		data = d;
		left = null;
		right = null;
	}
}

class BinaryTree {

	TreeNode root;

	TreeNode insertElem(int[] arr, TreeNode root, int i) {
		if(i<arr.length) {
			TreeNode new_node = new TreeNode(arr[i]);
			root = new_node;
			root.left = insertElem(arr, root.left, 2*i+1);
			root.right = insertElem(arr, root.right, 2*i+2);
		}
		return root;
	}

	public void printLevelWiseNodes(TreeNode node) {
		// We have to use BFS using queue only
		if(node == null)
			return;

		Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        // Here we are adding delimiter between levels
        q.add(null);

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            // As soon as we see null we push a null at bottom the queue and print a new line
            // We are adding null here because node of the given level will already be added

            // When not null simply print
            if(curr != null) {
            	System.out.print(curr.data + " "); 
            
	            if(curr.left != null)
	                q.add(curr.left);
	            if(curr.right != null)
	                q.add(curr.right);
	        }
	        else {
	        	if(!q.isEmpty()) { // Condition check so we are not adding null when no elemets are left
	        		System.out.println();
	        		q.add(null);
	        	}
	        }
            
        }
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		/*

		           1
                  / \
                 2   3
                / \ / \
               4  5 6  7
              / \ /
             8  9 10		
        */
        bt.root = bt.insertElem(arr, bt.root, 0);
        // Print nodes at each level
        bt.printLevelWiseNodes(bt.root);
	}
}