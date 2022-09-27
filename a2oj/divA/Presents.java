// Problem: http://codeforces.com/problemset/problem/136/A

import java.util.Scanner;

public class Presents {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// Input
		int n = sc.nextInt();
		int[] p = new int[n+1]; // We have to declare n+1 array as we are using 1 to n numbers
		for(int i=1; i<=n; i++) {
			int temp = sc.nextInt();
			p[temp] = i;
		}

		for(int i=1; i<=n; i++)
			System.out.print(p[i] + " ");
	}
}