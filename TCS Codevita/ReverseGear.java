//CodeVita Season 4 Round 1

import java.util.Scanner;
public class ReverseGear {

	public static void main(String[] args) {
		Scanner aa=new Scanner(System.in);
		int n=aa.nextInt();  		 //number of test cases
 while(n>0){
  int f=aa.nextInt();
  int b=aa.nextInt();
  int t=aa.nextInt();
  int d=aa.nextInt();
  int re,x=0;
int f1=f,b1=b;
	while(b1<d){
		re=b1-f1;
		x=x+(b*t +  f*t);
		b1=re+b;
	}
	if(b1==d)
	x=x+(b*t);
	else{
		x=x+((d-(b1-b))*t); 		 //(d- one step previous b1)*time
	} 
System.out.print(x);
n--;
 }
	}

}
