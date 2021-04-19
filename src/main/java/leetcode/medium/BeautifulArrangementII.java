package leetcode.medium;

public class BeautifulArrangementII {

    public static void main(String[] args) {
        BeautifulArrangementII s = new BeautifulArrangementII();
        s.constructArray(5, 3);
    }

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                res[i - 1] = i;
            }
            return res;
        }

        int i = 0;
        int top = n;
        int bottom = 1;
        boolean[] visited = new boolean[n];
        while (k != 0) {
            res[i] = i % 2 == 0 ? bottom++ : top--;
            visited[res[i] - 1] = true;
            i++;
            k--;
        }

        if (i < n) {
            if(i % 2 != 0){
                for (int j = 0; j < n; j++) {
                    if (!visited[j]) {
                        res[i++] = j + 1;
                    }
                }
            } else{
                for (int j = n - 1 ; j >= 0; j--) {
                    if (!visited[j]) {
                        res[i++] = j + 1;
                    }
                }
            }
        }

        return res;
    }
}
