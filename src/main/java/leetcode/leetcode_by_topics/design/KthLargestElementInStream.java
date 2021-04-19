package leetcode.leetcode_by_topics.design;

import java.util.Arrays;

public class KthLargestElementInStream {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8
    }
}

class KthLargest {

    int k;
    int[] v;

    public KthLargest(int k, int[] nums) {
        v = new int[k];
        this.k = k;
        Arrays.fill(v, Integer.MIN_VALUE);

        for(int i = 0; i < nums.length; i++){
            add(nums[i]);
        }
    }

    public int add(int val) {
        if(v[k - 1] < val) {
            // insert
            int i = 0;
            while (v[i] >= val) {
                i++;
            }
            int next = v[i];
            v[i++] = val;
            while (i < k) {
                int tmp = v[i];
                v[i++] = next;
                next = tmp;
            }
        }
        return v[k - 1];
    }
}
