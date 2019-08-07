import java.text.DecimalFormat;
import java.util.Scanner;

public class 游走的机器人 {

    //思路：利用三维数组
    //      dp[i%2][j][k]表示走了i步之后恰好有j个红色格子，并且此时机器人正好在第k个红色格子上的概率。时间复杂度O(n^3)
    //      只使用i%2的原因是，现在只和前一个情况有关

    public static void main(String[] args) {
        int maxn = 500 + 5;
        double[][][] dp = new double[2][maxn][maxn];
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   // 走的步数
        double ans = 0;
        dp[0][1][0] = 1.0;  // 第0步，有一个红格子，在第0个红格子上,的概率为1
        for (int i = 1; i <= n; i++) {
            int cur = i % 2;     // 0,1,0,1...
            int old = 1 - (i % 2);
            for (int j = 1; j <= i; j++)    // 现在是第n次，则第-1次最多是有n个格子
                for (int k = 0; k < j; k++) {
                    dp[cur][j][k] = 0;   // 上上次的结果设为0
                }
            for (int j = 1; j <= i; j++) {     // 第i步的红色格子数目至多为i个
                for (int k = 0; k < j; k++) {  //
                    if (dp[old][j][k] > 0) {
                        // 往右走
                        int pos1 = j;   // 现在有的格子数
                        int pos2 = k + 1; // 现在的位置是在k+1
                        if (pos1 == pos2)  // 在有边界的条件，接下来右边会多一个空格的可能。k=j-1时。
                            ++pos1;     // 多一个空格
                        dp[cur][pos1][pos2] += 0.5 * dp[old][j][k];
                        // 往左走
                        int pos3 = j;
                        int pos4 = k - 1;
                        if (pos4 == -1) {  // 边界条件，在位置-1的时候
                            pos3++;    // 格子数增加1
                            pos4++;    // 把-1的那个格子记为第0个格子~
                        }
                        dp[cur][pos3][pos4] += 0.5 * dp[old][j][k];
                    }
                }
            }
        }
        // 知道概率以后求期望
        for (int i = 1; i <= n + 1; i++) {   // 走n步，至多有n+1个格子
            for (int j = 0; j < i; j++) {  // 在第j个格子上
                ans += i * dp[n % 2][i][j];
            }
        }
        DecimalFormat f = new DecimalFormat("0.0");
        System.out.print(f.format(ans));
    }


}
