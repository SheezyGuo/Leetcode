public class 地下城 {
    //    public static int undergo(int[][] mat) {
//        int hei = mat.length;
//        int wid = mat[0].length;
//        int[][] min = new int[hei + 1][wid + 1];
//        int[][] rest = new int[hei + 1][wid + 1];
//
//        for (int i = 1; i <= hei; i++) {
//            for (int j = 1; j <= wid; j++) {
//                if (i == 1 && j == 1) {
//                    min[i][j] = Math.max(1 - mat[i - 1][j - 1], 1);
//                    rest[i][j] = Math.max(1 + mat[i - 1][j - 1], 1);
//                    continue;
//                }
//                int right, down;
//                // j==1 左边界 不能由右边走到
//                if (j == 1) {
//                    right = Integer.MAX_VALUE;
//                } else {
//                    right = rest[i][j - 1] + mat[i - 1][j - 1] >= 1 ?//血够不够扣
//                            min[i][j - 1]//够扣
//                            : min[i][j - 1] + 1 - (rest[i][j - 1] + mat[i - 1][j - 1]);
//                }
//                // i==1 上边界 不能由上边往下走到
//                if (i == 1) {
//                    down = Integer.MAX_VALUE;
//                } else {
//                    down = rest[i - 1][j] + mat[i - 1][j - 1] >= 1 ?
//                            min[i - 1][j]
//                            : min[i - 1][j] + 1 - (rest[i - 1][j] + mat[i - 1][j - 1]);
//                }
//                min[i][j] = Math.min(right, down);
//                if (down < right) {
//                    rest[i][j] = Math.max(rest[i - 1][j] + mat[i - 1][j - 1], 1);
//                } else {
//                    rest[i][j] = Math.max(rest[i][j - 1] + mat[i - 1][j - 1], 1);
//                }
//            }
//        }
//        return min[hei][wid];
//    }
//
//    public static void main(String[] args) {
//        int mat[][] = new int[][]{
//                {-2, -3, 3},
//                {-5, -10, 1},
//                {10, 30, -5}
//        };
//        int mat2[][] = new int[][]{
//                {1, -3, 3},
//                {0, -2, 0},
//                {-3, -3, -3}
//        };
//        System.out.println(undergo(mat2));
//    }

    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[] dp = new int[col];
        // 最底下的行设置
        dp[--col] = Math.max(1, 1 - dungeon[--row][col]);
        for (int j = col - 1; j >= 0; j--) {
            dp[j] = Math.max(dp[j + 1] - dungeon[row][j], 1);
        }
        // 倒数第2行到第0行
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col; j >= 0; j--) {
                if (j == col) {
                    dp[j] = Math.max(dp[j] - dungeon[i][j], 1);
                } else {
                    int down = Math.max(dp[j] - dungeon[i][j], 1);
                    int right = Math.max(dp[j + 1] - dungeon[i][j], 1);
                    dp[j] = Math.min(down, right);
                }
            }
        }
        return dp[0];
    }
}
