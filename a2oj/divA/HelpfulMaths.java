// Problem: http://codeforces.com/problemset/problem/339/A

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class HelpfulMaths {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		/* We will simply iterate in this list and whenever a number is found, we will store it in a list
		   Then after all numbers are inserted, we will sort the list and then add '+' between numbers and print as string
		*/
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '1' || str.charAt(i) == '2' || str.charAt(i) == '3') {
				int dig = str.charAt(i) - '0'; // for char 3 it will give integer 3 
				list.add(dig);
			}
		}
		Collections.sort(list);
		String final_str = "";
		for(int i=0; i<list.size(); i++) {
			if(i==0)
				final_str += list.get(i);
			else
				final_str += "+" + list.get(i).toString();
		}
		System.out.print(final_str);
	}
}