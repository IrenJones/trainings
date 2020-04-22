import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Testick {
	public static void main(String[] args) {
		//relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6});
		//relativeSortArray(new int[]{28,6,22,8,44,17}, new int[]{22,28,8,6});
		relativeSortArray(new int[]{943,790,427,722,860,550,225,846,715,320}, new int[]{943,715,427,790,860,722,225,320,846,550});
		System.out.println(Integer.MAX_VALUE);
		twoSum(new int[]{2, 5, 5, 11}, 10);
		twoSumMoreSuitable(new int[]{2, 5, 5, 11}, 10);
		System.out.println(reverse(-13));
		System.out.println(reverse(1200));

		System.out.println(reverseForBigIntegers(1200));
		System.out.println(reverseForBigIntegers(1534236469));
		notString("not bad");
		Map<String, Integer> result = calculateCount("cat cat ctatat got got hat 234 fo");
		for (Map.Entry<String, Integer> e : result.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}
		System.out.println("Hello world");
	}

	public static String notString(String str) {
		if (str.length() >= 3) {
			if (str.substring(0, 2).equals("not")) {
				return str;
			}
		}
		return "not " + str;
	}

	public static Map<String, Integer> calculateCount(String str) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] strings = str.split(" ");
		for (String s : strings) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}
		return map;
	}

	public static int[] twoSum(int[] nums, int target) {
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static int[] twoSumMoreSuitable(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		int diff;
		for (int i = 0; i < nums.length; i++) {
			diff = target - nums[i];
			if (map.containsKey(diff) && map.get(diff) != i) {
				return new int[]{i, map.get(diff)};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	// not for big integers - overflow
	public static int reverse(int x) {
		StringBuilder s = new StringBuilder(String.valueOf(Math.abs(x)));
		Integer res = Integer.valueOf(s.reverse().toString());
		return x < 0
				? -1 * res
				: res;
	}

	public static int reverseForBigIntegers(int x) {
		int input = Math.abs(x);
		int res = 0;
		int diff;
		while (input > 0) {
			diff = input % 10;
			if (res > Integer.MAX_VALUE / 10 ||
					res == Integer.MAX_VALUE / 10 && diff > 7 ||
					x < 0 && -1 * res < Integer.MIN_VALUE / 10 && diff > 8 ||
					x < 0 && -1 * res == Integer.MIN_VALUE / 10 && diff > 8) {
				return 0;
			}
			res = res * 10 + diff;
			input = input / 10;
		}
		return x < 0
				? -1 * res
				: res;
	}

	public static int[] relativeSortArray(int[] arr1, int[] arr2) {
		Set<Integer> setDist = new LinkedHashSet<Integer>();
		for(int value: arr2){
			setDist.add(value);
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int value : arr1) {
			list.add(value);
		}
		int index = 0;

		Iterator<Integer> looper = setDist.iterator();
		while (looper.hasNext()) {
			Integer v = looper.next();
			Iterator<Integer> it = list.iterator();
			while(it.hasNext()) {
				Integer next = it.next();
				if(setDist.contains(next)) {
					if ( v.equals(next)) {
						arr1[index] = next;
						it.remove();
						index++;
					}
				}
			}
		}
		Collections.sort(list);
		for (Integer integer : list) {
			arr1[index] = integer;
			index++;
		}

		return arr1;
	}
}
