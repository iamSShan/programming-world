//Wap to check whether a expression contains redunctant brackets or not
//Did using Stack

import java.util.Scanner;
import java.util.Stack;

public class RedunctantBrackets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p;
		Scanner sc=new Scanner (System.in);
Stack<Integer>st=new Stack<Integer>();
System.out.print("enter your expression");
String exp=sc.next();
int len=exp.length();
		for(int i=0;i<len;i++){
			char ch=exp.charAt(i);
			if(ch=='('){
				st.push(i);}
			else if(ch==')'){
				try{
			p= st.pop(); //might have too many right braces  so exception chances are there
				}
				catch(Exception e){
				System.out.print("true");
				break;}
			}}
		//System.out.print("')' at index"+(i+1)+"matched with ')'at index"+p);		
	if(st.empty()){
		System.out.print("does not contains");
	}else //too many left braces
		{
			System.out.print("contains redunctant brackets");
		}		}
		
		
	}