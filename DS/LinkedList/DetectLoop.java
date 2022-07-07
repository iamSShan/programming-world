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

	Node head;

	public void push(int new_data) {
		Node n = new Node(new_data);
		n.next = head;
		head = n;
	}

	public void detectLoop() {
		Node slow_ptr = head, fast_ptr = head;
		int flag = 0;
		while(slow_ptr != null && fast_ptr != null && fast_ptr.next != null) { // fast_ptr.next it means current node is last node
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
			if(slow_ptr == fast_ptr) {
				flag = 1;
				break;
			}
		}
		if(flag == 1)
			System.out.println("Loop detected");
		else
			System.out.println("No loop");
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.push(20);
		ll.push(4);
		ll.push(15);
		ll.push(10);

		ll.head.next.next.next.next = ll.head;
		ll.detectLoop();
	}

}