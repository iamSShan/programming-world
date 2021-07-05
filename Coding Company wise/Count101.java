// Samsung interview question
// Enter String and Count 101 occurrences

import java.util.Scanner;
public class Count101 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, count = 0;
		String str = sc.next();

		boolean flag = false;
		for(i=0; i<str.length(); i++) {
			// If 1 is encountered 1st time then make flag = true
			if(str.charAt(i) == '1' && flag == false)
				flag = true;
			// If 0 is there
			else if(str.charAt(i) == '0') {
				// If last element was 1 then only proceed else make flag false
				if(flag == true && str.charAt(i-1) != '1')
					flag = false;
			}

			// If second `1` occurs
			else if(str.charAt(i) == '1' && flag == true){
				// Check last char should be 0 only then only increase count
				if (str.charAt(i-1) == '0')
					count++;
			}
			// If any other char apart from 0 or 1 occurs then make flag = false
			else if(str.charAt(i)!='1'&&str.charAt(i)!= '0')
				flag = false;
			
		}
		System.out.print(count);
	}

}
