class Solution {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        public TrieNode() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
        public void addWord(String word) {
            TrieNode current = this;
            for (char c : word.toCharArray()) {
                current.children.computeIfAbsent(c, v -> new TrieNode());
                current = current.children.get(c);
            } 
            current.isWord = true;
        }

        public boolean search(String s, int x, int y) {
            TrieNode current = this;
            for (int i = x; i <= y; i++) {
                if (!current.children.containsKey(s.charAt(i))) {
                    return false;
                }
                current = current.children.get(s.charAt(i));
            }
            return current.isWord;
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            root.addWord(word);
        }
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        int maxLength = 0; // optimization
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < Math.min(n, i + maxLength); j++) {
                if (root.search(s, i, j)) {
                    dp[i] = dp[j+1];
                    if (dp[i]) {
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}