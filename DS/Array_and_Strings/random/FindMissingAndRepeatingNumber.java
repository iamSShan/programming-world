/*
Given an unsorted array of size n. Array elements are in the range from 1 to n.
One number from set {1, 2, …n} is missing and one number occurs twice in the array. Find these two numbers.
Example:
Input: arr[] = {4, 3, 6, 2, 1, 1}
Output: Missing = 5, Repeating = 1

In interview, we have to tell various approaches, starting from naive solutions and moving towards optimal one
Method 1- Sorting: Sort the array and check if consecutive elements are equal also check whether i==arr[i] as range is 1 to n-1; Time complexity: O(nlogn)
Method 2- Use hashmap, iterate in array and for every number check if element already exist then it is repeating element else insert in Hashmap
		  Then again iterate from 1 to n-1 to know if any element between 1 to n is not in map; Time complexity: O(2n), Space complexity: O(n)
Method 3(Optimal approach)-
--------------------------
We are given elements b/w 1 to n, so we can use sum of n natutal numbers property somehom
If we do 1+ 2+3+...n = n(n+1)/2 = S
Also we sum squares of number: 1^2 + 2^2+ 3^2 + .... n^2 = n(n+1)(2n+1)/6 = S^2
If we subtract S - (sum of list) 
1+2+3+4+5+6 - 1+1+2+3+4+6 =>  5 - 1 => 4; here we can see 5 is missing number and 1 is repeating number
So in general terms we can write X-Y = 4 (4 is calculated as S- sum(list)) ------eqn (1)
 
Similarly for second eqn:
=> (1^2 + 2^2 + 3^2 + 4^2 + 5^2 +6^2) -  (1^2 +1^2 +2^2 +3^2 +4^2 +6^2)
=> (5^2 - 1^2) =  24
=> In generalized form => X^2 - Y^2 = 24 ----- eqn(2)

Now we have to solve these two eqns, so in this case: 
=> X^2 - Y^2 = 24
=> (X+Y)(X-Y) = 24
=> (X+Y) *4 = 24 (we know X+Y=4 from eqn 1)
=> (X+Y) = 6

Now we have two equations X+Y = 6 and X-Y=4, if we add two equations, we get
X+Y + X - Y = 10 => 2X = 10 => X = 5(missing number)
If we put X in first eqn we will get Y as 1(i.e repeating number)

But there is some limitations to this approach, since we are using squares so summation might exceed as it may cross integer limit, so we may have to use long here
Time complexity: O(n), Space complexity: O(1)

Method 4(Most Optimal approach)-
--------------------------
We will take xor as 0 and we will xor all list elements and we will get some X
Then we Xor this X to all numbers from 1 to n-1
e.g: List is (4^3^6^2^1^1) ^  (1^2^3^4^5) =  1^5 (as common elements xor becomes 0; a^a=0) // Or we can write it as 5^1 = Xor answer
Therefore we can write it as X^Y = 4(We get 4 by Xor operation of above); where X is missing number and 1 is repeating number

Now we will focus on XOR output i.e 4, its binary is 100, then we focus on first 1(from the RHS)
we can say 1 in `4` is at second index, so a element to be 1 either X should be 1 and Y should be 0 or X should be 0 and Y should be 1
(as 1^1 =0 and 1^0=1; when different it gives 1)

Now our next task it to classify our list into two sets; if second index bit is 1, then we put that element in first set, if 0 then put in second set.
For e.g 4 has second index as set bit we insert it into first set and 3 is 011(second index is not 1) we will insert it into second set.
Similarly
First set contains:4, 6
Second set contains:3, 2, 1, 1

Now we will take the range 1 to n-1 [1,2,3,4,5,6] and perform the same operation
First set will be updated to: 4, 6, 4, 5, 6
Second will be updated to: 3, 2, 1, 1, 1, 2, 3

Now when we XOR first set we get 5 (missing number)
Now when we XOR second set we get 1 (repeating number)
*/
class FindMissingAndRepeatingNumber {
	
	static void find_using_equations(int[] arr, int n) {
		long sum = (n*(n+1))/2;
		long square_sum = (n*(n+1)*(2*n+1))/6;
		long list_sum = 0;
		long list_square_sum = 0;
		for(int i=0; i< arr.length; i++) {
			list_sum += arr[i];
			list_square_sum += Math.pow(arr[i], 2);
		}
		long eqn1_sum = sum-list_sum;  // X-Y = 4
		long eqn2_sum = square_sum-list_square_sum;  // X^2 - Y^2 =  24
		// Now if we suppose we have X-Y = eqn1_sum and X^2 - Y^2 = eqn2_sum
		// We know X+Y = eqn2_sum/eqn1_sum(as accoring to above logic) so we can store this to a new variable
		long eqn3_sum = eqn2_sum/eqn1_sum;  // X+Y = 6

		// Then next step was to add X+Y and X-Y(i.e eqn3 and eqn 1)
		long X = (eqn3_sum+eqn1_sum) / 2; // X+Y + X - Y = 10 => 2X = 10 => X = 5
		long Y = eqn3_sum-X;  // (X+Y = eqn3_sum => Y= eqn3_sum-X)
		System.out.print("Missing number is: " + X + " and repeating number is: " + Y);
	}

	static void find_using_xor(int[] arr, int n) {
		
		int xor = 0;
		// xor of the list
		for(int i=0; i<n; i++) {
			xor = xor ^ arr[i];
		}

		// xor of the range with previous result
		for(int i=1; i<=n; i++) { // as range is from 1 to n
			xor = xor ^ i;
		}

		// Get the right most set bit
		// xor=3;
		int setbit = xor & ~(xor-1); // xor =4, (xor-1)=3 => ~(xor-1) => 4(as 3 is 011 if we negate it we get 100 i.e 4) => then 4^4 =4(and 4 is the first set bit(... 4, 2, 1))
		// System.out.print(setbit);

		// Now divide it into two set, first set will contain setbit index as 1 second set will contain setbit index as 0
		// First using array
		int x = 0, y = 0;
		for(int i=0; i<n; i++) {
			if((arr[i] & setbit) != 0) // as 4 will contain only one 1 and rest will be 0 so only one bit is checked with other number
				x = x^arr[i];
			else
				y = y^arr[i];
		}

		// Now iterate in range 1 to n 
		for(int i=1; i<=n; i++) {
			if((i&setbit) != 0)
				x = x^i;
			else
				y = y^i;
		}
		System.out.print("Missing number: " + x + " and repeating number: " + y);
	}

	public static void main(String[] args) {
		int[] arr = {4, 3, 6, 2, 1, 1};
		find_using_xor(arr, arr.length);
	}
}