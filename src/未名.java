import java.util.*;

public class 未名 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] aStr = sc.nextLine().split(" ");
//        String[] bStr = sc.nextLine().split(" ");
//        int[] A = new int[aStr.length];
//        int[] B = new int[bStr.length];
//        for (int i = 0; i < aStr.length; i++) {
//            A[i] = Integer.valueOf(aStr[i]);
//        }
//        for (int i = 0; i < bStr.length; i++) {
//            B[i] = Integer.valueOf(bStr[i]);
//        }
//        int a = aStr.length;
//        int b = bStr.length;
//        Integer pre = null;
//        Integer next = null;
//        int i = 0;
//        for (; i < a; i++) {
//            if (pre == null) {
//                pre = A[i];
//                continue;
//            }
//            if (A[i] <= pre) {
//                next = i < a - 1 ? A[i + 1] : null;
//                break;
//            } else {
//                pre = A[i];
//            }
//        }
//        Arrays.sort(B);
//        if (B[b - 1] <= pre) {
//            System.out.println("NO");
//            return;
//        }
//        int result = 0;
//        int j = 0;
//        while (j < b && B[j] <= pre) {
//            j++;
//        }
//        if (next == null) {
//            result = B[b - 1];
//        } else {
//            if (B[j] >= next) {
//                System.out.println("NO");
//                return;
//            }
//            while (j < b && B[j] < next) {
//                j++;
//            }
//            if (j == b) {
//                j--;
//            }
//            result = B[j];
//        }
//        A[i] = result;
//        for (int k = 0; k < a; k++) {
//            if (k != a - 1) {
//                System.out.printf("%d ", A[k]);
//            } else {
//                System.out.printf("%d", A[k]);
//            }
//        }
//    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] parts = line.split(" ");
        Map<Character, Integer> mapout = new HashMap<>();
        Map<Character, Integer> mapin = new HashMap<>();
        for (String part : parts) {
            char fisrt = part.charAt(0);
            char last = part.charAt(part.length() - 1);
            if (mapout.entrySet().contains(fisrt)) {
                mapout.put(fisrt, mapout.get(fisrt) + 1);
            } else {
                mapout.put(fisrt, 1);
            }
            if (mapin.entrySet().contains(last)) {
                mapin.put(last, mapin.get(last) + 1);
            } else {
                mapin.put(last, 1);
            }
        }
        System.out.println(mapin.equals(mapout) ? "True" : "False");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int time[] = new int[N];
        for (int i = 0; i < N; i++) {
            time[i] = sc.nextInt();
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < M; i++) {
            int in = sc.nextInt();
            int out = sc.nextInt();
            if (map.entrySet().contains(out)) {
                map.get(out).add(in);
            } else {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(in);
                map.put(out, temp);
            }
        }
        for (Integer i : map.keySet()) {

        }
    }

}