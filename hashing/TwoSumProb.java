/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

*/

import java.util.HashMap;

class TwoSumProb {
	public static void main(String[] args) {
		int[] nums = {3, 2, 4};
		int target = 6;
		// To store the output
		int [] solution = new int[2];

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0; i< nums.length; i++) {
			// If hash map already contains difference
			if(hm.containsKey(target-nums[i])) {
				solution[0] = hm.get(target-nums[i]);
				solution[1] = i;
			}
			else {
				hm.put(nums[i], i);
			}
		}
		for(int i=0; i<solution.length; i++)
			System.out.print(solution[i] + " ");
	}
}