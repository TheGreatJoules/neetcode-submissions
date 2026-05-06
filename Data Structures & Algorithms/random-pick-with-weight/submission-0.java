class Solution {
    
    private int[] prefix;

    public Solution(int[] w) {
        this.prefix = new int[w.length+1];
        for (int i = 0; i < w.length; i++) {
            prefix[i+1] = prefix[i] + w[i];
        }
    }
    
    public int pickIndex() {
        double target = prefix[prefix.length-1] * Math.random();
        int left = 1;
        int right = prefix.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefix[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */