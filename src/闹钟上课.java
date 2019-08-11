import java.util.Arrays;
import java.util.Scanner;

public class 闹钟上课 {
    // 本题为考试多行输入输出规范示例，无需提交，不计分。

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] realmins = new int[N];
        int h = 0, m = 0;
        for (int i = 0; i < N; i++) {
            h = sc.nextInt();
            m = sc.nextInt();
            realmins[i] = h * 60 + m;
        }
        Arrays.sort(realmins);
        int cost = sc.nextInt();
        int eh = sc.nextInt();
        int hm = sc.nextInt();
        int tar = eh * 60 + hm - cost;
        int i = 0, j = N - 1;
        int pos = 0;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (realmins[mid] > tar) {
                j = mid - 1;
            } else if (realmins[mid] < tar) {
                pos = mid;
                i = mid + 1;
            } else {
                pos = mid;
                break;
            }
        }
        System.out.printf("%d %d", realmins[pos] / 60, realmins[pos] % 60);
    }
}
