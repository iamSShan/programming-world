// Problem: https://leetcode.com/problems/long-pressed-name/

class LongPressedName {


	public static boolean isLongPressedName(String name, String typed) {
		if(name.charAt(0) != typed.charAt(0))
			return false;

		int i=1, j=1;
		while(i<name.length() && j < typed.length()) {
			
			// When both have same character just increase the pointer at an index
			if(name.charAt(i) == typed.charAt(j)) {
				i++;
				j++;
			}
			// When both doesn't have same character at an index, just check whether typed last character was also same or not
			else if(typed.charAt(j) == typed.charAt(j-1)) {
				j++;
			}
			else {
				return false;
			}
		}

		// Now three cases can be seen:
		//Case 1 : i and j both reached end of the String
		if(i == name.length() && j == typed.length())
			return true;
		// Case 2: if `name` is not completed but `typed` is completely traversed
		else if(i != name.length() && j == typed.length())
			return false;
		
		// Case 3: if `name` is completely traverse but not `typed` then we have to check whether all chars are same or not as current
		else {
			while(j != typed.length()) {
				if(typed.charAt(j) == typed.charAt(j-1))
					j++;
				else
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str1 = "leelee";
		String str2 = "lleeelee";
		System.out.print(isLongPressedName(str1, str2));
	}
}