class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        dfs(matrix, result, 0, matrix.length-1, 0, matrix[0].length-1);
        return result;
    }

    public void dfs(int[][] matrix, List<Integer> result, int top, int bottom, int left, int right) {
        if (top > bottom || left > right) {
            return;
        }
        for (int j = left; j < right; j++) {
            result.add(matrix[top][j]);
        }
        for (int i = top; i <= bottom; i++) {
            result.add(matrix[i][right]);
        }
        if (top == bottom || left == right) {
            return;
        }
        
        for (int j = right-1; j > left; j--) {
            result.add(matrix[bottom][j]);
        }
        for (int i = bottom; i > top; i--) {
            result.add(matrix[i][left]);
        }
        
        dfs(matrix, result, top+1, bottom-1, left+1, right-1);
    }
}
