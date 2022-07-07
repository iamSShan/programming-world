import java.util.*;

class test {
	public static void main(String[] args) {
		int [] arr = {1, 2, 1, 1, 2, 3};
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // obj = {}
		// int count =0;
		// for(int i=0; i<arr.length; i++) {
		// 	count = 1;
		// 	for(int j=i+1; j<arr.length; j++) {
		// 		if(arr[i] == arr[j]) {
		// 			count ++;
		// 		}
		// 	}
		// 	if(!hm.containsKey(arr[i]))
		// 	hm.put(arr[i], count);
		// }
		// System.out.println(Arrays.asList(hm));

		for(int i=0; i<arr.length; i++) {
			if(!hm.containsKey(arr[i]))
				hm.put(arr[i], 1);
			else {
				int count = hm.get(arr[i]);
				hm.replace(arr[i], count+1);
			}

		}
		System.out.println(Arrays.asList(hm));

	}
}