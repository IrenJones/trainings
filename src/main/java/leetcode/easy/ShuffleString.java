package leetcode.easy;


import static org.apache.commons.lang3.ArrayUtils.swap;

public class ShuffleString {
	public static void main(String[] args) {
		System.out.println(restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
		System.out.println(restoreStringCyclingSort("codeleet", new int[]{4,5,6,7,0,2,1,3}));
	}

	public static String restoreString(String s, int[] indices) {
		char[] arr = new char[indices.length];
		for(int i=0; i< s.length(); i++){
			arr[indices[i]] = s.charAt(i);
		}
		return String.valueOf(arr);
	}

	public static String restoreStringCyclingSort(String s, int[] indices) {
		char[] cs = s.toCharArray();
		for(int i=0; i< indices.length; i++){
			while(indices[i] != i) {
				swap(cs, i, indices[i]);
				swap(indices, i, indices[i]);
			}
		}
		return String.valueOf(cs);
	}
}
