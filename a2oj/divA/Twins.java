// Problem: http://codeforces.com/problemset/problem/160/A

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Twins {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i <n; i++) {
			a[i] = sc.nextInt();
		}
		
		/* We will calculate sum of the array first
		   Then we will sort the list in descending order and then subtract one elements from orig array and add it to sum 
		   until sum of elements is greater than remaining list sum
		*/
		
		int coin_values = 0;
		for(int i=0; i<n; i++) {
			coin_values += a[i];
		}
		// Sort array in reverse order
		Arrays.sort(a);
		// Now iterate again
		int my_coins = 0;
		int count = 0;
		for(int i=n-1; i >=0 ; i--) {
			coin_values = coin_values - a[i];
			my_coins += a[i];
			count++;
			if(my_coins > coin_values)
				break;
		}
		System.out.println(count);
	}
}