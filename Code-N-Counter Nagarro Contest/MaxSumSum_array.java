//Code-N-Counter Season 1  Problem
//Max Sum Sub-array

import java.util.Scanner;

public class MaxSumSub_array {  	// This is also called as Kadane Algorithm 
	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
		int t=sc.nextInt(),i;
		while(t!=0){  //no/ of test cases
			int n=sc.nextInt() ; // size of array
			int c[]=new int[n]; // array
			for(i=0;i<n;i++){
				c[i]=sc.nextInt();
			}
			int maxend=0,maxsofar=0;
			for(i=0;i<n;i++){
				maxend=maxend+c[i];
				if(maxend<0){
					maxend=0;
				}
				if(maxsofar<maxend)
				maxsofar=maxend;
			}
			System.out.println(maxsofar);
			
		t--;}

	}

}
