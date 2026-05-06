class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;
        List<Integer> result = new ArrayList<>();
        while (left < right && top < bottom) {
            for (int j = left; j < right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            for (int i = top; i < bottom; i++) {
                result.add(matrix[i][right-1]);
            }
            right--;
            System.out.println(result.get(result.size()-1));
            if (left < right && top < bottom) {
                for (int j = right-1; j >= left; j--) {
                    result.add(matrix[bottom-1][j]);
                }
                bottom--;
                for (int i = bottom-1; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
            } else {
                bottom--;
            }
            left++;
            System.out.println("top"+top+"bottom"+bottom);
        }
        return result;
    }
}
