package leetcode.leetcode_by_topics.string;

public class CountVowelsPermutation {

    public int countVowelPermutation(int n) {
        int[] aCount = new int[n];
        int[] oCount = new int[n];
        int[] iCount = new int[n];
        int[] eCount = new int[n];
        int[] uCount = new int[n];

        aCount[0] = 1;
        oCount[0] = 1;
        iCount[0] = 1;
        eCount[0] = 1;
        uCount[0] = 1;

        for (int i = 1; i < n; i++) {
            aCount[i] = ((uCount[i - 1] + eCount[i - 1]) % 1_000_000_007 + iCount[i - 1]) % 1_000_000_007;
            eCount[i] = (aCount[i - 1] + iCount[i - 1]) % 1_000_000_007;
            iCount[i] = (eCount[i - 1] + oCount[i - 1]) % 1_000_000_007;
            oCount[i] = iCount[i - 1] % 1_000_000_007;
            uCount[i] = (oCount[i - 1] + iCount[i - 1]) % 1_000_000_007;
        }

        return (((uCount[n - 1] + eCount[n - 1]) % 1_000_000_007 +
            (aCount[n - 1] + oCount[n - 1]) % 1_000_000_007) % 1_000_000_007
            + iCount[n - 1]) % 1_000_000_007;
    }
}
