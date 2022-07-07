/* https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/

Method-1: We can sort it and get last k elements - O(nlogn)
Method-2: We can use priority queue, we can have a priority queue of size k, where first we will insert k elements then every time we will poll the element with highest priority(i.e. lowest number)
and insert the next element of array if that element is larger than polled element
*/

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class KLargestElements {
	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] arr = {1, 23, 12, 9, 30, 2, 50};
		int k = 3;

		for(int i=0; i<arr.length; i++) {
			if(i<k)
				pq.add(arr[i]);
			else if(pq.peek() < arr[i]) { //pq.peek() will always give smallest element
				pq.poll(); // Remove smallest element
				pq.add(arr[i]);
			}
		}
		// Now copy priority queue elements in output list
		List<Integer> array_list = new ArrayList<Integer>(pq);
		for(int i=array_list.size()-1; i>=0; i--)
			System.out.print(array_list.get(i) + " ");
	}
}