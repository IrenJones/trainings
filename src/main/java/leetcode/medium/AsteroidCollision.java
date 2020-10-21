package leetcode.medium;

import java.util.Stack;

public class AsteroidCollision {

	public static void main(String[] args) {
		System.out.println(asteroidCollision(new int[]{8, -8}).length == 0);
		System.out.println(asteroidCollision(new int[]{10, 2, -5}).length == 1);
		System.out.println(asteroidCollision(new int[]{-2, -1, 1, 2}).length == 4);
	}

	public static int[] asteroidCollision(int[] asteroids) {
		// guard condition
		if(asteroids.length < 2) {
			return asteroids;
		}

		Stack<Integer> stack = new Stack<>();
		stack.push(asteroids[0]);
		int index = 1;
		boolean skip = false;
		while(index < asteroids.length) {
			skip = false;
			while(!stack.isEmpty() && asteroids[index] < 0 && stack.peek() > 0) {
				if(Math.abs(stack.peek()) < Math.abs(asteroids[index])) {
					stack.pop();
					continue;
				} else if (stack.peek() == - asteroids[index]){
					stack.pop();
				}
				skip = true;
				break;
			}
			if(!skip) {
				stack.push(asteroids[index]);
			}
			index++;
		}

		return stack.isEmpty() ? new int[0] :
				stack.stream()
				.mapToInt(v -> v)
				.toArray();
	}
}
