class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                twoSum(nums, result, i);
            }
        }
        return result;
    }

    private void twoSum(int[] nums, List<List<Integer>> result, int index) {
        int left = index + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[index] + nums[left] + nums[right];
            if (sum == 0) {
                result.add(Arrays.asList(nums[index], nums[left++], nums[right--]));
                while (left < right && nums[left] == nums[left-1]) {
                    left++;
                }
            } else {
                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
            
        }
    }
}
