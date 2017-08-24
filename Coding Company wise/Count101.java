// Samsung interview
//Enter String and Count 101

import java.util.Scanner;
public class count101 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i,count=0;
		boolean flag=false;
		int t=sc.nextInt();
		while(t>0){
	String string=sc.next();	
		for(i=0;i<string.length();i++){
			if(string.charAt(i)=='1'&&flag==false)
				flag=true;
			else if(string.charAt(i)!='1'&&string.charAt(i)!= '0')
				flag=false;
			else if(string.charAt(i)=='1'&&flag==true){
				if (string.charAt(i-1)=='0')
					count++;
			}
		}
		System.out.print(count);
		t--;}
	}

}
