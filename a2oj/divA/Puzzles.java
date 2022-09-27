// Problem: http://codeforces.com/problemset/problem/337/A

import java.util.Scanner;
import java.util.Arrays;

public class Puzzles {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// Input two strings
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] f = new int[m];
		for(int i=0; i<m; i++)
			f[i] = sc.nextInt();

		// We will first sort the array
		Arrays.sort(f);
		
		// Now for each current and nth element from current check smallest
		int min = Integer.MAX_VALUE;
		for(int i=0; i<m-n+1; i++) {
			min = Math.min(min, (f[i+n-1] - f[i])); //[i+n-1] -> n-1 because indexing from 0 and i+ because we need nth element from each current element
		}
		System.out.print(min);
	}
}