import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class 头条 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                val = val >= 3 ? 1 : 0;
                m[i][j] = val;
            }
        }
        Set<Integer> used = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        Set<Integer> rest = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            rest.add(i);
        }
        while (!rest.isEmpty()) {
            int tcur = 0, tnei = 0;
            boolean find = false;
            for (int cur : rest) {
                for (int nei : rest) {
                    if (cur != nei && m[cur][nei] != 0) {
                        tcur = cur;
                        tnei = nei;
                        find = true;
                    }
                }
            }
            if (!find) {
                count++;
                break;
            }
            used.add(tcur);
            Iterator<Integer> iterator = rest.iterator();
            while (iterator.hasNext()) {
                int j = iterator.next();
                if (m[tcur][j] != 0) {
                    temp.add(j);
                    iterator.remove();
                }
            }
            while (!temp.isEmpty()) {
                Iterator<Integer> iiterator = temp.iterator();
                Set<Integer> tempadd = new HashSet<>();
                while (iiterator.hasNext()) {
                    int i = iiterator.next();
                    iiterator.remove();
                    used.add(i);
                    Iterator<Integer> jiterator = rest.iterator();
                    while (jiterator.hasNext()) {
                        int j = jiterator.next();
                        if (m[i][j] != 0) {
                            tempadd.add(j);
                            jiterator.remove();
                        }
                    }
                }
                temp.addAll(tempadd);
            }
            count++;
        }
        System.out.println(count);
    }
}
