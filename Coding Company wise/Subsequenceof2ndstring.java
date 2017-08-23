
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Subsequenceof2ndstring {

	public static void main(String[] args)throws IOException {
		//Scanner scan=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
			String str1=br.readLine();
			String str2=br.readLine();
				int a=str1.length();
				int b=str2.length();
	boolean abc=issubseq(str1,str2,a,b);
		if(abc==true)	 System.out.println("yes");
		else 		 System.out.println("no");
	}

static boolean issubseq(String str1,String str2,int a,int b){
	int i,j=0; // j is index of str1
	for(i=0;i<b&&j<a;i++)   	 
		{if(str1.charAt(j)==str2.charAt(i))
			j++;}
	return (j==a) ;//if all char of str1 were found in str2

}
}
