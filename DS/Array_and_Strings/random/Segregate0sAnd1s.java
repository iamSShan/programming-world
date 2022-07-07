class Segregate0sAnd1s {
	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		int l = 0, r = arr.length-1;
		
		while(l<r) {
			if(arr[l] == 0)
				l++;
			else if(arr[l] == 1) {
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				r--;
			}
		}
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}