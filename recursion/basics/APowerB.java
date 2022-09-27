import java.util.Scanner;

class APowerB {
	
	static int counter = 0;
	public static int power(int a, int b) {
		counter++;
		// 1. Here first we have to find base condition(so think of simplest possible input for this function)
		// E.g 5^4 = 5*5*5*5 = 625 
		if(b == 0) // 5^0 = 1(simplest power)
			return 1;
		
		// 2. Find the relation: How larger problem can be solved with help of the solution of the smaller problem
		// if a=5 and b=4; we have 5*5*5 somehow(it is called recursive leap of faith), then we can just multiple 5 to it 
		
		// 3. General function for above relation can be:
		// 5^4 = 5 * 5^3 
		return  a * power(a, b-1);
	}

	public static int power_improved(int a, int b) {
		counter++;
		/* a^b can be written as (a^(b/2))^2  or (a^2)^(b/2)
		   Now instead of O(n) we can solve it on O(logn)
		   If we have 3^2, then we can find (3^2)^2 = 3^4
		   If we have to find 3^7 using 3 * 3^6; and 3^6 can be calculated as (3^2)^3
		   So in b=odd case we are also multiplying with extra `a`

		   3^6 = (3^2) ^ 3  = (3^2) ^ 6/2 
		   3^7 = 3*(3^2)^3 = 3* 3^6  
		   General function for above relation can be:
		   if b is even: power(a^2, b/2)
		   if b is odd: a*power(a^2, b-1)
		*/ 

		// Base case
		if(b == 0) // 5^0 = 1(simplest power)
			return 1;
		
		if(b%2 == 0)
			return power_improved(a*a, b/2);

		return a*power_improved(a, b-1);
		
	}

	public static void main(String[] args) {
		System.out.println("Enter two integers: ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		// Here we calling b times
		System.out.println(power(a, b));
		System.out.println("Steps count: " + counter);

		// Improvement of power function
		counter = 0;
		System.out.println(power_improved(a, b));
		System.out.println("Steps count: " + counter);
	}
}