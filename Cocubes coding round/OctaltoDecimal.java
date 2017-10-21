/*Given, 
int OctalToDecimal(int n);
The function takes an integer number, each of whose digits lies between 0 to 7, thus forming an octal number, as input.
Implement the function to return its decimal equivalent. Write program to convert the octal number to its decimal equivalent as follows:-
Multiply each digit of the octal number starting with the right most digit and moving leftwards, with increasing powers of 8 starting with 80.
Example:
Input:
127

Output:
87

Explanation:
While converting 127 to its decimal equivalent, we start from the right, multiplying 
7 * 80 = 7
2 * 81 = 16
1 * 82 = 64

Adding up the results together, we get 7 + 16 + 64 = 87, which is the output.
*/


import java.util.Scanner;

public class OctaltoDecimal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		p = octDec(c);
		System.out.print(p);
	
	}

public static int octDec(int n)
{
      int i = 0, r, p, s = 0;
      while(n>0)
{             
r = n % l0;
p = pow(8, i);
s = s+p * r;
i++;
n = n/10;
}
return s;

}

}