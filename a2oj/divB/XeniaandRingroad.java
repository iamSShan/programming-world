// Problem: https://codeforces.com/problemset/problem/339/B

import java.util.Scanner;

public class XeniaandRingroad {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int m = sc.nextInt();
		long[] a = new long[m];
		for(int i=0; i<m; i++)
			a[i] = sc.nextInt();

		long curr = 1, steps = 0;
		for(int i=0; i<m; i++) {
			if(curr <= a[i]) {
				steps += a[i]-curr;
				// System.out.println(steps);
			}

			else {
				steps += (n-curr) + a[i];
				// System.out.println(n-a[i] + "## " + a[i]);
				// System.out.println(n-a[i]);
			}

			curr = a[i];
		}
		System.out.println(steps);
	}
}