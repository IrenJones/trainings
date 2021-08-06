package leetcode.easy;

public class TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;

        int n = timeSeries.length;

        for (int i = 0; i < n - 1; i++) {
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }

        return total + duration;
    }
}
