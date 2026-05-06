class Solution {
    public int maxSubArray(int[] nums) {
        return dfs(nums, 0, 0, Integer.MIN_VALUE);
    }

    public int dfs(int[] nums, int i, int currentSum, int maxSum) {
        if (i == nums.length) {
            System.out.println("index\t"+i+"\tcurrentSum\t"+currentSum+"\tmaxSum\t"+maxSum);
            return maxSum;
        }
        if ((currentSum + nums[i] < 0 && nums[i] > 0) || nums[i] > currentSum + nums[i]) {
            currentSum = nums[i];
            maxSum = Math.max(maxSum, nums[i]);
            System.out.println("\tindex\t"+i+"\tcurrentSum\t"+currentSum+"\tmaxSum\t"+maxSum);
            return dfs(nums, i+1, nums[i], maxSum);
        } else {
            currentSum = currentSum + nums[i];
            maxSum = Math.max(maxSum, currentSum);
            System.out.println("index\t"+i+"\tcurrentSum\t"+currentSum+"\tmaxSum\t"+maxSum);
            return dfs(nums, i+1, currentSum, maxSum);
        }
        
    }
}
