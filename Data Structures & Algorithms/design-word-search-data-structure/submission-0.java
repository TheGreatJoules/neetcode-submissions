class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c-'a'] == null) {
                current.children[c-'a'] = new TrieNode();
            }
            current = current.children[c-'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int start, TrieNode node) {
        TrieNode current = node;
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : current.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (current.children[c-'a'] == null) {
                    return false;
                }
                current = current.children[c -'a'];
            }
        }
        return current.isWord;
    }
}
