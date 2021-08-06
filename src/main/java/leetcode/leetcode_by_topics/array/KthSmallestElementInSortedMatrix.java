package leetcode.leetcode_by_topics.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {

    public static void main(String[] args) {
        KthSmallestElementInSortedMatrix s = new KthSmallestElementInSortedMatrix();
        int[][] arr = {
            {1,5,9},
            {10,11,13},
            {12,13,15}};
        s.kthSmallest(arr, 8);
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> minQueue = new PriorityQueue<>(Comparator.comparingInt((Pair p) -> matrix[p.getX()][p.getY()]));

        int n = matrix[0].length;
        for (int i = 0; i < n && i < k; i++) {
            minQueue.offer(new Pair(0, i));
        }

        int i = 0;
        int res = 0;
        while (i < k && !minQueue.isEmpty()) {
            Pair p = minQueue.poll();
            res = matrix[p.getX()][p.getY()];
            i++;
            if(i == k){
                return res;
            }

            if(n > p.getX() + 1){
                minQueue.add(new Pair(p.getX() + 1, p.getY()));
            }
        }

        return res;
    }

    class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
