package leetcode.medium;

public class RobotBoundedInCircle {
	public boolean isRobotBounded(String instructions) {
		int i = 0;
		int j = 0;

		int[][] directions = {
				{0, 1},
				{1, 0},
				{0, -1},
				{-1, 0}
		};

		int currentD = 0;
		char current;
		for (int index = 0; index < instructions.length(); index++) {
			current = instructions.charAt(index);
			if (current == 'G') {
				i += directions[currentD][0];
				j += directions[currentD][1];
			} else if (current == 'L') {
				currentD = (currentD + 1) % 4;
			} else {
				currentD = (currentD + 3) % 4;
			}
		}
		return i == 0 && j == 0 || currentD > 0;
	}
}
