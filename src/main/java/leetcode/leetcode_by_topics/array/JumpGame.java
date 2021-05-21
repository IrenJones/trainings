package leetcode.leetcode_by_topics.array;

public class JumpGame {

    public static void main(String[] args) {
        JumpGame s = new JumpGame();
        s.canJump(new int[]{3,2,1,0,4});
    }

    public boolean canJump(int[] nums) {
        return helper(nums, 0);
    }

    public boolean helper(int[] nums, int i){
        if(i == nums.length - 1){
            return true;
        }
        if(i < nums.length) {
            for(int j = nums[i]; j > 0; j--){

                if(helper(nums, i + j)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canJumpBetter(int[] nums) {
        int lastPos = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(i + nums[i] >= lastPos){
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

}
