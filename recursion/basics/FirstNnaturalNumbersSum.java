import java.util.Scanner;

class FirstNnaturalNumbersSum {
	
	public static int sum(int n) {
		// 1. Here first we have to find base condition(so think of simplest possible input for this function)
		if(n == 1) // sum will be 1(cannot take 0 as sum of natural numbers is asked)
			return 1;
		
		// 2. Find the relation: How larger problem can be solved with help of the solution of the smaller problem
		// if n=4; we have 1+2+3 somehow, then we can just add 4 to it 
		
		// 3. General function for above relation can be:
		// sum(n-1) + n = sum(n)
		return n + sum(n-1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sum(n);
		System.out.println(s);

	}
}