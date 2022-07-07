/* https://leetcode.com/problems/max-chunks-to-make-sorted/
*/
import java.util.*;
class MaxChunksToMakeSorted_ii {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for(int i=0; i<arr.length; i++)
			arr[i] = sc.nextInt();

		// Here we have to create two arrays: Left max and right min, we can also create on array and create second array while traversing
		// We will create rightmin array first
		int[] out = new int[arr.length+1];

		out[out.length-1] = Integer.MAX_VALUE; 
		// Creating rightMin array
		for(int i=arr.length-1; i>=0; i--) {
			out[i] = Math.min(arr[i], out[i+1]);
		}


		int leftMax = Integer.MIN_VALUE;
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			leftMax = Math.max(leftMax, arr[i]);
			if(leftMax <= out[i+1])
				count++;
		}
		System.out.println(count);
	}
}