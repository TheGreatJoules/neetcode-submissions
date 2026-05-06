class Solution {
    public int numDecodings(String s) {
        return dfs(s, 0, new HashMap<>());
    }

    private int dfs(String s, int i, Map<Integer, Integer> memo) {
        if (i == s.length()) {
            return 1;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int result = 0;
        for (int k = 1; k <=2; k++) {
            if (i + k <= s.length()) {
                String window = s.substring(i, i+k);
                if (window.startsWith("0")) {
                    continue;
                }
                int value = Integer.parseInt(window);
                if (1 <= value && value <= 26) {
                    result += dfs(s, i+k, memo);
                }
            }
        }
        memo.put(i, result);
        return result;
    }
}
