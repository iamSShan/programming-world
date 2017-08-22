//Adobe coding interview question

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Substringvowcons {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		LinkedList<Character> vow=new LinkedList<Character>();
		LinkedList<Character> conso=new LinkedList<Character>();
		LinkedList<String> s=new LinkedList<String>();
		int i,j;
		while(t>0){
			String str=sc.next();
	for(i=0;i<26;i++){
		conso.add((char)(97+i));
	}
	conso.remove(new Character('a'));
	conso.remove(new Character('e'));
	conso.remove (new Character('i'));
	conso.remove(new Character('o'));
	conso.remove(new Character('u'));
	vow.add('a');
	vow.add('e');
	vow.add('i');
	vow.add('o');
	vow.add('u');
	for(i=0;i<str.length();i++){
		if(vow.contains(str.charAt(i))){
			for(j=i+1;j<str.length();j++){
				if(conso.contains(str.charAt(j))){
					s.add(str.substring(i,j+1));
				}
			}
		}
	}
	Collections.sort(s);
	if(s.size()==0)
		System.out.println("None");
	else
	{	System.out.println(s.get(0));
		System.out.println(s.get((s.size()-1)));   }
t--;}
	}

}
