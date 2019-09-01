import java.util.*;

public class 京东 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean m[][] = new boolean[N + 1][N + 1];
        int boy[] = new int[N + 1];
        int girl[] = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int x = Math.min(X, Y);
            int y = Math.max(X, Y);
            m[x][y - N] = true;
            boy[x]++;
            girl[y - N]++;
        }
        List<Integer> result = new ArrayList<>();
        while (check(boy, girl)) {
            int info[] = findMax(boy, girl);
            int flag = info[0];
            int index = info[1];
            result.add(flag * N + index);
            modify(boy, girl, m, info);
        }
        result.sort(Comparator.naturalOrder());
        String[] s = new String[result.size()];
        for (int i = 0; i < s.length; i++) {
            s[i] = result.get(i).toString();
        }
        System.out.println(s.length);
        System.out.println(String.join(" ", s));
    }

    private static int[] findMax(int[] b, int[] g) {
        int max = 0;
        int index = 0;
        int flag = 0;
        for (int i = 1; i < b.length; i++) {
            if (b[i] > max) {
                max = b[i];
                index = i;
                flag = 0;
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (g[i] > max) {
                max = g[i];
                index = i;
                flag = 1;
            }
        }
        return new int[]{flag, index};
    }

    private static boolean check(int[] b, int[] g) {
        for (int i = 1; i < b.length; i++) {
            if (b[i] != 0 || g[i] != 0) {
                return true;
            }
        }
        return false;
    }

    private static void modify(int[] b, int[] g, boolean[][] m, int[] info) {
        int flag = info[0];
        int index = info[1];
        if (flag == 0) {
            for (int j = 1; j < g.length; j++) {
                if (m[index][j]) {
                    if (g[j] > 0) {
                        g[j]--;
                    }
                }
            }
            b[index] = 0;
        } else {
            for (int i = 1; i < b.length; i++) {
                if (m[i][index]) {
                    if (b[i] > 0) {
                        b[i]--;
                    }
                }
            }
            g[index] = 0;
        }
    }
}
