class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left[i] = 1;
                right[nums.length-1-i] = 1;
            } else {
                left[i] = nums[i-1] * left[i-1]; 
                right[nums.length-1-i] = nums[nums.length-i] * right[right.length-i];
            }
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}  
