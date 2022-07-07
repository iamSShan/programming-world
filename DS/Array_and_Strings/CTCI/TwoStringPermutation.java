/* Given two strings, check whether one is permutation of the other */

/* 
Note:
 - In previous versions of Java, Arrays.sort method used Quicksort for arrays of primitives and Merge sort for arrays of objects.
 - But in the latest versions of Java, Arrays.sort method and Collection.sort() uses Timsort.
*/

import java.util.Scanner;
import java.util.Arrays;

class TwoStringPermutation {



	static boolean arePermutation(String str1, String str2) {
		// If String lengths are not equal then they can't be permutation of each other
		if(str1.length() != str2.length()) {
			return false;
		}
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		Arrays.sort(s1);
		Arrays.sort(s2);
		for(int i=0; i<str1.length(); i++) {
			if(s1[i] != s2[i]) {
				return false;
			}
		}
		return true;
	}

	static boolean areCharsSame(String str1, String str2) {
		// If String lengths are not equal then they can't be permutation of each other
		if(str1.length() != str2.length()) {
			return false;
		}
		/* Assuming an array of 256, we could also use 2 diffenrent arrays for each string and then compare both arrays but we have optimized it here 
		  We have to use array not an integer because charAt(i) - 'a' will work only for a-z and not for other characters like symbols and all */
		int[] count = new int[256];
		// For each char in 1st string we have to add and for each char in 2nd string we have to subtract
		for(int i=0; i<str1.length(); i++) {
			count[(int)str1.charAt(i)] += 1;
			count[(int)str2.charAt(i)] -= 1;
		}

		// Now just check whether any value of the array is greater than 0, if yes then strings are not equal
		for(int i=0; i<count.length; i++) {
			if(count[i] != 0)
				return false;
		}
		return true;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		// ############################## Method-1 ###############################

		/* - A simple method can be Sorting both the strings and then comparing
		   - String is immutable in java so we have to create new string
		   - To sort easiest method is to convert it into charArray */
		// System.out.println("String are permutation of each: " + arePermutation(str1, str2));
		// Time Complexity: O(n2) if quick sort getting used in Arrays.sort else O(nlogn) if tim sort is getting used

		// ############################## Method-2 ###############################
		/* Count chars */
		System.out.println("String are permutation of each: " + areCharsSame(str1, str2));



	}
}
