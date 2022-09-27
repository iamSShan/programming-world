// Problem: http://codeforces.com/problemset/problem/58/A

import java.util.Scanner;

public class ChatRoom {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String actual = "hello";
		int idx = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == actual.charAt(idx))
				idx++;
			if(idx == 5)
				break;
		}
		if(idx==5)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}