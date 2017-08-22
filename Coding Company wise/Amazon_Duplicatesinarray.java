//Amazon coding round
//Wap to input an array and count all elements which are repeated and how many times they get repeated

import java.util.Scanner;

public class DuplicatesinArray {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int i,j,cnt=0;
		int arr[]=new int[n];
		for( i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
for(i=0;i<n;i++){
	for(j=i+1;j<n;j++){
		if(arr[i]==arr[j]){
			cnt++;
			System.out.println("elem repeated is "+arr[i]);
			break;
		}
	}
}
	System.out.println("no. of repeated elem are"+ cnt);
	}
	
}
