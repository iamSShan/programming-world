// https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/

class CheckIfRotationOfEachOther {
	

	public static void main(String[] args) {
		String s1 = "ABCD";
		String s2 = "CDAB";

		String temp = s1+s1;

		System.out.print(temp.contains(s2));
	}
}