/* https://leetcode.com/problems/set-matrix-zeroes/
First question to be asked is: Does matrix contains only positive elements?
If yes, then one solution can be:
Whenever we find 0, we traverse for entire row and then traverse for entire column and make values as some value like -1(which doesn't exist in matrix)
We won't be updating 0, because 0 might affect some other row and column, we might miss out some values.
Here Time complexity: O(NxM) x (N+M); O(N+M) is for traversing in array and O(N+M) if for traversing in entire row and column inside two loops
Space complexity: O(1)

Let's stay it can have negative values or we have to optimize it

Solution 2: 
- We take two temp arrays, first array is size of columns and second is size of rows.
- We linearly traverse in matrix, so whenver we find 0, we simply set 0 in column and row index of temp array
- When we are setting 0 in temp array, and they have already been set previously then we ignore it.
- Now again we will traverse in matrix, for every index like (0,1) we will look 0 index row temp array and 1 index of column temp array, if any of it has zero in temp array then update matrix cell as 0
- Similary we do this for each cell
- Time Complexity: O(2 x NxM) // Because we linearly traverse the array twice
- Space Complexity: O(N) + O(M)

Solution 3(Most optimized approach to reduce space complexity):
- It is a better version of Solution 2
- Here we will take temp array inside matrix only: First row will be column temp array, and first column as row temp array
- Then we take a `col` variable intialized with true
- We take `col` true because: https://www.youtube.com/watch?v=M65xBewcqcI&t=368s
- Then look at https://www.geeksforgeeks.org/a-boolean-matrix-question/
*/
class SetMatrixZeros {

	public static void setMatrix(int[][] mat) {
		// These are used to check if we have got 0 at first row and first column
		boolean row_flag = false;
		boolean col_flag = false;

		// Updating first row and column if 0 is found
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				if(i==0 && mat[i][j] == 0)
					row_flag = true;
				if(j==0 && mat[i][j] == 0)
					col_flag = true;
				// If any element apart from elements in row 1 and col 1 are 0 then make row 1 and col 1 as 0  
				if(mat[i][j] == 0) {
					mat[i][0] = 0;
					mat[0][j] = 0;
				}
			}
		}
		// Now we have to modify remaining matrix(except 1st row and 1st column on basis of 1st row and 1 column)
		for (int i=1; i<mat.length; i++) {
            for (int j=1; j<mat[0].length; j++) {
            	if (mat[0][j] == 0 || mat[i][0] == 0)
            		mat[i][j] = 0;
			}
        }

        // Now modify first row and column
        if(row_flag == true) {
        	for(int i=0; i<mat[0].length; i++) {
        		mat[0][i] = 0; // first row is getting modified hence 0 is written in row and i in j
        	}
        }
        if(col_flag == true) {
        	for(int j=0; j<mat.length; j++) {
        		mat[j][0] = 0;
        	}
        }

	}

	public static void printMatrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                System.out.print( mat[i][j] );
            }
                System.out.println("");
        }
    }
    

	public static void main(String[] args) {
		int mat[][] = {{1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 0, 0, 1}};
		System.out.println("Original Matrix:");
		printMatrix(mat);
		setMatrix(mat);
		System.out.println("Set Matrix: ");
        printMatrix(mat);
	}
}