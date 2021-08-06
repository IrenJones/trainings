package leetcode.leetcode_by_topics.string;

public class PushDominoes {

    public static void main(String[] args) {
        PushDominoes s = new PushDominoes();
        s.pushDominoes("RR.L");
    }

    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] points = new int[n];

        int point = 0;
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                point = n;
            }
            else if (dominoes.charAt(i) == 'L') {
                point = 0;
            }
            else {
                point = Math.max(point - 1, 0);
            }
            points[i] += point;
        }

        point = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                point = n;
            }
            else if (dominoes.charAt(i) == 'R') {
                point = 0;
            }
            else {
                point = Math.max(point - 1, 0);
            }
            points[i] -= point;
        }

        StringBuilder sb = new StringBuilder();
        for (int v : points) {
            sb.append(v == 0 ? '.' : v > 0 ? 'R' : 'L');
        }
        return sb.toString();
    }

}
