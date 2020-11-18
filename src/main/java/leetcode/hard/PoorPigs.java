package leetcode.hard;

public class PoorPigs {

	public static void main(String[] args) {
		System.out.println(poorPigs(4, 15, 15));
		System.out.println(poorPigs(8, 15, 15));
		System.out.println(poorPigs(1000, 15, 60));
	}

	public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		int T = minutesToTest / minutesToDie;
		return (int) Math.ceil(Math.log10(buckets) / Math.log10(T + 1));
	}
}
