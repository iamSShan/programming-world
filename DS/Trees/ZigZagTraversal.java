import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

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

	// Using bfs i.e. level order traversal
	public List<List<Integer>> zigzagtraversal(TreeNode node) {
		// For storing output
		List<List<Integer>> ret = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
        q.add(node);

        int l = 0;
        boolean flag = true; // When true we will save list in current order when false we will save in reverse order

        while(!q.isEmpty()) {
   			int size = q.size();
   			// To store each level
   			List<Integer> level = new ArrayList<>();

   			// Insert every element in queue first in the level list
   			for(int i=0; i<size; i++) {
   				TreeNode curr = q.poll();
   				if(curr != null) {
   					level.add(curr.data);
   					q.add(curr.left);
   					q.add(curr.right);
   				}
   			}
   			// Add this level to final output
   			if(!level.isEmpty()) {
   				if(flag == true) {
   					ret.add(level);
   					flag = false;
   				}
   				else {
   					Collections.reverse(level);
   					ret.add(level);
   					flag = true;
   				}

   			}
            
        }
        return ret;
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
        // Using bfs i.e. level order traversal
        List<List<Integer>> output = bt.zigzagtraversal(bt.root);
        System.out.print(output);
	}
}