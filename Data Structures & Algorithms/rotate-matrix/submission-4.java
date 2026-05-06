class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        // horizontalFlip(matrix); // CounterClockwise
        // transpose(matrix);      // CounterClockwise
        //                         // EQUAL RESULT
        // transpose(matrix);      // CounterClockwise
        // verticalFlip(matrix);   // CounterClockwise
        
        transpose(matrix);
        horizontalFlip(matrix);

        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private void horizontalFlip(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m - j - 1];
                matrix[i][m - j - 1] = temp;
            }
        }
    }

    private void verticalFlip(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n/2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n-i-1] = temp;
        }
    }

    private void transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
