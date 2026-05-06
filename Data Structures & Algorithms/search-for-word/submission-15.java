class Solution {
    private int ROWS, COLS;
    boolean[][] visited;
    int[][] dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || visited[r][c]) {
            return false;
        }
        if (board[r][c] != word.charAt(index)) {
            return false;
        }
        visited[r][c] = true;
        for (int[] dir : dirs) {
            int x = r + dir[0];
            int y = c + dir[1];
            if (dfs(board, word, x, y, index + 1)) {
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }
}
