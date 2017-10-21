// WAP to Count set bits in a Integer
/*Input : n = 6
Output : 2
Binary representation of 6 is 110 and has 2 set bits

Input : n = 13
Output : 3
Binary representation of 11 is 1101 and has 3 set bits
*/
// Asked in Adobe, QualComm 

import java.util.Scanner;

public class Nthmagicno { //can be expressed as a power of 5 like 5,25, 30(25+5), 123,130(125+5)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = countsetbits(n);
		System.out.println("No. of set bits are "+cnt);
	}
public 	static int countsetbits(int n){
int count = 0;
  while (n != 0)
  {
    count += n & 1;
    n >>= 1;
  }
  return count;
  }
}