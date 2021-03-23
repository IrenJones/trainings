package leetcode.medium;

import java.util.Random;

public class GenerateRandomPointInCircle {
}

class Solution {

	private double r;
	private double x;
	private double y;

	public Solution(double radius, double x_center, double y_center) {
		this.r = radius;
		this.x = x_center;
		this.y = y_center;
	}

	// Math.random() * (max - min + 1) + min;
	public double[] randPoint() {
		double theta = 2 * Math.PI * Math.random();
		double r = this.r * Math.sqrt(Math.random());
		double x = this.x + r * Math.cos(theta);
		double y = this.y + r * Math.sin(theta);
		return new double[]{x, y};
	}
}
