class PrefixTree {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    private TrieNode root;
    private Map<String, TrieNode> map;

    public PrefixTree() {
        this.root = new TrieNode();
        this.map = new HashMap<>();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c-'a'] == null) {
                current.children[c-'a'] = new TrieNode();
            }
            current = current.children[c-'a'];
        }
        current.isWord = true;
        map.put(word, current);
    }

    public boolean search(String word) {
        return map.containsKey(word);
    }

    public boolean startsWith(String prefix) {
        return dfs(prefix, 0, root);
    }

    private boolean dfs(String prefix, int start, TrieNode node) {
        TrieNode current = node;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return true;
    }
}
