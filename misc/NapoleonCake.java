// Problem: https://codeforces.com/contest/1501/problem/B

import java.util.*;

public class NapoleonCake {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt();
			int [] a = new int[n];
			int [] res = new int[n];
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();

			int drenched = a[n-1];
			for(int i=n-1; i>=0; i--) {
				int max = Math.max(a[i], drenched);
				if(max > drenched)
					drenched = max;

				if(drenched > 0)
					res[i] = 1;
				else
					res[i] = 0;
				drenched--;
			}

			for(int i=0; i<res.length; i++)
				System.out.print(res[i] + " ");
		
		System.out.println();
		}

	}
}