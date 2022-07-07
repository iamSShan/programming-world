/* Determine if a string has all unique characters. We cannot use additional data structures */

/* 
Note: 
 - Ask whether string is ASCII string or unicode string
 - Refer: https://medium.com/@vanvlymenpaws/ascii-vs-unicode-4174def5c09d
 - Solution wrt ASCII is below
 - Solution wrt Unicode is yet to come
*/

import java.util.Scanner;

class UniqCharString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		boolean uniqChars = true;
		// ############################## Method-1 ###############################

		// A simple method can be brute force; using two loops and checking one by one
		// Time Complexity: O(n2)
		
		// for(int i=0; i<str.length()-1; i++) {
		// 	for(int j=i+1; j<str.length(); j++) {
		// 		if(str.charAt(i) == str.charAt(j)) {
		// 			uniqChars = false;
		// 			break;
		// 		}
		// 	}
		// }

		// ############################## Method-2 ###############################
		
		/* Another method can be to use a dictionary or map and store count of each character as value, 
		   if any character value is greater than 1 then unique character doesn't exists; 
		   but here we are not allowed to use any extra DS */
		
		 // ############################## Method-3 ###############################
		
		/* The approach is valid for strings having alphabet as a-z 
		   We can use bit manipulation, an integer is of size 4 bytes and each bytes has 8 bit so we can represent */
	

		int checker = 0;
		for(int i=0; i<str.length(); i++) {
			int bitAtIndex = str.charAt(i) - 'a'; // for `a` it will give 0, for `b` it will give 1 and so on..
			/* 
			  -> 1<< bitAtIndex: for 1<<0  gives 1 at 0th index; for 1 << 1 gives 1 at 1st index; 1<<2 gives 1 at 2nd index; 1<<3 gives 1 at 3rd index
			  -> checker &  is used to check whether if it was previously 1 or not
			*/
			if((checker & (1 << bitAtIndex)) > 0) // if it was previously 1 then it will be greater than 0 else 0
				uniqChars = false;
			// Now when a particular character has occurred then make it as 1 so if next time it comes again we return false
			checker = checker | (1<< bitAtIndex);

		}
		if(uniqChars == true)
			System.out.println("Unique Characters");
		else
			System.out.println("Not Unique");
	}
}
