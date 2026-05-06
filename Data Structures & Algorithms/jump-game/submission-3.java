class Solution {
    byte[] memo;
    public boolean canJump(int[] nums) {
        memo = new byte [nums.length];
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int index) {
        if (index == nums.length-1) {
            System.out.println(index);
            return true;
        }
        if (memo[index] != 0) {
            return memo[index] > 0 ? true : false;
        }
        int totalMoves = nums[index];
        while (totalMoves > 0) {
            int next = index+totalMoves--;
            if (next > 0 && next < nums.length) {
                memo[next] = dfs(nums, next) ? (byte) 1 : (byte)-1 ;
                if (memo[next] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
