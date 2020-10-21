package leetcode.easy;

public class CountPrimes {
	public static void main(String[] args) {
		System.out.println(countPrimes(10) == 4);
	}

	public static int countPrimes(int n) {
		boolean [] primeTable = new boolean[n];
		// mark all as prime by default
		for(int i=2; i < n; i++) {
			primeTable[i] = true;
		}

		for(int i=2; i * i < n; i++) {
			if(primeTable[i] == false) {
				continue;
			}
			for(int j=i*i; j < n; j = j + i) {
				primeTable[j] = false;
			}
		}

		int count = 0;
		for(int i=0; i< n; i++) {
			if(primeTable[i]) {
				count++;
			}
		}

		return count;
	}
}
