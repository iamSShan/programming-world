// Problem: http://codeforces.com/problemset/problem/318/A

import java.util.Scanner;

public class EvenOdds {
	
	static long getElemAtK(long n, long k) {
		long elem;
		long pos;
		// Till how much we will observe, for even elements, we will observe n elements and for odd we will observe n+1 elements
		if(n%2 == 0)
			pos = n/2;
		else
			pos = (n/2)+1;

		// For odd
		if(k<=pos)
			elem = (2*k)-1;
		
		// For even
		else
			elem = (k-pos)*2;
		
		return elem;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();
		System.out.print(getElemAtK(n, k));
	}
}