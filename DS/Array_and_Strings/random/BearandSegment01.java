// Problem: https://www.codechef.com/problems/SEGM01

import java.util.*;

class Codechef {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while(T-- > 0) {
            String S = sc.nextLine();
            int i1, i2;
            int flag = 0;
            int i;
            for(i=0; i<S.length(); i++) {
                if(S.charAt(i) == '0' && flag == 1)
                    flag = 2;
                else if(S.charAt(i) == '1' && flag == 0) {
                    flag = 1;
                }
                // It means flag had 1 before then current value is 2
                else if(flag == 2 && S.charAt(i) == '1') {
                    flag = 0;
                    break;
                }
        }
        if(flag > 0)
            System.out.println("YES");
        else
            System.out.println("NO");
        }
    }
}
