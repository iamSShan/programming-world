//Microsoft through cocubes
//max number of contiguous 1 in string like 0110111110111101 o/p =5

import java.util.Scanner;
import java.util.Stack;
public class MaxlenofString {  

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String s=scan.nextLine();
		Stack<Character> st =new Stack<Character>();
	int i,a=0,cnt=0;
	for(i=0;i<s.length();i++){
		if(s.charAt(i)=='1'){                                //concept kind of Kadane's algo
			st.push(s.charAt(i));
			a++;
		}
		if(s.charAt(i)=='0'){
			if(a>cnt)
			cnt=a;
			a=0;
		}
	}
	
	System.out.println(cnt);
	}

}
