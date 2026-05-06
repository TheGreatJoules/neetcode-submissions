class Solution {
    public int maxSubArray(int[] nums) {
        return dfs(nums, 0, 0, Integer.MIN_VALUE);
    }

    public int dfs(int[] nums, int i, int sum, int result) {
        if (i < nums.length) {
            return nums[i] > sum + nums[i] ? 
                            dfs(nums, i+1, nums[i], Math.max(result, nums[i])) :
                            dfs(nums, i+1, nums[i]+sum, Math.max(result, nums[i]+sum));
        }
        return result;
    }
}
