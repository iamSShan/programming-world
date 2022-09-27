// Problem: https://codeforces.com/problemset/problem/266/B

import java.util.Scanner;
import java.util.Arrays;

public class QueueattheSchool {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		char[] arr = s.toCharArray();
		for(int i=0; i<t; i++) {
			for(int j=arr.length-1; j>0; j--) {
				if(arr[j] == 'G' && arr[j-1] == 'B') {
					arr[j] = 'B';
					arr[j-1] = 'G';
					j--;
				}
			}
		}
		System.out.println(String.valueOf(arr));
	}
}