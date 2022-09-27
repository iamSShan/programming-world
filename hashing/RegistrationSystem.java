// Problem: https://codeforces.com/problemset/problem/4/C

import java.util.Scanner;
import java.util.HashMap;

public class RegistrationSystem {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[n];
		for(int i=0;i<n; i++)
			arr[i] = sc.nextLine();

		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		for(int i=0; i<n; i++) {
			if(hm.containsKey(arr[i])) {
				// Fetch current value
				int val = hm.get(arr[i]);
				val = val+1;
				String v = Integer.toString(val);
				System.out.println(arr[i]+v);
				hm.put(arr[i], val);
			}
			else {
				hm.put(arr[i], 0);
				System.out.println("OK");
			}
		}

		
	}
}