import java.util.Scanner;
//input = 
/*
size of array= 5
1 2 3 4 5
output= 1.0 1.5 2.0 2.5 3.0 */
public class HouseholdIncomeIndicator {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt(),i,j;
		double mid=0.00;
		int [] arr=new int[n];
		for(i=0;i<n;i++){    //input the array
			arr[i]=sc.nextInt();
		}
		for(i=0;i<arr.length;i++){
	for(j=0;j<=i;j++){
		mid=(arr[0]+arr[j])/2.0;	
			}
	System.out.println(mid);
		}
	}
}
