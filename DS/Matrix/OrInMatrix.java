// https://codeforces.com/problemset/problem/486/B

import java.util.*;

public class OrInMatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Inputs
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] b = new int[m][n];
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				b[i][j] = sc.nextInt();

		// First matrix from which b is formed
		int[][] a = new int[m][n];
		// Step 1- Make all elems in this matrix as 1
			for(int i=0; i<m; i++)
				for(int j=0; j<n; j++)
					a[i][j] = 1;

		// Step 2- For any bij = 0, make each respective row and column as 0
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(b[i][j] == 0){
					// Make current rows of a: 0
					for(int k=0; k<m; k++)
						a[k][j] = 0;
					// Make current cols of a: 0
					for(int k=0; k<n; k++)
						a[i][k] = 0;
				}
			}
		}
		// Step 3: We need to check can we produce B from A, so we will use rules in ques to create a new matrix and will compare it with B
		int[][] c = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j] == 1){
					// Make current rows of a: 1
					for(int k=0; k<m; k++)
						c[k][j] = 1;
					// Make current cols of a: 1
					for(int k=0; k<n; k++)
						c[i][k] = 1;
				}
			}
		}

		// Step 4: Now compare C and B to check if there are equal
		int flag = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(c[i][j] != b[i][j]){
					flag = 1;
					break;
				}
			}
			if(flag == 1)
				break;
		}
		if(flag == 1)
			System.out.println("NO");
		else {
			System.out.println	("YES");
			// Also print original array
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}