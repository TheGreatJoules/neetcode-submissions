class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] memo = new Boolean [nums.length];
        return dfs(nums, memo, 0);
    }

    private boolean dfs(int[] nums, Boolean[] memo, int index) {        
        if (index+nums[index] >= nums.length-1) {
            return memo[index] = true;
        }
        if (index < nums.length && memo[index] != null) {
            return memo[index];
        }
        for (int i = index+1; i <= index + nums[index]; i++) {
            if (dfs(nums, memo, i)) {
                return true;
            }
        }
        return memo[index] = false;
    }
}
