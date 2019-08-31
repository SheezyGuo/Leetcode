import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class 单源最短路径 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int t = sc.nextInt();
                m[i][j] = t >= 0 ? t : Integer.MAX_VALUE;
            }
        }
        int i = sc.nextInt();
        int j = sc.nextInt();
        int dist[] = new int[n];
        int path[] = new int[n];
        Set<Integer> cur = new HashSet<>();
        Set<Integer> rest = new HashSet<>();
        cur.add(i);
        for (int k = 0; k < n; k++) {
            dist[k] = m[i][k];
            path[k] = -1;
            if (k != i) {
                rest.add(k);
            }
        }
        while (!rest.isEmpty()) {
            int min = Integer.MAX_VALUE;
            int cho = -1;
            for (int k : rest) {
                if (dist[k] < min) {
                    min = dist[k];
                    cho = k;
                }
            }
            int pre = -1;
            for (int k : cur) {
                if (m[k][cho] != 0 && m[k][cho] != Integer.MAX_VALUE) {
                    pre = k;
                    break;
                }
            }
            if (cho == -1) {
                break;
            }
            path[cho] = pre;
            for (int k = 0; k < n; k++) {
                if (m[cho][k] != Integer.MAX_VALUE && dist[k] > dist[cho] + m[cho][k]) {
                    dist[k] = dist[cho] + m[cho][k];
                }
            }
            cur.add(cho);
            rest.remove(cho);
        }
        System.out.println(dist[j]);
        LinkedList<Integer> p = new LinkedList<>();
        p.add(j + 1);
        int c = j;
        while (path[c] != -1) {
            p.addFirst(path[c] + 1);
            c = path[c];
        }
        System.out.println(p);
    }
}
