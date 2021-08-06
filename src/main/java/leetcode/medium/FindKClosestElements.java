package leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindKClosestElements {

    public static void main(String[] args) {
        FindKClosestElements s = new FindKClosestElements();
        s.findClosestElements(new int[] {1, 2, 4, 5, 6, 7}, 4, 3);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr.length <= k) {
            return IntStream.of(arr).boxed().collect(Collectors.toList());
        }

        PriorityQueue<Integer> qq = new PriorityQueue<>();

        int pos = x < arr[0] ? 0 : (x > arr[arr.length - 1] ? arr.length - 1 : findBinary(arr, x));

        PriorityQueue<Pair> q = new PriorityQueue<>(
            Comparator.comparingInt(Pair::getKey).thenComparingInt(Pair::getValue));
        int start = Math.max(0, pos - k);
        int end = Math.min(pos + k, arr.length - 1);
        for (int i = start; i <= end; i++) {
            q.offer(new Pair(Math.abs(x - arr[i]), i));
        }

        int c = k;
        while (c > 0) {
            qq.offer(arr[q.poll().value]);
            c--;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(qq.poll());
        }
        return res;
    }

    public int findBinary(int[] arr, int x) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = (r + l) / 2;
            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] > x) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return l;
    }

    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }
}
