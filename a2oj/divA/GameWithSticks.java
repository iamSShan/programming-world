// Problem: http://codeforces.com/problemset/problem/451/A

import java.util.Scanner;

public class GameWithSticks {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// Input
		int n = sc.nextInt();
		int m = sc.nextInt();
		int min = n<=m? n : m;
		if(min%2 == 0)
			System.out.println("Malvika");
		else
			System.out.println("Akshat");
	}
}