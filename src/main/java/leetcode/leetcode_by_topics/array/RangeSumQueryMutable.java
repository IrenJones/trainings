package leetcode.leetcode_by_topics.array;

public class RangeSumQueryMutable {

    public static void main(String[] args) {
        NumArray solution = new NumArray(new int[]{1, 3, 5});
        solution.sumRange(0, 2);
        solution.update(1, 2);
        solution.sumRange(0, 2);
    }
}

// TLE
class NumArrayOld {

    int[] dp;
    int[] nums;

    public NumArrayOld(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }

    public void update(int index, int val) {
        int diff = nums[index] - val;

        for (int i = index + 1; i < dp.length; i++) {
            dp[i] -= diff;
        }
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return dp[right + 1] - dp[left];
    }
}

class NumArray {

    SegmentTreeNode root;

    class SegmentTreeNode {
        int left;
        int right;
        int sum;
        SegmentTreeNode leftNode;
        SegmentTreeNode rightNode;

        public SegmentTreeNode(int left, int right) {
            this.left = left;
            this.right = right;
            this.leftNode = null;
            this.rightNode = null;
            this.sum = 0;
        }
    }
    public NumArray(int[] nums){
        root = construct(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode construct(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }

        SegmentTreeNode node = new SegmentTreeNode(left, right);
        if(left == right){
            node.sum = nums[left];
        } else {
            int middle = left + (right - left) / 2;
            node.leftNode = construct(nums, left, middle);
            node.rightNode = construct(nums, middle + 1, right);
            node.sum = (node.leftNode == null ? 0 : node.leftNode.sum) +
                (node.rightNode == null ? 0 : node.rightNode.sum);
        }
        return node;
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    private void update(SegmentTreeNode node, int index, int val) {
        if(node.left == node.right){
            node.sum = val;
            return;
        }

        int middle = (node.left + node.right) / 2;
        if(index <= middle){
            update(node.leftNode, index, val);
        } else{
            update(node.rightNode, index, val);
        }
        node.sum = node.leftNode.sum + node.rightNode.sum;
    }

    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }

    private int sumRange(SegmentTreeNode node, int left, int right) {
        if(node.left == left && node.right == right){
            return node.sum;
        }

        int middle = (node.left + node.right) / 2;
        if(right <= middle){
            return  sumRange(node.leftNode, left, right);
        } else if(left > middle) {
            return sumRange(node.rightNode, left, right);
        } else {
            return sumRange(node.leftNode, left, middle) + sumRange(node.rightNode, middle + 1, right);
        }
    }
}


