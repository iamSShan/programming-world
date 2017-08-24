//Yahoo interview set 4th question
//Wap to find amicable pairs(done in Java)


import java.util.Scanner;
public class AmicablePairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		System.out.println(countamicpairs( arr,n));
	}
static int sumofdiv(int x){
	int sum=1;
	for(int i=2;i<=Math.sqrt(x);i++){
		if(x%i==0){
			sum+=i;
			if(x/i!=i) // to handle perfect squares
				sum=sum+x/i;
		}
		}
	return sum;
	}
static boolean isamicable(int a ,int b){
	return (sumofdiv(a)==b & sumofdiv(b)==a);
}
static int countamicpairs(int ar[],int a){
	int count=0;
	for(int i=0;i<a;i++)
		for(int j=i+1;j<a;j++)
			if(isamicable(ar[i],ar[j]))
				count++;
	return count;
}
}
