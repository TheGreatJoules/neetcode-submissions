class Solution {
    public int numDecodings(String s) {
        return dfs(s, 0);
    }

    private int dfs(String s, int i) {
        if (i == s.length()) {
            return 1;
        }
        int result = 0;
        for (int k = 1; k <= 2; k++) {
            if (i + k <= s.length()) {
                String window = s.substring(i, i+k);
                if (window.startsWith("0")) {
                    continue;
                }
                int value = Integer.parseInt(window);
                if (value >= 1 && value <= 26) {
                    result += dfs(s, i + k);
                }
            }
        }
        return result;
    }
}
