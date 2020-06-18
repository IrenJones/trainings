package structures.leetcode_easy.string;

public class ReverseString {
	public static void main(String[] args) {
		char[] arr = new char[]{'H', 'e', 'l', 'l'};
		reverseString(arr);
		System.out.println(String.valueOf(arr));
	}
	public static void reverseString(char[] s) {
		// Do not allocate extra space for another array,
		// you must do this by modifying the input array in-place with O(1) extra memory.
		char tmp;
		int i = 0;
		int j = s.length -1;
		while(i < j){
			tmp = s[i];
			s[i] = s[j];
			s[j] = tmp;
			j--;
			i++;
		}
	}
}
