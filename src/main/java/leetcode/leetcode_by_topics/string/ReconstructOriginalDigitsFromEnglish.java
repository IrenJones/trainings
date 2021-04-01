package leetcode.leetcode_by_topics.string;

public class ReconstructOriginalDigitsFromEnglish {

    public static void main(String[] args) {
        ReconstructOriginalDigitsFromEnglish s = new ReconstructOriginalDigitsFromEnglish();
        s.originalDigits("zeroonetwothreefourfivesixseveneightnine");
        s.originalDigits("owoztneoer");
    }

    public String originalDigits(String s) {

        int[] counts = new int[10];
        int[] countsV = new int[26];
        // zero (Z)
        // one - (count(o) - count(2) - count(4) - count(0))
        // two(W)
        // three (count(h) - count(8))
        // four(U)
        // five(count(f) - count(4))
        // six(X)
        // seven(count(v) - count(5))
        // eight(G)
        // nine (count(i) - count(8) - count(6) - count(5))
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'z') {
                counts[0]++;
            }
            if (c == 'u') {
                counts[4]++;
            }
            if (c == 'w') {
                counts[2]++;
            }
            if (c == 'x') {
                counts[6]++;
            }
            if (c == 'g') {
                counts[8]++;
            }
            if (c == 'i') {
                countsV[c - 'a']++;
            }
            if (c == 'v') {
                countsV[c - 'a']++;
            }
            if (c == 'f') {
                countsV[c - 'a']++;
            }
            if (c == 'o') {
                countsV[c - 'a']++;
            }
            if (c == 'h') {
                countsV[c - 'a']++;
            }
        }

        int[] result = new int[10];
        result[2] = counts[2];
        result[4] = counts[4];
        result[6] = counts[6];
        result[8] = counts[8];
        result[0] = counts[0];
        result[5] = countsV['f' - 'a'] - result[4];
        result[3] = countsV['h' - 'a'] - result[8];
        result[7] = countsV['v' - 'a'] - result[5];
        result[9] = countsV['i' - 'a'] - result[8] - result[6] - result[5];
        result[1] = countsV['o' - 'a'] - result[0] - result[2] - result[4];

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            while (result[i] > 0) {
                res.append(i);
                result[i]--;
            }
        }

        return res.toString();
    }
}
