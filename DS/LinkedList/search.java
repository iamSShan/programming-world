class LinkedList {
	
	Node head;

	class Node {
		Node next;
		int data;
		Node(int d) {
			this.data = d;
			next = null;
		}
	}

	void push(int val) {
		if(head == null) {
			head = new Node(val);
			return;
		}
		Node new_node = new Node(val);
		new_node.next = head;
		head = new_node;
	}

	boolean search_iterative(int val) {
		// If LinkedList is empty
		if(head == null) {
			return false;
		}
		// Else copy head value to other variable so we curr becomes null instead of head
		Node curr = head;
		while(curr != null) {
			if(curr.data == val)
				return true;
			curr = curr.next;
		}
		return false;
	}

	boolean search_resursive(Node head, int val) {
		// Base condition
		if(head == null) {
			return false;
		}
		if(head.data == val)
			return true;

		return search_resursive(head.next, val);
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.push(10);
        ll.push(30);
        ll.push(14);
        ll.push(51);
        ll.push(23);

		// Iterative Search
		
		// We can also pass head but we have it as global variable so it is not required
		if(ll.search_iterative(14))
			System.out.println("Element exists");
		else
			System.out.println("Element doesn't exists");
		
		// Recursive Search

		// Here we have to pass head because in each call value will be different for current node
		if(ll.search_resursive(ll.head, 51))
			System.out.println("Element exists");
		else
			System.out.println("Element doesn't exists");
	}
}