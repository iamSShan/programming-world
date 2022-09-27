// https://codeforces.com/contest/514/problem/A

import java.util.*;

public class Can {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		char[] str = x.toCharArray();
		
		int dig = str[0] - '0'; // Converting to number
		if(dig == 9)
			str[0] = '9';
		else {
			if(dig > 4)
				str[0] = (char) ((9-dig) + '0');
			else
				str[0] = (char) (dig + '0'); // Converting back to string
		}
		for(int i=1; i<str.length; i++) {
			int d = str[i] - '0';
			if(d < 5 || d == 0)
				continue;
			else
				str[i] = (char) ((9-d) + '0');
		}
		String out = String.valueOf(str);
		System.out.print(out);
	}
}