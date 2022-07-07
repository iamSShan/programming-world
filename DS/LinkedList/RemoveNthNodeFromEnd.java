/*
2->4->1->3->5->6 and k = 4 then we have to delete 1 so final LL will be 2->4->3->5->6
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

		// This empty was created so we can create an empty node without specifying any value
		Node() {}
	}

	// Inserts a new Node at front of the list
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

	public Node removeNthNode_1(Node head, int k) {
		/*
			Here we will iterate till length of LL to know the length of LL
			Then we will subtract k from it and then remove element at (len - k) + 1

			Time Complexity: O(n+n) = O(2n)
			Space Complexity: O(1)
		*/
		Node temp = head;
		int len = 0;
		while(temp != null) {
			temp = temp.next;
			len += 1;
		}
		// If head is to be updated - Corner case
		if(len == k) {
			head = head.next;
		}
		// If k is greater than len then normally return head
		else if(k > len)
			return head;
		// For other nodes
		else {
			temp = head;
			int count = 0;
			// 1 2 3 4 5 6 7 8 9
			// 9-3 =6
			while(count < (len-k-1)) {
				temp = temp.next;
				count += 1;
			}
			// System.out.println(temp.data);
			temp.next = temp.next.next;
		}
		return head;
	}


	public Node removeNthNode_2(Node head, int k) {
		/* We have to improve the solution
		   Can we do it in one go as in above solution we are traversing two times

		   Here we will use slow and fast pointer concept

		   Time Complexity: O(n)
		   Space Complexity: O(1)
		*/

		 // Start is a dummy node
		 Node start = new Node();
		 start.next = head;
		 Node slow_ptr = start, fast_ptr = start;

		 // Move k steps forward with fast pointer
		 int count = 0;
		 while(count < k) {
		 	fast_ptr = fast_ptr.next;
		 	count++;
		 }

		 // Now reach till last node of the list by moving fast pointer and slow pointer by 1-1 step and then next of slow pointer will be node to be deleted
		 while(fast_ptr.next != null) {
		 	fast_ptr = fast_ptr.next;
		 	slow_ptr = slow_ptr.next;
		 }

		 // Delete the next of slow pointer
		 slow_ptr.next = slow_ptr.next.next;
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
		// Linked List is 1->2->3->4->5->6->7->8->9->null
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
 	
 		// 1st method
        // ll.head = ll.removeNthNode_1(ll.head, 3);
 
        // System.out.println("Output Linked List: ");
        // ll.printList();

        // 2nd method (improved solution)
        ll.head = ll.removeNthNode_2(ll.head, 3);
        System.out.println("Output Linked List: ");
        ll.printList();

	}
}