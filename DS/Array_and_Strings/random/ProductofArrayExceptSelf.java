// https://leetcode.com/problems/product-of-array-except-self/

class ProductofArrayExceptSelf {
	
	public static int[] better_solution(int[] arr) {
	 	/* Solution-2:
			* Let's say this is a list [1,2,3,4]
			* At any index let's say at index 1: output at index will be multiplication of elements at left side and elements at right side
			* So we can calculate product from bothe ends of array and store in two different arrays
			* First product array p1 = [1, 1*2, 2*3, 6*4] = [1,2,6,24] // we have calculated cummulative product
			* For second product array p2(we will be starting from end but end index will come at the end only) [  24*1, 12*2 , 4*3 , 4] = [24, 24, 12, 4]
			* Now for any index on original array final product will be multiplication of p1[index-1] and p2[index+1];
			* index-1 will total left elements product for current index(as cummulative peoduct is taken) and index+1 will contain product of all right array elements for that current index
			* There are two boundary cases, first element won't have left and last element of array won't have right
			* So simply for 1st array element we will not take left , we will just take p2[index+1]; and for last array element we will take p1[index-1]
			* But for rest of the elements we will take p1[index-1] * p2[index+2]
		*/
		int n = arr.length;
		int[] p1 = new int[n];
		int[] p2 = new int[n];
		int[] out = new int[n];

		// Create product p1
		p1[0] = arr[0];
		for(int i=1; i<n; i++)
			p1[i] = p1[i-1] * arr[i];

		// Create product p2
		p2[n-1] = arr[n-1];
		for(int i=p2.length-2; i>=0; i--)
			p2[i] = p2[i+1] * arr[i];
		

		// Boundary cases
		out[0] = p2[1];
		out[n-1] = p1[n-2];

		for(int i=1; i<n-1; i++) {
			out[i] = p1[i-1] * p2[i+1];
		}

		return out;
	}

	public static int[] best_solution(int[] arr) {
		/*
		Here we will take one array only i.e output array and as mentioned in question: The output array does not count as extra space for space complexity analysis.
		We will be just improving space complexity of above solution
		First product array will be saved in output array only, then instead of second product array we will be directly multiplying the numbers using a variable
		*/
		int n = arr.length;
		int[] out = new int[n];
		out[0] = arr[0];
		for(int i=1; i<n; i++)
			out[i] = out[i-1] * arr[i];

		int temp = 1;
		// Boundary case-1
		out[n-1] = out[n-2];

		for(int i=n-2; i>0; i--) {
			temp = temp * arr[i+1];
			out[i] = out[i-1] * temp;
		}
		// Boundary case-2
		out[0] = temp * arr[1];

		return out;
	}

	public static void main(String[] args) {
	
		
		
		int[] arr = {1,2,3,4};
		// Solution-1: Use brute force o(n^2)
		// Solution-2:
		int[] res = best_solution(arr);
		for(int i=0; i<res.length; i++)
			System.out.print(res[i] + " ");

	}
}