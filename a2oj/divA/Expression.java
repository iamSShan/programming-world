// Problem: http://codeforces.com/problemset/problem/479/A

import java.util.Scanner;

public class Expression {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// Input two strings
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int max = Integer.MIN_VALUE;
		max = Math.max(max, a*(b+c));
		max = Math.max(max, (a*b)+c);
		max = Math.max(max, a*b*c);
		max = Math.max(max, a+(b*c));
		max = Math.max(max, (a+b)*c);
		max = Math.max(max, a+b+c);

		System.out.print(max);
	}
}