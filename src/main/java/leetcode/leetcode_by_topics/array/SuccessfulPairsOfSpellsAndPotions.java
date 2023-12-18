package leetcode.leetcode_by_topics.array;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        Arrays.sort(potions);

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int index = findIndex(potions, spells[i], success);
            res[i] = index == -1 ? 0 : m - index;
        }

        return res;
    }

    public int findIndex(int[] potions, int spell, long success) {
        int l = 0, r = potions.length - 1;
        int index = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) spell * potions[mid] < success) {
                l = mid + 1;
            } else {
                index = Math.min(index, mid);
                r = mid - 1;
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }
}
