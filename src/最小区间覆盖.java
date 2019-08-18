import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 最小区间覆盖 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int L = sc.nextInt();
        int pos[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            pos[i][0] = sc.nextInt();
            pos[i][1] = sc.nextInt();
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        };
        Arrays.sort(pos, comparator);
        if (pos[0][0] != 0) {
            System.out.println(-1);
        }
        int num = 0;
        int start = 0;
        int end = -1;
        int id = 0;
        while (id < n) {
            while (id < n && pos[id][0] <= start) {
                end = Math.max(pos[id][1], end);
                id++;
            }
            num++;
            start = end;
            if (end >= L) {
                break;
            }
        }
        if (end < L) {
            System.out.println(-1);
        }
        System.out.println(num);
    }
}
