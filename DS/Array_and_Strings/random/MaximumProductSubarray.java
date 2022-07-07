// Problem: https://leetcode.com/problems/maximum-product-subarray/

/*
Solution-1: Use two loops to find maximum for all numbers

Solution-2: Extend concept of Maximum sum subarray, take two max_ending_at one for min and one for max; min because negatiive of two numbers can be positive
		  : As a single element can be greater than array then at every time we need to check between arr[i], max_ending_at, min_ending_at
		  : Whenever 0 comes then make max and min as 1, as if we multiply then it would become 0
		  : Forgot the logic, check this: https://www.youtube.com/watch?v=0exOBHgzApE

		  : This approach won't work for arrays with max product either negative or zero, so 
*/

class MaximumProductSubarray {


	public static int maxProduct(int[] nums) {
		// Boundary case
		if(nums == null || nums.length == 0)
			return 0;

		int max_so_far = nums[0];
		int max_ending_at = nums[0];
		int min_ending_at = nums[0];

		// Start with 1 as 0th index is already stored in above variables
		for(int i=1; i<nums.length; i++) {

			// We need to first check condition of 0
			if(nums[i] == 0) {
				max_ending_at = 1;
				min_ending_at = 1;
				continue;
			}

			// Storing this in variable as we will update max_ending_at
			int temp = max_ending_at;
			// multiplying to nums[i], as we are iterating forward to get max product
			// Note: Math.max and Math.min takes only two paramaters
			max_ending_at = Math.max(nums[i], Math.max(nums[i]*max_ending_at, nums[i]*min_ending_at));
			min_ending_at = Math.min(nums[i], Math.min(nums[i]*temp, nums[i]*min_ending_at));

			if(max_so_far < max_ending_at)
				max_so_far = max_ending_at;
		}
		return max_so_far;
		
	}

	public static void main(String[] args) {
		int[] nums = {-2, -3, 4, 5, 6, 0, 50};
		System.out.print(maxProduct(nums));
	}
}