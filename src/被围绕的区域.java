public class 被围绕的区域 {
//    public void solve(char[][] board) {
//        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
//            return;
//        }
//        int row = board.length;
//        int col = board[0].length;
//        int[] rows = new int[]{0, row - 1};
//        int[] cols = new int[]{0, col - 1};
//        for (int i : rows) {
//            for (int j = 0; j < col; j++) {
//                dfs(board, i, j, row, col);
//            }
//        }
//        for (int j : cols) {
//            for (int i = 1; i < row - 1; i++) {
//                dfs(board, i, j, row, col);
//            }
//        }
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (board[i][j] == 'O') {
//                    board[i][j] = 'X';
//                } else if (board[i][j] == '#') {
//                    board[i][j] = 'O';
//                }
//            }
//        }
//    }
//
//    private void dfs(char[][] board, int i, int j, int row, int col) {
//        if (i < 0 || i >= row || j < 0 || j >= col) {
//            return;
//        }
//        if (board[i][j] == 'O') {
//            board[i][j] = '#';
//            dfs(board, i + 1, j, row, col);
//            dfs(board, i - 1, j, row, col);
//            dfs(board, i, j + 1, row, col);
//            dfs(board, i, j - 1, row, col);
//        }
//    }

    static int cols;

    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        int rows = board.length;
        cols = board[0].length;

        // 用一个虚拟节点, 边界上的O 的父节点都是这个虚拟节点
        UnionFind uf = new UnionFind(rows * cols + 1);
        int dummyNode = rows * cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    // 遇到O进行并查集操作合并
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        // 边界上的O,把它和dummyNode 合并成一个连通区域.
                        uf.union(node(i, j), dummyNode);
                    } else {
                        // 和上下左右合并成一个连通区域.
                        if (i > 0 && board[i - 1][j] == 'O')
                            uf.union(node(i, j), node(i - 1, j));
                        if (i < rows - 1 && board[i + 1][j] == 'O')
                            uf.union(node(i, j), node(i + 1, j));
                        if (j > 0 && board[i][j - 1] == 'O')
                            uf.union(node(i, j), node(i, j - 1));
                        if (j < cols - 1 && board[i][j + 1] == 'O')
                            uf.union(node(i, j), node(i, j + 1));
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (uf.isConnected(node(i, j), dummyNode)) {
                    // 和dummyNode 在一个连通区域的,那么就是O；
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int node(int i, int j) {
        return i * cols + j;
    }

    class UnionFind {
        int[] parents;

        public UnionFind(int totalNodes) {
            parents = new int[totalNodes];
            for (int i = 0; i < totalNodes; i++) {
                parents[i] = i;
            }
        }

        // 合并连通区域是通过find来操作的, 即看这两个节点是不是在一个连通区域内.
        void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                parents[root2] = root1;
            }
        }

        int find(int node) {
            while (parents[node] != node) {
                // 当前节点的父节点 指向父节点的父节点.
                // 保证一个连通区域最终的parents只有一个.
                parents[node] = parents[parents[node]];
                node = parents[node];
            }

            return node;
        }

        boolean isConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }
    }

    public static void main(String[] args) {
        被围绕的区域 area = new 被围绕的区域();
        char m[][] = {{'O', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        area.solve(m);
    }
}
