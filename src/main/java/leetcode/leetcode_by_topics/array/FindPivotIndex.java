package leetcode.leetcode_by_topics.array;

public class FindPivotIndex {

    public static void main(String[] args) {
        FindPivotIndex s = new FindPivotIndex();
        s.pivotIndex(new int[]{1,7,3,6,5,6});
    }

    public int pivotIndex(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int n = nums.length;
        int[] left = new int[n + 1];

        for(int i = 1; i <= n; i++){
            left[i] = left[i - 1] + nums[i - 1];
        }

        for(int i = 1; i <= n; i++){
            int leftSum = left[i - 1] - left[0];
            int rightSum = i == n ? 0 : left[n] - left[i];
            if(leftSum == rightSum) {
                return i - 1;
            }
        }

        return -1;
    }
}
