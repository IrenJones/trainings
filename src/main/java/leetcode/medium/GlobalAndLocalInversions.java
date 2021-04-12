package leetcode.medium;

public class GlobalAndLocalInversions {

    public static void main(String[] args) {
        GlobalAndLocalInversions s = new GlobalAndLocalInversions();
        s.isIdealPermutation(new int[] {4, 3, 2, 1, 0});
    }

    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        int maxValue = 0;
        for (int i = 0; i < n - 2; i++) {
            maxValue = Math.max(A[i], maxValue);
            if (maxValue > A[i + 2]) {
                return false;
            }
        }

        return true;
    }

    public boolean isIdealPermutationABS(int[] A) {
        int n = A.length;

        for(int i = 0; i < n; i++) {
            if(Math.abs(A[i] - i) > 1) {
                return false;
            }
        }

        return true;
    }
}
