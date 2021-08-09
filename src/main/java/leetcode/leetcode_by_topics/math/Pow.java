package leetcode.leetcode_by_topics.math;

public class Pow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            long nL = -n;
            return 1 / x * myPow(1 / x, (int)nL - 1);
        }

        return n % 2 == 0
            ? myPow(x * x, n / 2)
            : x * myPow(x * x, n / 2);
    }
}
