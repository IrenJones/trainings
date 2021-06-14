package leetcode.leetcode_by_topics.math;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public int minPartitions(String n) {
        int count = 0;

        for (char c : n.toCharArray()) {
            int v = Integer.parseInt(String.valueOf(c));
            count = Math.max(count, v);
        }

        return count;
    }
}
