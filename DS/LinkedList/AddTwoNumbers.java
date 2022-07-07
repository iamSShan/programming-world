/* Probblem: https://leetcode.com/problems/add-two-numbers/
*/

class Node
{
    int data;
    Node next;
    Node(int d) {
    	data = d;
        next = null;
    }
}

class AddTwoNumbers {
	Node head;


	void addToTheLast(Node node) {
		/* Add element at the end of the list */
		if(head == null) {
			head = node;
		}
		else {
			Node temp = head;
			while(temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}

	static Node addList(Node l1, Node l2) {
		// This problem just has optimal solution
		Node dummy = new Node(-1); // It will be used for returning final head
		Node temp = dummy; // It will be used for traversing
		int sum = 0, carry = 0;
		
		while(l1 != null || l2 != null) {
			int x = (l1 != null)? l1.data: 0;
			int y = (l2 != null)? l2.data: 0;
			sum = x + y + carry;
			carry = sum/10;

			// Now we have to store this sum node to some new node
			temp.next = new Node(sum%10);
			temp = temp.next;
			if(l1 != null)
				l1 = l1.next;
			if(l2 != null)
				l2 = l2.next;
		}
		// If carry was there then add it as a new node
		if(carry > 0)
			temp.next = new Node(carry);
		return dummy.next;
	}

	
	static void printList(Node h) {
	    while (h != null) {
	        System.out.print(h.data + " ");
	        h = h.next;
	    }
	    System.out.println();
	}

	public static void main(String[] args) {
		// Create object for the list
		AddTwoNumbers list1 = new AddTwoNumbers();
		AddTwoNumbers list2 = new AddTwoNumbers();

        // Add elements to the list
		list1.addToTheLast(new Node(2));
		list1.addToTheLast(new Node(4));
		list1.addToTheLast(new Node(3));
		
		list2.addToTheLast(new Node(5));
    	list2.addToTheLast(new Node(6));
    	list2.addToTheLast(new Node(7));
    	list2.addToTheLast(new Node(9));
		Node new_head = addList(list1.head, list2.head);
		printList(new_head);
	}
}