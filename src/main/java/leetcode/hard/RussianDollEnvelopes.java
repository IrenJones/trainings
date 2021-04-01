package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.hadoop.io.Text;

public class RussianDollEnvelopes {

    public static void main(String[] args) {
        RussianDollEnvelopes s = new RussianDollEnvelopes();
//        int[][] arr = {{5,4},{6,4},{6,7},{2,3}};
        int[][] arr = {
            {15, 8}, {2, 20}, {2, 14}, {4, 17}, {8, 19}, {8, 9}, {5, 7}, {11, 19}, {8, 11}, {13, 11}, {2, 13},
            {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19}, {16, 1}, {18, 13}, {14, 17}, {18, 19}};
        s.maxEnvelopes(arr);
    }

    int res = 0;

    // TLE
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 1) {
            return 1;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();
        int i = 0;
        for (int[] env : envelopes) {
            List<Integer> list = map.getOrDefault(env[0] * env[1], new ArrayList<>());
            list.add(i++);
            map.put(env[0] * env[1], list);
        }

        List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(map.entrySet());
        greedy(list, envelopes, res, -1, -1, 0);

        return res;
    }

    private void greedy(List<Map.Entry<Integer, List<Integer>>> list,
        int[][] envelopes, int resCur, int prev, int areaPrev, int start) {

        if (resCur > res) {
            res = Math.max(resCur, res);
        }

        if (areaPrev == list.get(list.size() - 1).getKey()) {
            return;
        }

        for (int i = start; i < list.size(); i++) {
            Map.Entry<Integer, List<Integer>> e = list.get(i);
            if (e.getKey() > areaPrev) {
                int[] wh = prev != -1 ? envelopes[prev] : new int[] {0, 0};
                for (int ind : e.getValue()) {
                    int[] wh1 = envelopes[ind];
                    if (wh[0] < wh1[0] && wh1[1] > wh[1]) {
                        // doooooll!
                        greedy(list, envelopes, resCur + 1, ind, e.getKey(), i + 1);
                    }
                }
            }
        }

    }

    //----------------------------------------------------------

    public int maxEnvelopesDP(int[][] env) {
        if (env.length == 1) {
            return 1;
        }

        Arrays.sort(env, Comparator.comparingInt(a -> a[0]));

        int[] dp = new int[env.length];
        Arrays.fill(dp, 1);

        int res = 1;

        for (int i = 0; i < env.length; i++) {
            for (int j = 0; j < i; j++) {
                if (env[j][0] < env[i][0] && env[j][1] < env[i][1]) {
                    // dooooll!
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
