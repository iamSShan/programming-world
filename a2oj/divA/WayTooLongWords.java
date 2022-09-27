// Problem: http://codeforces.com/problemset/problem/71/A

import java.util.Scanner;
public class WayTooLongWords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// For reading empty line
		sc.nextLine();
		for(int i=0; i<n; i++) {
			String str = sc.nextLine();
			int len = str.length();
			if(len <= 10)
				System.out.println(str);
			else {
				String len_of_array = Integer.toString(len-2);
				System.out.println(str.charAt(0) + len_of_array + str.charAt(len-1));
			}
		}
	}
}