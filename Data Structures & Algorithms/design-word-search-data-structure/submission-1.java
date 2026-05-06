class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c -'a'] == null) {
                current.children[c-'a'] = new TrieNode();
            }
            current = current.children[c-'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, TrieNode node, int start) {
        TrieNode current = node;
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : current.children) {
                    if (child != null && dfs(word, child, i+1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (current.children[c-'a'] != null) {
                    current = current.children[c-'a'];
                } else {
                    return false;
                }
            }
        }
        return current.isWord;
    }
}
