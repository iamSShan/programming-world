/*
- Method-1: Using sorting- O(NlogN)
- Method-2: Using counting sort(count each 0, 1 and 2) and loop for each to insert the number of element as per the count- O(2N)
- Method-3: Variation of Dutch national flag problem- O(N); we will implment this
*/

class SortArrayOf0_1_2 {

	public static void sort_array(int[] arr) {
		// We want 0...low-1 to contains 0, and high+1..n to 2
		// We will use three pointers: low, mid, high
		// mid will be our moving pointer, so we will move until mid <= high

		int low = 0, mid = 0, high = arr.length-1;
		while(mid <= high) {
			if(arr[mid] == 0) {
				int temp = arr[mid];
				arr[mid] = arr[low];
				arr[low] = temp;
				mid++;
				low++;
			}
			else if(arr[mid] == 1) {
				mid++;
			}
			else {
				int temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
			}
		}
	}

	public static void main(String[] args) {
		int [] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		sort_array(arr);
		for(int i=0; i<arr.length; i++) 
			System.out.print(arr[i] + " ");
	}
}