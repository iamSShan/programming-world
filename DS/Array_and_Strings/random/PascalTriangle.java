/* https://leetcode.com/problems/pascals-triangle/
This ques may be asked in three ways:
1) we are given n=5 and we have to print first 5 rows
2) we are given just a row number, then we have to just print 5th row
3) we are given row number and column number, then for row 'r' we have to print column 'c' element

We can see how pascal triangle is formed in leetcode problem statement
Also at nth, n columns are present

Solution:

*/
class PascalTriangle {

	public static void solve1(int n) {
		/* 
				  1
		        1   1
		      1   2   1
		    1   3   3   1
		  1   4   6   4   1
		1   5   10   10   5   1
	
		We can use nCr formula to calculate at each instance

	     		  0C0
		       1C0   1C1
		    2C0   2C1   2C2
		3C0   3C1   3C2   3C3
		  .....

		*/
		
	}

	public static void main(String[] args) {
		// https://www.geeksforgeeks.org/java-program-to-print-pascals-triangle/
		solve1(5); 
	}
}