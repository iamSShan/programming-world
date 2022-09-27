// Problem: http://codeforces.com/problemset/problem/122/A

import java.util.Scanner;

public class LuckyDivision {
	
	static String isAlmostLucky(int[] saved_list, int n) {
		for(int i=0; i<saved_list.length; i++) {
			if(n% saved_list[i] == 0) {
				return "YES";
			}
		}
		return "NO";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =	sc.nextInt();
		int[] saved_list = {4, 7, 44, 47, 74, 77, 444, 447, 474, 477, 744, 747, 777};
		System.out.println(isAlmostLucky(saved_list, n));
	}
}