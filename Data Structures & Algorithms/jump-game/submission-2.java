class Solution {
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int index) {
        if (index == nums.length-1) {
            System.out.println(index);
            return true;
        }
        if (index >= nums.length) {
            return false;
        }
        int move = nums[index];
        while (move > 0) {
            System.out.println("current\t"+index+"next\t"+(index+move));
            if (dfs(nums, index+move)) {
                return true;
            }
            move--;
        }
        return false;
    }
}
