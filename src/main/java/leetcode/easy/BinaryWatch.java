package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryWatch {

	public static void main(String[] args) {
		BinaryWatch solution = new BinaryWatch();
		solution.readBinaryWatch(6);
	}

	public List<String> readBinaryWatch(int num) {

		if (num == 0) {
			return Arrays.asList("0:00");
		}

		List<String> res = new ArrayList<>();

		Map<Integer, List<String>> hours = new HashMap<>();
		for (int i = 0; i < 12; i++) {
			int leds = calculateCountOfLeds(i);
			if(leds <= num) {
				List<String> hoursStr = hours.getOrDefault(leds, new ArrayList<>());
				hoursStr.add(String.valueOf(i));
				hours.put(leds, hoursStr);
			}
		}

		Map<Integer, List<String>> minutes = new HashMap<>();
		for (int i = 0; i < 60; i++) {
			int leds = calculateCountOfLeds(i);
			if(leds <= num) {
				List<String> minStr = minutes.getOrDefault(leds, new ArrayList<>());
				minStr.add( i < 10 ? "0" + i : String.valueOf(i));
				minutes.put(leds, minStr);
			}
		}

		for(Map.Entry<Integer, List<String>> hour : hours.entrySet()) {
			int hourLeds = hour.getKey();
			List<String> possibleHours = hour.getValue();
			if(minutes.containsKey(num - hourLeds)) {
				List<String> possibleMinutes = minutes.get(num - hourLeds);

				for (String h : possibleHours) {
					for (String m : possibleMinutes) {
						res.add(h + ":" + m);
					}
				}
			}
		}

		return res;
	}

	private int calculateCountOfLeds(int number) {
		if(number == 0) {
			return 0;
		}

		int count = 0;

		for(int d = 32; d >= 1; d = d / 2) {
			if (number - d >= 0) {
				count++;
				number -= d;
			}
		}

		return count;
	}
}
