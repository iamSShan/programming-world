//or find majority element 

import java.util.Scanner;
import java.util.HashMap;
public class MaxVotes {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
int i;
int n=sc.nextInt();
int []arr=new int[n];
for(i=0;i<n;i++){
	arr[i]=sc.nextInt();
}
HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
for(i=0;i<n;i++){
if(map.containsKey(arr[i]))
{
	int count=map.get(arr[i])+1;
		if(count>n/2)
			{System.out.println(arr[i]);
		return;}
		else
			map.put(arr[i], count);
		}
else
	map.put(arr[i], 1);

}
System.out.println("none");
}

}
