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

	Node reverseIterative() {
		/*
		  Time complexity = O(N)
   		  Space complexity = O(1)
		*/
		Node curr = head;
		Node nex = null, prev = null;
		while(curr != null) {
			nex = curr.next;
			curr.next =  prev;
			prev = curr;
			curr = nex;
		}
		return prev;
	}

	Node reverseRecursive(Node curr) {
		/*
		Steps:
			1) Divide the list in two parts - first node and rest of the linked list.
   			2) Call reverse for the rest of the linked list.
   			3) Link rest to first.
   			4) Fix head pointer
		*/
		// Base condition if just one node i.e. curr.next == null
		if(curr == null || curr.next == null)
			return curr;
		
		// Now Hypothesis reverseRecursive(curr) -> will return recursive list and for smaller input reverseRecursive(curr.next)

		// Now reverse the rest list and put the first element at the end
		Node rest = reverseRecursive(curr.next);
		
		// Induction Step
		curr.next.next = curr;
		curr.next = null;
		return rest; // last node will be rest that will be our head
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

		// ll.head = ll.reverseIterative(); // Reverse Linkedlist

		// System.out.println("\nLinked List after reverse operation:");
		// ll.printList(ll.head);

		ll.head = ll.reverseRecursive(ll.head);
		System.out.println("\nLinked List after recursive reverse operation:");
		ll.printList(ll.head);
	}
}
