class Solution {
    int[][] dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        int ROWS = board.length;
        int COLS = board[0].length;
        List<String> result = new ArrayList<>();
        for (String word : words) {
            boolean flag = false;
            for (int r = 0; r < ROWS && !flag; r++) {
                for (int c = 0; c < COLS; c++) {
                    if (board[r][c] == word.charAt(0) && backtrack(board, r, c, word, 0)) {
                        result.add(word);
                        flag = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private boolean backtrack(char[][] board, int r, int c, String word, int i) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || word.charAt(i) != board[r][c]) {
            return false;
        }
        board[r][c] = '*';
        boolean result = false;
        for (int[] dir : dirs) {
            int x = r + dir[0];
            int y = c + dir[1];
            result |= backtrack(board, x, y, word, i+1);
        }
        board[r][c] = word.charAt(i);
        return result;
    }
}
