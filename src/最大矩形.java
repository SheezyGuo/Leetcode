public class 最大矩形 {

    // 栈方法
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int depth[][] = new int[row][col];
        int max = 0;
        for (int j = 0; j < col; j++) {
            int d = 0;
            for (int i = 0; i < row; i++) {
                if (matrix[i][j] == 1) {
                    depth[i][j] = ++d;
                } else {
                    d = 0;
                    depth[i][j] = d;
                }
                int height = Integer.MAX_VALUE;
                for (int k = j; k >= 0; k--) {
                    height = Math.min(height, depth[i][k]);
                    max = Math.max(max, height * (j + 1 - k));
                }
            }
        }
        return max;
    }

}
