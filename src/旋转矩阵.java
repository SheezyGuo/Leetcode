public class 旋转矩阵 {
    public static void rotate(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return;
        }
        int len = m.length;
        int depth = len / 2;
        for (int d = 0; d < depth; d++) {
            for (int i = d; i < len - 1 -d; i++) {
                int x = d, y = i, nx = 0, ny = 0;
                int rec = m[x][y];
                for (int j = 0; j < 3; j++) {
                    // 顺时针转 (x,y)-->(y,n-1-x)
                    // 逆时针转 (x,y)-->(n-1-y,x)
                    nx = len - 1 - y;
                    ny = x;
                    m[x][y] = m[nx][ny];
                    x = nx;
                    y = ny;
                }
                m[x][y] = rec;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(a);
        System.out.println(a);
    }
}
