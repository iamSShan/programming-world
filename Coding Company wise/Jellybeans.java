//Visa coding round Hackerrank problem

import java.util.Scanner;

public class Jellybeans {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();//n empty jars
		int m=sc.nextInt(); //no of operations to be performed
		//determine avg no of candies after m operations
	int t=m,ans=0;
	while(t>0){
		int a=sc.nextInt(); //a and b are indices of jars
		int b=sc.nextInt();
		int k=sc.nextInt();//no. of candies to be added in each jar whose index lies between a and b(both inclusive)
		
		ans+=(Math.abs(a-b)+1) *k; //if 4,5,6 then 6-4+1=3(including all three) then 3*k
	t--;
	}
	ans=(int)Math.floor(ans/n); //calc avg
	System.out.println(ans);
	
	}

}
