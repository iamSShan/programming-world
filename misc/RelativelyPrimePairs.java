// Problem: http://codeforces.com/problemset/problem/1051/B?csrf_token=bbe65d7ac9b1c03bf53b50173a5742f6

import java.util.*;

class RelativelyPrimePairs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long l = sc.nextLong();
		long r = sc.nextLong();

		System.out.println("YES");
		for(long i=l; i<r; i+=2) {			
			// System.out.println((i) + ' ' + (i+1));
			System.out.println(i + " " + (i+1)); // Don't use ' ' as it will add ascii value here
		}
	}
}