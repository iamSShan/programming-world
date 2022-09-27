// Problem: http://codeforces.com/problemset/problem/263/A

import java.util.Scanner;

public class BeautifulMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[5][5];
		int i_loc = -1, j_loc = -1;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1) {
					i_loc = i;
					j_loc = j;
				}
			}
		}
		int steps = Math.abs(2-i_loc) + Math.abs(2-j_loc);
		System.out.print(steps);
	}
}