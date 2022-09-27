// Problem: http://codeforces.com/problemset/problem/112/A

import java.util.Scanner;

public class PetyaAndStrings {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// Input two strings
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		// As it is guaranteed that the strings are of the same length we don't need any edge condition
		// For maintaining same order we will be handing string in lowercase order
		String s1 = str1.toLowerCase();
		String s2 = str2.toLowerCase();

		// Now we will use compareTo: This method returns 0 if the string is equal to the other string. A value less than 0 is returned if the string is less than the other string (less characters) and a value greater than 0 if the string is greater than the other string (more characters).
		if(s1.compareTo(s2) == 0)
			System.out.println(0);
		else if(s1.compareTo(s2) < 0)
			System.out.println(-1);
		else
			System.out.println(1);
	}
}