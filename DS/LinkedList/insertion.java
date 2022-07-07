class LinkedList {

	Node head;

	class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
		}
	}

	// Time complexity of insertAfter() is O(n)
	public void PushAtEnd(int val) {
		// If linked list is empty
		if(head == null) {
			head = new Node(val);
			return;
		}
		Node new_node = new Node(val);
		// As it will be last node
		new_node.next = null;

		// Traverse till last node
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		last.next = new_node;
	}

	// Time complexity of insertAfter() is O(1)
	public void InsertAtBeginning(int val) {
		// If linked list is empty
		if(head == null) {
			head = new Node(val);
			return;
		}
		Node new_node = new Node(val);
		// Head should point to new_node's next
		new_node.next = head;
		// new_node will be the new head
		head = new_node;
	}

	// Time complexity of insertAfter() is O(1)
	public void InsertAfter(Node prev, int val) {
		// Prev node should be present
		if(prev == null) {
			return;
		}
		Node new_node = new Node(val);
		new_node.next = prev.next;
		prev.next = new_node;
	}
	public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }

    public void printRecurList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }

    public Node recurPushAtEnd(Node n, int val) {
    	// If linked list is empty, create a // new node
    	if(n == null) {
    		n = new Node(val);
    		return n;
    	}
    	// If we have not reached end, keep traversing recursively
    	n.next = recurPushAtEnd(n.next, val);
    	// System.out.println(n.data);
    	return n;
    }

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		// Iterative
		l.PushAtEnd(5); // As there will be just null so after insertion 5->null
		l.PushAtEnd(7); // Insert 7 at the end. So linked list becomes 5->7->null
		l.InsertAtBeginning(1); //  Insert 1 at the beginning. So linked list becomes 1->5->7->null
		l.InsertAfter(l.head.next, 8); //Insert 8, after 5. So linked list becomes  1->5->8->7->null
		l.printList(); // 1->5->8->7
		
		System.out.println("\nNow inserting recursively:");
		// Recursive
		Node n = l.recurPushAtEnd(l.head, 4); // Insert 7 at the end. So linked list becomes 5->7->null
		// We can insert at beginning in just O(1) so recursive method is not required to insert at beginning
		l.printRecurList(n);
	}
}
