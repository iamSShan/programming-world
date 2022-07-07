/* After this problem is asked in interview then first present solution using external list
   Then when improved solution is asked then give inplace solution
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

class MergeTwoSortedList {
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

	public static Node mergeAndSort1(Node h1, Node h2) {
		// Time Complexity = O(n1 + n2) ;n1 is length of first LL and n2 is length of second LL
		// Space Complexity = O(n1 + n2)

		// Create a dummy node
		Node d = new Node(-1);

		/* Points to the last result node so `dd.next` is the place to add new nodes to the result, d will be not changed so
		that we use it to return head at the end.
		*/
		Node dd = d;
		while(true) {
			// If one or both of the LinkedList are null

			// If first LL is null or becomes null after iterating then just point dd.next to second LL
			if(h1 == null) {
				dd.next = h2;
				break;
			}
			// If first LL is null or becomes null after iterating then just point dd.next to first LL
			if(h2 == null) {
				dd.next = h1;
				break;
			}

			// Now when both LL are not null


			if(h1.data <= h2.data) {
				dd.next = h1;
				h1 = h1.next;
			}
			else {
				dd.next = h2;
				h2 = h2.next;
			}
			// Advance the duplicate dummy node to the node which has been added just now so we add next elem to this node
			dd = dd.next;
		}
		return d.next;
	}

	public static Node mergeAndSort2(Node h1, Node h2) {
		/*
		Steps:
		  - Here which ever one is smallest point l1 to that and point other one to l2
		  - Then while both are not null and l1 is smaller than l2 we will iterate
		  - Whenever l1 > l2, we point prev of l1's next to l2 and swap l1 and l2 pointers, as our logic is based on l1 pointer should contain small value
		Time complexity: O(n1+n2)
		Space complexity: O(1)
		*/

		  // Corner case:
		  if(h1 == null) return h2;
		  if(h2 == null) return h1;

		  Node l1, l2;
		  if(h1.data <= h2.data) {
		  	l1 = h1;
		  	l2 = h2;
		  }
		  else {
		  	l1 = h2;
		  	l2 = h1;
		  }
		  // We are doing this, so we can return this as head in the end
		  Node res = l1;

		  // We will iterate till both of the lists are not null
		  while(l1 != null && l2 != null) {
		  	Node tmp = null;
		  	// Iterate till l1 is less than l2
		  	while(l1 != null && l1.data <= l2.data) {
		  		tmp = l1; // To store the prev node, so we can create a connection
		  		l1 = l1.next;
		  	}
		  	// Now here tmp will pointing to smaller node and l1 is pointing to node which has become larger than l2
		  	// therefore we will Now make tmp next to l2
		  	tmp.next = l2;
		  	// Also we will swap l1 and l2, as l1 has to be smaller one
		  	Node helper = l1;
		  	l1 = l2;
		  	l2 = helper;
		  }
		  // Return the head;
		  return res;

	}

	static void printList(Node h) {
	    while (h != null) {
	        System.out.print(h.data + " ");
	        h = h.next;
	    }
	    System.out.println();
	}

	public static void main(String[] args) {
		// Create object for two list
		MergeTwoSortedList list1 = new MergeTwoSortedList();
		MergeTwoSortedList list2 = new MergeTwoSortedList();

        // Add elements to first list
		list1.addToTheLast(new Node(5));
    	list1.addToTheLast(new Node(7));
    	list1.addToTheLast(new Node(9));
     
    	// Add elements to first list
	    list2.addToTheLast(new Node(3));
	    list2.addToTheLast(new Node(4));
	    list2.addToTheLast(new Node(8));
	    list2.addToTheLast(new Node(10));

	    // Using external linked list
	 //    Node new_head = mergeAndSort1(list1.head, list2.head);
		// printList(new_head);

		// Inplace
		list1.head = mergeAndSort2(list1.head, list2.head);
		printList(list1.head);
	}
}