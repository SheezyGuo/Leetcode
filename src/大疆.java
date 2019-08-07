import java.util.*;

public class 大疆 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int D = sc.nextInt();
            int value[] = new int[N];
            int time[] = new int[N];
            for (int i = 0; i < N; i++) {
                value[i] = sc.nextInt();
                time[i] = sc.nextInt();
            }
            int max = 0;
            int dp[] = new int[D + 1];
            // dp[0]=0的处理
            // 要么判断,int dp[] = new int[D];下标为-1时的值为0
            // 要么dp数组多一位来表示dp[0]
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= D; j++) {
                    if (j >= time[i]) {
                        dp[j] = Math.max(dp[j], dp[j - time[i]] + value[i]);
                        if (dp[j] > max) {
                            max = dp[j];
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String key = sc.next();
                String value = sc.next();
                map.put(key, value);
            }
            for (int i = 0; i < M; i++) {
                System.out.println(map.get(sc.next()));
            }
        }
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int N = sc.nextInt();
        int val[] = new int[N];
        for (int i = 0; i < N; i++) {
            val[i] = sc.nextInt();
        }
        int likeNum = sc.nextInt();
        int like[] = new int[likeNum];
        for (int i = 0; i < likeNum; i++) {
            like[i] = sc.nextInt() - 1;
        }
        List<Integer> order = new ArrayList<>();
        List<Integer> other = new ArrayList<>();
        for (int i : like) {
            order.add(i);
        }
        for (int i = 0; i < N; i++) {
            if (!order.contains(i)) {
                other.add(i);
            }
        }
        int[] count = new int[1];
        count[0] = 0;
        find(val, count, order, other, Integer.MAX_VALUE, V, 0, Integer.MAX_VALUE);
        System.out.println(count[0] % 10000007);
    }

    private static void find(int[] value, int[] count, List<Integer> order, List<Integer> other, int otherMax, int target, int depth, int preBuyNum) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            count[0]++;
            if (count[0] > 10000007) {
                count[0] %= 10000007;
            }
            return;
        }
        if (depth >= value.length) {
            return;
        }
        if (depth < order.size()) {
            int curMax = target / value[order.get(depth)];
            int maxIter = Math.min(Math.max(preBuyNum - 1, 0), curMax);
            for (int i = 0; i <= maxIter; i++) {
                otherMax = depth == order.size() - 1 ? i : otherMax;
                find(value, count, order, other, otherMax, target - value[order.get(depth)] * i, depth + 1, i);
            }
        } else {
            int curMax = target / value[order.get(depth)];
            int maxIter = Math.min(otherMax, curMax);
            for (int i = 0; i <= maxIter; i++) {
                otherMax = depth == order.size() - 1 ? i : otherMax;
                find(value, count, order, other, otherMax, target - value[other.get(depth - order.size())] * i, depth + 1, i);
            }
        }
    }
}
