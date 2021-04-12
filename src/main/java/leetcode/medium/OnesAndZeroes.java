package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class OnesAndZeroes {

    public static void main(String[] args) {
        OnesAndZeroes s = new OnesAndZeroes();
        s.findMaxFormDP(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3);
    }

    // TLE
    int maxLen = 0;

    public int findMaxForm(String[] strs, int m, int n) {
        int size = strs.length;
        int[] countOne = new int[size];
        int[] countZero = new int[size];

        for (int i = 0; i < size; i++) {
            countOne[i] = countOnes(strs[i]);
            countZero[i] = strs[i].length() - countOne[i];
        }

        find(0, countOne, countZero, m, n, new ArrayList<>());

        return maxLen;
    }

    public void find(int start, int[] ones, int[] zeros, int m, int n, List<Integer> cur) {
        maxLen = Math.max(cur.size(), maxLen);

        for (int i = start; i < ones.length; i++) {
            if (n - ones[i] >= 0 && m - zeros[i] >= 0) {
                cur.add(i);
                find(i + 1, ones, zeros, m - zeros[i], n - ones[i], new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
            }
        }
    }

    public int countOnes(String s) {
        int r = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                r++;
            }
        }

        return r;
    }

    // m - zeros
    // n - ones
    public int findMaxFormDP(String[] strs, int m, int n) {
        int size = strs.length;
        int[] countOne = new int[size];
        int[] countZero = new int[size];

        for (int i = 0; i < size; i++) {
            countOne[i] = countOnes(strs[i]);
            countZero[i] = strs[i].length() - countOne[i];
        }

        int[][] dp = new int[m + 1][n + 1];

        for (int index = 0; index < countOne.length; index++) {
            for (int i = m; i >= countZero[index]; i--) {
                for (int j = n; j >= countOne[index]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - countZero[index]][j - countOne[index]] + 1);
                }
            }
        }

        return dp[m][n];
    }

}
