/* Program:
 A sequence is said to be progressive if it doesn’t decrease at any point in time. 
For example 1 1 2 2 is a progressive sequence but 1 2 1 is not a progressive sequence. 
S is the sequence and be represented by L spaced integers Ki

Our task is to find out the first longest progressive sequence present in the given sequence (S)

Input: 4 1 1 2 1

Output: 112
*/
import java.util.ArrayList;
import java.util.Scanner;
 
public class LongestProgressiveSequence {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Integer> lon = new ArrayList<Integer>();
        Integer[] temp = new Integer[0];
        for (int i = 0; i < t; i++) {
            int num = sc.nextInt();
            if (!(lon.isEmpty())) {
                if (num >=lon.get(lon.size()-1 )) {
                     
                    lon.add(num);
                } else {
                    
                    if(lon.size()>temp.length)
                    temp=lon.toArray(temp);
                    lon.clear();
                    lon.add(num);
                }
                 
            } else {
                lon.add(num);
            }
        }
       
        if(lon.size()>temp.length)
        {
            temp=lon.toArray(temp);
        lon.clear();
        }
            for (int i = 0; i < temp.length; i++) {
            if(i<temp.length-1)
            System.out.print(temp[i]+" ");
            else
                System.out.println(temp[i]);
 
        }
         
    }
} 
