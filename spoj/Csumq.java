// https://www.spoj.com/problems/CSUMQ/
// Solved using partial sum(cummulative sum) method

import java.util.Scanner;

class Csumq {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =	sc.nextInt();
		int[] A = new int[N];
		int[] csum = new int[N+1];
		for(int i=0; i<N; i++)
			A[i] = sc.nextInt();

		// Creating cummulative sum array, where first element is 0
		csum[0] = 0;
		for(int i=1; i<=N; i++)
			csum[i] = csum[i-1] + A[i-1];
		// [0, 1, 5, 6]

		int Q = sc.nextInt();
		for(int k=0; k<Q; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int out = csum[j+1] - csum[i]; // Do dry run for understanding
			System.out.println(out);
		}
	}
}