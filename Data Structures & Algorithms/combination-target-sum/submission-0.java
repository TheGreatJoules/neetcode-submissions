class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new LinkedList<>(), nums, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, LinkedList<Integer> current, int [] nums, int remain, int index) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(result, current, nums, remain - nums[i], i);
            current.removeLast();
        }
    }
}
