// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.Arrays;
import java.util.Scanner;

public class 网易 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] scores = new int[num];
        int[] sorted = new int[num];
        for (int i = 0; i < num; i++) {
            scores[i] = sc.nextInt();
            sorted[i] = scores[i];
        }
        Arrays.sort(sorted);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt() - 1;
            int a = 0, b = num - 1;
            int t = scores[s];
            int pos = 0;
            while (a <= b) {
                int mid = (b - a) / 2 + a;
                if (sorted[mid] < t) {
                    a = mid + 1;
                } else if (sorted[mid] > t) {
                    b = mid - 1;
                } else {
                    pos = mid;
                    break;
                }
            }
            while (pos < num - 1 && sorted[pos] == sorted[pos + 1]) {
                pos++;
            }
            System.out.printf("%.6f\n", (double) pos / num * 100);
        }
    }


//// 9 10 33 332 331 3
//// 2 0 0 0 0 4 1
//// 1 0 0 0 0 4 2
//// 4 0 0 0 0 1 2
//// 4 0 0 0 0 2 1
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        List<String> odd = new ArrayList<>();
//        List<String> even = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            int r = sc.nextInt();
//            if (r % 2 == 0) {
//                even.add(String.valueOf(r));
//            } else {
//                odd.add(String.valueOf(r));
//            }
//        }
//        if (even.isEmpty()) {
//            System.out.println(String.join(" ", odd));
//            return;
//        } else if (odd.isEmpty()) {
//            System.out.println(String.join(" ", even));
//            return;
//        }
//        Comparator<String> comparator = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int len1 = o1.length();
//                int len2 = o2.length();
//                StringBuilder sb = new StringBuilder();
//                char end = 0;
//                if (len2 > len1) {
//                    end = o1.charAt(len1 - 1);
//                    for (int i = 0; i < len2 - len1; i++) {
//                        sb.append(end);
//                    }
//                    o1 = o1 + sb.toString();
//                } else {
//                    end = o2.charAt(len2 - 1);
//                    for (int i = 0; i < len1 - len2; i++) {
//                        sb.append(end);
//                    }
//                    o2 = o2 + sb.toString();
//                }
//                return o1.compareTo(o2);
//            }
//        };
//        List<String> all = new ArrayList<>();
//        all.addAll(odd);
//        all.addAll(even);
//        all.sort(comparator);
//        System.out.println(String.join(" ", all));
//    }
}
