// Important question of LinkedList
// Problem: https://leetcode.com/problems/reverse-nodes-in-k-group/

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


	public Node KReverse(Node head, int k) {
		// T.C: O(N/k) * k = O(N) // For each N/k group we are are doing k iterations
		// S.C: O(1)

		if(head == null || k == 1)
			return head;

		// In first step we will calculate length of the linked list
		// Then we will use dummy node concept, we will take dummy node as assign next of it as first node
		Node dummy = new Node(-1);
		dummy.next = head;
		Node curr = dummy, prev = dummy, nex = dummy;
		int count = 0;
		while(curr.next != null) {
			count ++;
			curr = curr.next;
		}
		
		while(count >= k) {
			// Representation: prev -> curr -> nex -> nex.next
			curr = prev.next; // prev will always point to the last node of prev group
			nex = curr.next; // 2nd code in that segment
			// For each k segments
			for(int i=1; i<k; i++) { 
				// We have to reverse two links in case of k = 3: curr -> nex-> nex.next;
				curr.next = nex.next; // Break first link and point to last node (in first segment)
				nex.next = prev.next; // Reverse first link
				prev.next = nex; // Now make prev.next as 2nd node, as in second iteration we will perform same for second link and so on
				nex = curr.next; // And make third node as next now
			}
			prev = curr; // Make prev as last node of the processed group
			count -= k;
		}
		System.out.print(dummy.next.data);
		return dummy.next; //first node
	}


	void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		// Linked List is 1->2->3->4->5->6->7->8->null
		// Here output should be 3->2->1->6->5->4->7->8->null
		// If k=3, We don't have to revese nodes 7 and 8, as size of remaining nodes is less than k
        ll.push(8);
        ll.push(7);
        ll.push(6);
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);
 
        System.out.println("Linked List: ");
        ll.printList(ll.head);

        ll.head = ll.KReverse(ll.head, 3);
        System.out.println("Reversed Linked List: ");
        ll.printList(ll.head);

	}
}