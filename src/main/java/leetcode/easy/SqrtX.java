package leetcode.easy;

public class SqrtX {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int l = 1;
        int r = x;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid == x / mid) {
                return mid;
            }
            else if (mid > x / mid) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return r;
    }
}
