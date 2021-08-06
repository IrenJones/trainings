package leetcode.leetcode_by_topics.bit;

public class NonNegativeIntegersWithoutConsecutiveOnes {

    public int findIntegers(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (check(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean check(int n) {
        int i = 0;
        while (i < 32) {
            int curBit = n & (1 << i);
            int prevBit = n & (1 << (i + 1));
            if (curBit != 0 &&
                 prevBit != 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}
