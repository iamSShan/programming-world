/* Given a singly linked list, find the middle of the linked list. For example, if the given linked list is 1->2->3->4->5 then the output should be 3. 
If there are even nodes, then there would be two middle nodes, we need to print the second middle element. For example, if given linked list is 1->2->3->4->5->6 then the output should be 4. 

Method 1: 
Traverse the whole linked list and count the no. of nodes. Now traverse the list again till count/2 and return the node at count/2. 

Method 2: 
Traverse linked list using two pointers. Move one pointer by one and the other pointers by two. When the fast pointer reaches the end slow pointer will reach the middle of the linked list.
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

class MiddleOfLL {
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

	static void findMiddle(Node head) {
		Node slow = head, fast = head;
		while(fast != null && fast.next != null) { // fast.next != null is used for odd elements case if it reaches end element then slow will be at middle element
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println(slow.data);
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
		MiddleOfLL ll = new MiddleOfLL();

        // Add elements to the list
		ll.addToTheLast(new Node(1));
		ll.addToTheLast(new Node(2));
		ll.addToTheLast(new Node(3));
		ll.addToTheLast(new Node(4));
    	ll.addToTheLast(new Node(5));
    	ll.addToTheLast(new Node(6));
		findMiddle(ll.head);
	}
}