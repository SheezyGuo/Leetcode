public class 表面积 {
    public int surfaceArea(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int dul = 0;
        for (int j = 0; j < col; j++) {
            for (int i = 1; i < row; i++) {
                dul += Math.min(grid[i][j], grid[i - 1][j]);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dul += Math.min(grid[i][j], grid[i][j - 1]);
            }
        }
        int num = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dul += grid[i][j] > 0 ? grid[i][j] - 1 : 0;
                num += grid[i][j];
            }
        }
        return num * 6 - 2 * dul;
    }
}
