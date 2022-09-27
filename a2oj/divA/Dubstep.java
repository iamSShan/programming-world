// Problem: http://codeforces.com/problemset/problem/208/A

import java.util.Scanner;

public class Dubstep {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// Input
		String str = sc.nextLine();
		String final_str = "";
		// Simple approach can be to split on "WUB" and we will then get an array and then traverse that array and print only those elements which are not ""

		// Another efficient approach without using any inbuilt function:

		// Flag taken so we can handle spaces between words(if we don't consider some cases it will give WEARETHECHAMPIONSMYFRIEND for WUBWEWUBAREWUBWUBTHEWUBCHAMPIONSWUBMYWUBFRIENDWUB)
		boolean flag = false;

		for(int i=0; i<str.length(); i++) {
			if((str.length()-i) >= 3 && str.charAt(i) == 'W' && str.charAt(i+1) == 'U' && str.charAt(i+2) == 'B') {
				// (str.length()-i) >= 3: this condition is necesssary

				i += 2; // Not +3 as we are iterting in loop, eventually 1 will be incremented
				// Check if a word is already present then add a space
				if(flag == true) {
					final_str += ' ';
					// Again making this false, so 2 continuous spaces are not added
					flag = false;
				}
			}
			else {
				// Just add current character
				final_str += str.charAt(i);
				// Make flag true which means first one is going to be entered
				flag = true;
			}

		}
		// Remove spaces at the end
		System.out.print(final_str.trim());
	}
}