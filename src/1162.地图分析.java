import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1162 lang=java
 *
 * [1162] 地图分析
 *
 * https://leetcode-cn.com/problems/as-far-from-land-as-possible/description/
 *
 * algorithms
 * Medium (38.11%)
 * Likes:    78
 * Dislikes: 0
 * Total Accepted:    16.7K
 * Total Submissions: 36.9K
 * Testcase Example:  '[[1,0,1],[0,0,0],[1,0,1]]'
 *
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1
 * 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 * 
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 -
 * x1| + |y0 - y1| 。
 * 
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释： 
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释： 
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 * 
 * 
 */

// @lc code=start
class Solution {

    public int maxDistance(int[][] grid) {
        List<int[]> land = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    land.add(new int[] { i, j });
                }
            }
        }
        if (land.size() == 0 || land.size() == grid.length * grid[0].length) {
            return -1;
        }
        int length = -1;
        int[][] direction = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!land.isEmpty()) {
            length++;
            List<int[]> temp = new ArrayList<>();
            for (int[] axis : land) {
                int x = axis[0], y = axis[1];
                for (int[] d : direction) {
                    int new_x = x + d[0], new_y = y + d[1];
                    if (check(new_x, new_y, grid.length - 1, grid[0].length - 1) && grid[new_x][new_y] == 0) {
                        temp.add(new int[] { new_x, new_y });
                        grid[new_x][new_y] = 2;
                    }
                }
            }
            land = temp;
        }
        return length;
    }

    private boolean check(int x, int y, int X, int Y) {
        return x >= 0 && x <= X && y >= 0 && y <= Y;
    }
}
// @lc code=end
