// https://codeforces.com/problemset/problem/282/A

import java.util.*;

public class BitPlusPlus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int x = 0;
		for(int i=0; i<n; i++) {
			 String s1 = sc.nextLine();
			 if(s1.charAt(0) == '+' || s1.charAt(s1.length()-1) == '+')
			 	x += 1;
			 else if(s1.charAt(0) == '-' || s1.charAt(s1.length()-1) == '-')
			 	x -= 1;
		}
		System.out.print(x);
	}
}