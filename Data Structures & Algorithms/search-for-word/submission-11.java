class Solution {
    int ROWS, COLS;
    int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
    Set<Pair<Integer, Integer>> paths = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        // if (i > word.length() || board[r][c] != word.charAt(i)) {
        //     return false;
        // }
        
        if (i == word.length()) {
            for (Pair<Integer, Integer> entry : paths) {
                System.out.println(entry.getKey() + ", " + entry.getValue());
            }
            return true;
        }
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS ) {
            return false;
        }
        if (board[r][c] != word.charAt(i)) {
            return false;
        }
        paths.add(new Pair<>(r, c));
        System.out.println(word.charAt(i));
        for (int [] dir : dirs) {
            int x = dir[0] + r;
            int y = dir[1] + c;
            if (!paths.contains(new Pair<>(x, y))) {
                if(dfs(board, word, x, y, i+1)){
                    return true;
                }
            }
        }
        paths.remove(new Pair<>(r, c));
        return false;
    }
}
