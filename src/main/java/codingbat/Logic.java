package codingbat;

public class Logic {
	public static boolean makeBricks(int small, int big, int goal) {
		if(small >= goal) {
			return true;
		}else if (goal > small + 5 * big) {
			return false;
		} else if(goal % 5 > small){
			return false;
		}

		return true;
	}

	public int blackjack(int a, int b) {
		if(a > 21 && b > 21){
			return 0;
		} else if (a > 21) {
			return b;
		} else if(b > 21) {
			return a;
		}

		return Math.abs(21 - a) > Math.abs(21 - b) ? b : a;
	}

	public boolean evenlySpaced(int a, int b, int c) {
		int small = Math.min(a, Math.min(b,c));
		int large = Math.max(a, Math.max(b,c));
		int medium = c;

		if(small != a) {
			if(large != a){
				medium = a;
			}
		}
		if(small != b) {
			if(large != b){
				medium = b;
			}
		}
		return medium - small == large - medium;
	}

	public static void main(String[] args) {
		makeBricks(3, 2, 9);
	}
}
