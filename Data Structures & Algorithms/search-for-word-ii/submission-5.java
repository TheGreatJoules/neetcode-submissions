class Solution {
    class TrieNode {
        Map<Character, TrieNode> children;
        int wordIndex;
        int refs;
        public TrieNode() {
            this.children = new HashMap<>();
            this.wordIndex = -1;
            this.refs = 0;
        }
        public void addWord(String word, int index) {
            TrieNode current = this;
            current.refs++;
            for (char c : word.toCharArray()) {
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
                current.refs++;
            }
            current.wordIndex = index;
        }
    }
    private Set<String> result;
    private String[] words;
    private char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        this.board = board;
        this.words = words;
        for (int i = 0; i < words.length; i++) {
            root.addWord(words[i], i);
        }
        int ROWS = board.length;
        int COLS = board[0].length;
        result = new HashSet<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                dfs(root, i, j);
            }
        }
        return new ArrayList<>(result);
    }
    private int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    private void dfs(TrieNode node, int r, int c) {
        int ROWS = board.length;
        int COLS = board[0].length;
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] == '*' || !node.children.containsKey(board[r][c])) {
            return;
        }
        char currentChar = board[r][c];
        node = node.children.get(currentChar);
        if (node == null || node.refs == 0) {
            return;
        }
        if (node.wordIndex != -1) {
            result.add(words[node.wordIndex]);
            node.wordIndex = -1;
        }
        board[r][c] = '*';
        for (int[] dir : dirs) {
            dfs(node, r + dir[0], c + dir[1]);
        }
        board[r][c] = currentChar;
    }
}
