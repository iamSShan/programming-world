/*
You are given a linked list of 'N' nodes and an integer 'K'. 
You have to reverse the given linked list in groups of size K i.e if the list contains x nodes numbered from 1 to x,
then you need to reverse each of the groups (1,K),(K+1,2*K), and so on.
For example, if the list is [1, 2, 3, 4, 5, 6] and K = 2, then the new list will be [2, 1, 4, 3, 6, 5].

Problem is called as Reverse List In K Groups
*/

import java.util.Stack;

class LinkedList {
	Node head;
	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Inserts a new Node at front of the list
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

	public Node recurKReverse(Node head, int k) {
		Node curr = head;
		Node nex = null, prev = null;
		// 1->2->3->4->5->6->7
		int count = 0;
		while(curr != null && count < k) {
			// For every group
			nex = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nex;
			count ++;
		}
		// It comes here after one group is reversed
			// 3->2->1 -> 4->5..
			if(curr != null)
				// Recursively call for the list starting from current. And make rest of the list as next of first node 
				head.next = recurKReverse(curr, k);
			
			return prev;

	}

	// We have to use Stack here
	public Node iterKReverse(Node head, int k) {
		Stack<Node> s = new Stack<Node>();
		int count;
		Node curr = head;
		Node prev = null, nex = null;
		// We will end the loop when all elements from the list has been accessed
		while(curr != null) {
			// Now we will insert k elements in stack
			count = 0;
			while(count < k) {
				s.push(curr);
				curr = curr.next;
				count ++;
			}
			// Now we have to reverse the elements of the stack
			while(!s.isEmpty()) {
				// For the first time(when final list is not been started yet)
				if(prev == null) {
					prev = s.peek(); // 3;   1->2->3
					head = prev; // End of first group should be head
					s.pop();
				}
				else {
					prev.next = s.peek(); // 2 will come in next of 3
					prev = prev.next;
					s.pop();
				}
			}
		}
		// Next of last element will point to NULL.
		prev.next = null;
		return head;
	}


	void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		// Linked List is 1->2->3->4->5->6->7->8->8->9->null
		ll.push(9);
        ll.push(8);
        ll.push(7);
        ll.push(6);
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);
 
        System.out.println("Linked List: ");
        ll.printList();
 
        // Reversing the Linked List using Recursion
        ll.head = ll.recurKReverse(ll.head, 3);
 
        System.out.println("Reversed Linked List: ");
        ll.printList();

        // Reversing the Linked List using Iterative approach
        ll.head = ll.iterKReverse(ll.head, 3);
        System.out.println("Reversed Linked List: ");
        ll.printList();

	}
}