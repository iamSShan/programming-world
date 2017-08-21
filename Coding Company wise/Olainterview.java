// WAP to sort array in ascending order such that v is min
	// v is sum(position of elem in given array * position of elem in sorted array)
	//output sorted array and v

//Asked at Ola Cabs

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OlaInterview {
	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int arr[]=new int[n];
HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
int v=0;
	for(int i=0;i<n;i++){
		arr[i]=sc.nextInt();
	}
	int []srr=new int[n];
	
	for(int j=0;j<n;j++)
	srr[j]=	arr[j];
	
	Arrays.sort(arr);
	for(int i=0;i<n;i++){
		
		for(int j=0;j<n;j++){
			if (arr[j]==srr[i]){
				v=v+(i*j);
				if(!hm.containsKey(srr[i]))
					hm.put(srr[i], v);
			}
		}
	}
	System.out.println("the sum is "+v);
	for(Map.Entry i:hm.entrySet()){
		System.out.println(i.getKey());
		
	}
}}
