class LinkedList {
	Node head; // head of list

	/* Linked list Node*/
	class Node {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	// Given a val, deletes the first occurrence of val in
	void deleteNodeIterative(int val) {
		// 5->4->6->1>8  ---------- ..->4->6->8
		// Store head node
		Node curr = head;

		// If node to be deleted is head only
		if(curr != null && curr.data == val) {
			head = curr.next;
			return;
		}

		// Find node to be deleted and every time save prev node
		Node prev = null;
		while(curr != null) {
			if(curr.data == val)
				break;
			prev = curr;
			curr = curr.next;
		}
		// Element not found
		if(curr == null)
			return;
		prev.next = curr.next;
	}

	Node deleteNodeAtkPosRecursive(Node curr, int pos) {
		// 5->4->6->1>8  ---------- ..->4->6->8

		// If LL is empty
		if(curr == null)
			return null;
	    // Wrong index
		if(pos < 1)
			return curr;
		// Base condtion
		if(pos == 1) { // If heads needs to be deleted
			Node res = curr.next;
			return res;
		}
		// We recursively reduce the value of k. When k reaches 1, we delete the current node and return the next current node as a new node.
		curr.next = deleteNodeAtkPosRecursive(curr.next, pos-1);
		return curr;
		
	}

	// Inserts a new Node at front of the list
	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	// This function prints contents of linked list starting from the given node
	public void printList(Node curr) {
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}

	public static void main(String[] args)
	{
		LinkedList ll = new LinkedList();

		ll.push(5);
		ll.push(4);
		ll.push(6);
		ll.push(1);
		ll.push(8);

		System.out.println("\nCreated Linked list is:");
		ll.printList(ll.head);

		ll.deleteNodeIterative(1); // Delete node with data 1 iteratively

		System.out.println("\nLinked List after deletion of 1 iteratively:");
		ll.printList(ll.head);

		ll.head = ll.deleteNodeAtkPosRecursive(ll.head, 3);
		System.out.println("\nLinked List after deletion of third element recursively:");
		ll.printList(ll.head);
	}
}
