class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new LinkedList<>(), nums, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, LinkedList<Integer> current, int[] nums, int remain, int index) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
        }
        if (remain < 0) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(result, current, nums, remain - nums[i], i);
            current.removeLast();
        }
    }
}
