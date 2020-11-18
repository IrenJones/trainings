package leetcode.medium;

public class MirrorReflection {

	public static void main(String[] args) {
		System.out.println(mirrorReflection(2, 1) == 2);
	}

	public static int mirrorReflection(int p, int q) {
		int m = 1, n = 1;
		while (m * p != n * q) {
			n++;
			m = (n * q) / p;
		}
		if (m % 2 == 1 && n % 2 == 1) {
			return 1;
		}else if (m % 2 == 1 && n % 2 == 0) {
			return 2;
		}
		return 0;
	}
}
