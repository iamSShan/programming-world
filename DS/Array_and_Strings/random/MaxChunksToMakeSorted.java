/* https://leetcode.com/problems/max-chunks-to-make-sorted/
*/
import java.util.*;
class MaxChunksToMakeSorted {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for(int i=0; i<arr.length; i++)
			arr[i] = sc.nextInt();
		
		int max = Integer.MIN_VALUE;
		int count = 0;
		// We will iterate in the array first
		for(int i=0; i<arr.length; i++) {
			// We will only break when max current element becomes max and is at correct position, as elements go from 0 to n-1
			max = Math.max(max, arr[i]);

			// Check if current element has reached it's correct index, then break
			// for e.g 1, 0, 2, 3, 4; if we are on 2, then here 2 is at index 2, so we can create a partition here.
			if(max == i)
				count++;
		}
		System.out.println(count);
	}
}