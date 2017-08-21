//wap to find nth magic no.
/* magic no. is a number which can be expressed as a power of 5 
like 5 ,  25 ,  30(25+5),  125, 130(125+5),etc   */


import java.util.Scanner;

public class Nthmagicno { //can be expressed as a power of 5 like 5,25, 30(25+5), 123,130(125+5)

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int pow=1,ans=0;
		while(n>0){			//go through every bit
		pow*=5;  
		int y=n & 1; 			//if last bit of n is set
		if(y>0)
			ans=ans+pow; 
		n>>=1; 				//or n=n/2  //proceed to next bit  
		}
		System.out.println(ans);
	}

}
