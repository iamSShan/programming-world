import java.util.*;
class Node {
	int data;
	Node next;
	Node(int d) {
		data = d;
		next = null;
	}
}

class LinkedList {

	static Node head, head1, head2;

	public void push(int new_data) {
		Node n = new Node(new_data);
		n.next = head;
		head = n;
	}

	public void splitList() {
		if(head == null)
			return;
		Node slow_ptr = head, fast_ptr = head;

		// We have to reach till end node
		while (fast_ptr.next != head && fast_ptr.next.next != head) {
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
		}

		// In case of even nodes fast_ptr will be one before last node so move node forward
		if(fast_ptr.next.next == head)
			fast_ptr = fast_ptr.next;

		// Now we need to make two circular LL from one using current positions of slow and fast pointers
		// 1) Create two heads
		head1 = head;
		if(head.next != head)
			head2 = slow_ptr.next;

		// 2) Make second half circular
		fast_ptr.next = slow_ptr.next;
		// 3) Make first half circular
		slow_ptr.next = head;

	}

	void printList(Node node) {
        Node temp = node;
        if (node != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != node);
        }
    }

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(12);
        list.head.next = new Node(56);
        list.head.next.next = new Node(2);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = list.head;
 
        System.out.println("Original Circular Linked list ");
        list.printList(head);
 
        // Split the list
        list.splitList();
        System.out.println("");
        System.out.println("First Circular List ");
        list.printList(head1);
        System.out.println("");
        System.out.println("Second Circular List ");
        list.printList(head2);
	}

}