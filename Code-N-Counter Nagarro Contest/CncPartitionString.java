import java.util.Scanner;

//Nagarro Code-N-Counter 2.0   
public class CncPartitionString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		//String max="";
		int i,count=1,sum=0;
		for(i=1;i<str.length();i++){
			//max=max+str.charAt(i);
			if(str.charAt(i)==str.charAt(i-1))
				count++;
			if(count>sum)
				sum=count;
			if(str.charAt(i)!=str.charAt(i-1))
				count=1;
					
		}
	System.out.println(sum);
	}
}

