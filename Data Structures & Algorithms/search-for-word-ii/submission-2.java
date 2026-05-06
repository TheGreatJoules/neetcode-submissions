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
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
            }
            current.isWord = true;
        }
    }
    private Set<String> result;
    private boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }
        int ROWS = board.length;
        int COLS = board[0].length;
        result = new HashSet<>();
        visited = new boolean[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                dfs(board, root, i, j, "");
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, TrieNode node, int r, int c, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || visited[r][c] || !node.children.containsKey(board[r][c])) {
            return;
        }
        visited[r][c] = true;
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if (node.isWord) {
            result.add(word);
        }
        dfs(board, node, r + 1, c, word);
        dfs(board, node, r, c+ 1, word);
        dfs(board, node, r-1, c, word);
        dfs(board, node, r, c-1, word);
        visited[r][c] = false;
    }
}
