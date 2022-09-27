import java.util.Scanner;

class Print1toN {
	
	public static void printTillN(int n) {
		/*
		If we call print(n) -> it should give 1 to n
		If we call print(n-1) -> it should give 1 to n-1
		
		For example:
		print(7) will give -> 1 to 7
		print(6) will give -> 1 to 6; so after this if we just print 7 afterwards we can get 1 to 6 and 7
		*/
		// Base condtion: smallest valid output
		if(n == 1) {
			System.out.print(1 + " ");
			return;
		}
		// Hypothesis step(Basically it means what we are designing) (a generalized function)
		printTillN(n-1);
		// Induction step
		System.out.print(n + " ");

	}

	public static void printTill1(int n) {
		/*
		If we call print(n) -> it should give n to 1
		If we call print(n-1) -> it should give n-1 to 1

		For example:
		print(7) will give -> 7 to 1
		print(6) will give -> 6 to 1; so after this if we just print 7 before we will get 7 and then 6 to 1
		*/
		// Base condtion: smallest valid output
		if(n == 1) {
			System.out.print(1 + " ");
			return;
		}
		System.out.print(n + " ");
		printTill1(n-1);

	}

	public static void main(String[] args) {
		System.out.println("Enter n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// Print 1 to n
		printTillN(n);
		// Print n to 1
		System.out.println();
		printTill1(n);

	}
}