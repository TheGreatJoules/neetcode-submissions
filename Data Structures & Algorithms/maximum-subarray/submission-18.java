class Solution {
    int result = Integer.MIN_VALUE;

    public int maxSubArray(int[] nums) {
        int value = dfs(nums, nums.length-1);
        return Math.max(result, value);    
    }

    public int dfs(int[] nums, int i) {
        if (i == 0) {
            return nums[0];
        }
        int value = dfs(nums, i-1);
        result = Math.max(result, value);
        return (value < 0) ? nums[i] : value + nums[i];
    }
}
