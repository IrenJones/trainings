package leetcode.leetcode_by_topics.array;

import java.util.HashSet;
import java.util.Set;

public class JumpGameIII {

    public static void main(String[] args) {
        canReach(new int[] {3, 0, 2, 1, 2}, 2);
    }

    public static boolean canReach(int[] arr, int start) {
        return helper(arr, start, new HashSet<>());
    }

    public static boolean helper(int[] arr, int index, Set<Integer> indexes) {
        if (index < 0 || index >= arr.length) {
            return false;
        }
        if (arr[index] == 0) {
            return true;
        }

        if (indexes.contains(index)) {
            return false;
        }

        indexes.add(index);

        return helper(arr, index - arr[index], new HashSet(indexes)) ||
            helper(arr, index + arr[index], new HashSet(indexes));
    }

    public static boolean canReachWithTrick(int[] arr, int start) {
        if (start < 0 || start >= arr.length) {
            return false;
        }
        int value = arr[start];
        arr[start] += arr.length;
        return value == 0 || canReachWithTrick(arr, start - value) || canReachWithTrick(arr, start + value);
    }

    public boolean canReachNew(int[] arr, int start) {
        return helper(arr, new boolean[arr.length], start);
    }

    public boolean helper(int[] arr, boolean[] visited, int i) {
        if (i < 0 || i > arr.length - 1 || visited[i]) {
            return false;
        }

        visited[i] = true;
        if (arr[i] == 0) {
            return true;
        }

        return helper(arr, visited, i - arr[i]) || helper(arr, visited, i + arr[i]);
    }
}
