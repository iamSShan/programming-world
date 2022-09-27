/*
 - In a grid we have to go from (0,0) to (m-1, n-1) and checks how many possible paths are there
 - We can either go right or bottom
*/

import java.util.Scanner;

class pathsInNxMGrid {
	
	public static int findPaths(int n, int m) {
		/* 1. Here first we have to find base condition(so think of simplest possible input for this function)
		   * When we just have one cell can be base condition then only 1 path
		    __
		   |  |
		   ----
		
           * If we have 1 row(n=1) and three columns(m=3) then also single path is there
			__ __      
		   |  |  |
		   -------

		   * If we have 3 rows(n=3) and 1 column(m=1) then also single path is there
		    __
		   |  |
		   ----
		   |  |
		   ----
		   |  |
		   ----
		     
		*/
		if(n == 1 || m== 1) // sum will be 1(cannot take 0 as sum of natural numbers is asked)
			return 1;
		
		// If we can come to last row or column then from there only 1 path is to be added for each
		// (3,4) + (4,3) // Recursive leap of faith
		
		// 3. General function for above relation can be:
		// findPaths(n, m-1) + findPaths(m, n-1)
		return findPaths(n, m-1) + findPaths(m, n-1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int s = findPaths(n, m);
		System.out.println(s);

	}
}