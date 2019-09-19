import java.util.Scanner;

public class 百度 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.main(null);
    }

    private static class T1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        HashMap<Integer, Integer> map = new HashMap<>(n);
//        for (int i = k + 2; i <= n; i += 2) {
//            map.put(i, readMap(map, (i - k) / 2, k) + readMap(map, (i - k) / 2 + k, k));
//        }
//        System.out.println(readMap(map, n, k));
//    }
//
//    public static int readMap(HashMap<Integer, Integer> map, int num, int k) {
//        if (num == 0) {
//            return 0;
//        }
//        if (num < k + 2) {
//            return 1;
//        }
//        return map.getOrDefault(num, 1);
//    }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();
            int dp[] = new int[n + 1];
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                if (i > k && ((i - k) % 2 == 0)) {
                    dp[i] = dp[(i - k) / 2] + dp[(i - k) / 2 + k];
                } else {
                    dp[i] = 1;
                }
            }
            System.out.println(dp[n]);
        }
    }

    private static class T2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int cash[] = new int[n];
            int num[] = new int[n];
            for (int i = 0; i < n; i++) {
                cash[i] = sc.nextInt();
                num[i] = sc.nextInt();
            }
            int sum[] = new int[]{0};

        }

        public static void pay(int[] cash, int[] num, int[] sum, int n) {

        }

    }
}

