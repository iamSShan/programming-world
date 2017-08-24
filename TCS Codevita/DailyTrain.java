//CODEVITA ROUND 1

import java.util.*;
public class Dailytrain {
 public static void main(String[] args){
int i,count=0;
	Scanner scan=new Scanner(System.in);
	int q=scan.nextInt();
	while(q!=-1){
	
	int n=scan.nextInt();
	int c[]=new int[n];
	for(i=0;i<n;i++){
		c[i]=scan.nextInt();
	}
	
for(int j=0;j<n;j++){
	if(c[j]!=0){
		count++;
	}	}
	
		if(count%2==0)
		{int a=0;
		a=a+1;
			System.out.print(a);
		}
		else{
			System.out.print("0");
		}
	
	q--;
}
}}