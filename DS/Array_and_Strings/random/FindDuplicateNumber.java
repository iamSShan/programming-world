/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Example:
Input: nums = [3,1,3,4,2]
Output: 3

Input: nums = [1,1]
Output: 1

Input: nums = [1,1,2]
Output: 1

Basic naive solutions can be using:
- Two loops
- Sorting and comparing
- We can use Hashing for O(N) but it will have O(N) as space complexity
- Using sum of N numbers and then calculating difference between list sum and sum of n Numbers, Time Complexity: O(n) but Causes overflow for large arrays
- O(N) Solution T.C. and O(1) S.C. solution - Use XOR
- O(N) Solution T.C. and O(1) S.C. solution - Using indexing: For every index visit a[index], if it is positive change the sign of element at a[index] index, else print the element.
*/

class FindDuplicateNumber {
	public static void findRepeatedUsingXOR(int[] arr, int n) {
		/*
		Properties of XOR: i^i=0, i^0=i, i^j=j^i
		Steps:
			- Calculate XOR of numbers from 1 to n-1
			- Calculate XOR of array elements
			- Then XOR both to get result
		For example- XOR1: 3^1^3^4^2
		           - XOR2: 1^2^3^4
		Now when we XOR both XOR1 and XOR2 we get: 3^1^3^4^2  ^  1^2^3^4
		We can arrange it as for understanding purpose: 1^1 ^2^2 ^ 3^3 ^3 ^ 4^4 = 0^0^0^3^0 (As we know i^i=0)
		Therefore output will be 3
		*/
		int xor1 = 0, xor2 = 0;
		for(int i=0; i<n; i++) {
			xor1 = xor1^(i+1);
			xor2 = xor2^arr[i];
		}
		// As we are iterating < arr.length-1
		xor2 = xor2 ^ arr[n];

		System.out.println(xor1^xor2);
	}

	public static void main(String[] args) {
		int[] arr = {9, 8, 2, 6, 1, 8, 5, 3, 4, 7};
		int n =  arr.length-1;
		findRepeatedUsingXOR(arr, n);

	}
}
