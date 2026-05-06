class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.copyOf(rotated[i], rotated[i].length);
        }
    }
}
