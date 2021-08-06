package leetcode.easy;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] fl, int n) {
        if (n == 0) {
            return true;
        }
        else if (fl.length == 1) {
            return fl[0] == 0;
        }

        for (int i = 0; i < fl.length && n > 0; i++) {
            if (fl[i] == 1) {
                continue;
            }
            else if (i == 0) {
                if (fl[i + 1] == 0) {
                    fl[i] = 1;
                    n--;
                    i++;
                }
            }
            else if (i == fl.length - 1) {
                if (fl[i - 1] == 0) {
                    fl[i] = 1;
                    n--;
                    i++;
                }
            }
            else {
                if (fl[i] == 0 && fl[i + 1] == 0 && fl[i - 1] == 0) {
                    fl[i] = 1;
                    n--;
                    i++;
                }
            }
        }

        return n == 0;
    }
}
