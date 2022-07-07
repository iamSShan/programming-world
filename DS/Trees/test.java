import java.util.*;

class Node {
    int val;
    Node left, right;
    Node(int v) {
        val = v;
        left = right = null;
    }
}
class BinaryTree {
    Node root;

    public static void levelOrderPrint(Node root) {
        if(root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
          Node tmp = q.poll();
          if(tmp != null) {
            System.out.print(tmp.val + " ");
            if(tmp.left != null)
                q.add(tmp.left);
            if(tmp.right != null)
                q.add(tmp.right);
          }
            else {
                if(!q.isEmpty()) { // Important condition
                    System.out.println();
                    q.add(null);
                }
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
        bt.root.right.left = new Node(6);
        bt.root.right.right = new Node(7);
        bt.levelOrderPrint(bt.root);
    }

}