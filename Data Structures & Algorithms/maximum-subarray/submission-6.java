class Solution {
    public int maxSubArray(int[] nums) {
        int right = 0;
        int sum = nums[right];
        int result = sum;
        int left = right++;
        while (right < nums.length) {
            int current = sum + nums[right];
            if (nums[right] <= current) {
                result = Math.max(result, current);
                sum += nums[right++];
            } else {
                sum = nums[right];
                result = Math.max(result, sum);
                left = right++;
            }  
        }
        System.out.println(left + ", " + right);
        return result;
    }
}
