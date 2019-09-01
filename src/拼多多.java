import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class 拼多多 {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        String[] parts = line.split(";");
//        String[] nums = parts[0].split(",");
//        List<Integer> odd = new LinkedList<>();
//        List<Integer> even = new LinkedList<>();
//        int N = Integer.parseInt(parts[1]);
//        for (int i = 0; i < nums.length; i++) {
//            int n = Integer.parseInt(nums[i]);
//            if (n % 2 == 1) {
//                odd.add(n);
//            } else {
//                even.add(n);
//            }
//        }
//        odd.sort(Comparator.reverseOrder());
//        even.sort(Comparator.reverseOrder());
//        String[] ans = new String[N];
//        int i = 0;
//        int es = even.size();
//        while (i < N && i < es) {
//            ans[i] = even.get(i).toString();
//            i++;
//        }
//        while (i < N) {
//            ans[i] = odd.get(i - es).toString();
//            i++;
//        }
//        System.out.println(String.join(",", ans));
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int k = sc.nextInt();
//        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                int val = i * j;
//                if (map.containsKey(val)) {
//                    map.put(val, map.get(val) + 1);
//                } else {
//                    map.put(val, 1);
//                }
//            }
//        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (k <= entry.getValue()) {
//                System.out.println(entry.getKey());
//                return;
//            } else {
//                k -= entry.getValue();
//            }
//        }
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        while (n-- > 0) {
//            String s1 = sc.next();
//            String s2 = sc.next();
//            LinkedList<String> res = new LinkedList<>();
//            change(s1, "", s2, 0, s1.length(), new LinkedList<Character>(), res);
//            res.sort(Comparator.naturalOrder());
//            System.out.println("{");
//            for (String s : res) {
//                System.out.println(s);
//            }
//            System.out.println("}");
//        }
//    }
//
//
//    private static void change(String s, String m, String t, int step, int max, LinkedList<Character> ops, LinkedList<String> res) {
//        if (step == max) {
//            if (m.equals(t)) {
//                StringBuilder sb = new StringBuilder();
//                for (Character c : ops) {
//                    sb.append(c);
//                    sb.append(" ");
//                }
//                sb.deleteCharAt(sb.length() - 1);
//                res.add(sb.toString());
//                return;
//            } else {
//                return;
//            }
//        }
//        if (s.isEmpty()) {
//            return;
//        }
//        String tail = s.substring(step, step + 1);
//        ops.addLast('d');
//        change(s, m, t, step + 1, max, ops, res);
//        ops.removeLast();
//        ops.addLast('l');
//        change(s, tail + m, t, step + 1, max, ops, res);
//        ops.removeLast();
//        ops.addLast('r');
//        change(s, m + tail, t, step + 1, max, ops, res);
//        ops.removeLast();
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int xi[] = new int[n];
        int ni[] = new int[n];
        Arrays.fill(ni, 1);
        for (int i = 0; i < n; i++) {
            xi[i] = sc.nextInt();
        }
        BigDecimal sum[] = new BigDecimal[]{BigDecimal.valueOf(0)};
        BigDecimal mul = BigDecimal.valueOf(1);
        for (int num : xi) {
            mul = mul.multiply(BigDecimal.valueOf(num));
        }
        scroll(0, n, xi, ni, sum);
        BigDecimal r = sum[0].divide(mul, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(r);
    }

    private static void scroll(int pos, int max, int[] xi, int[] ni, BigDecimal[] sum) {
        if (pos == max) {
            int MAX = 0;
            for (int n : ni) {
                if (n > MAX) {
                    MAX = n;
                }
            }
            sum[0] = sum[0].add(BigDecimal.valueOf(MAX));
            return;
        }
        for (int n = 1; n <= xi[pos]; n++) {
            ni[pos] = n;
            scroll(pos + 1, max, xi, ni, sum);
        }
    }
}