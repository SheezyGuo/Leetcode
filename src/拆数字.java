import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 拆数字 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<List<Integer>> result = new ArrayList<>();
            LinkedList<Integer> temp = new LinkedList<>();
            if (m < 0 || n < m) {
                System.out.println(result);
            }
            split(n, m, 1, temp, result);
            for (List<Integer> l : result) {
                System.out.println(l.toString());
            }
        }
    }

    private static void split(int n, int m, int cur, LinkedList<Integer> temp, List<List<Integer>> result) {
        if (m == 0 && n == 0) {
//            result.add(new ArrayList<>(temp));
            System.out.println(temp);
            return;
        }
        for (int candidate = cur; candidate <= n; candidate++) {
            for (int i = 1; i <= Math.min(m, n / candidate); i++) {
                for (int j = 0; j < i; j++) {
                    temp.addLast(candidate);
                }
                split(n - i * candidate, m - i, candidate + 1, temp, result);
                for (int j = 0; j < i; j++) {
                    temp.removeLast();
                }
            }
        }
    }
}


