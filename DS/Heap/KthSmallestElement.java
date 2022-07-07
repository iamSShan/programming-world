// T.C = O(nlogk)

import java.util.PriorityQueue;
import java.util.Collections;

class KthSmallestElement {
	public static void main(String[] args) {
		
		// Using max heap
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int[] arr = {1, 23, 12, 9, 30, 2, 50};
		int k = 3;

		for(int i=0; i<arr.length; i++) {
			
			// 1st way:

			// if(i<k)
			// 	pq.add(arr[i]);
			// else if(pq.peek() > arr[i]) { //pq.peek() will always give largest element
			// 	pq.poll(); // Remove largest element
			// 	pq.add(arr[i]);
			// }
			
			// 2nd way:
			pq.add(arr[i]);
			if(pq.size() > k) {
				pq.poll(); // as always largest element will be only popped
			}
		}
		System.out.print(pq.peek());

	}
}