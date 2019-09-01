import java.util.*;

public class 快手 {

//    public static int compareVersion(String version1, String version2) {
//        String[] parts1 = version1.split("\\.");
//        String[] parts2 = version2.split("\\.");
//        int minlen = Math.min(parts1.length, parts2.length);
//        for (int i = 0; i < minlen; i++) {
//            int n1 = Integer.parseInt(parts1[i]);
//            int n2 = Integer.parseInt(parts2[i]);
//            if (n1 != n2) {
//                return n1 > n2 ? 1 : -1;
//            }
//        }
//        if (parts1.length > minlen) {
//            for (int i = minlen; i < parts1.length; i++) {
//                int n = Integer.parseInt(parts1[i]);
//                if (n != 0) {
//                    return 1;
//                }
//            }
//        } else if (parts2.length > minlen) {
//            for (int i = minlen; i < parts2.length; i++) {
//                int n = Integer.parseInt(parts2[i]);
//                if (n != 0) {
//                    return -1;
//                }
//            }
//        }
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        while (n-- > 0) {
//            String v1 = sc.next();
//            String v2 = sc.next();
//            int state = compareVersion(v1, v2);
//            if (state <= -1) {
//                System.out.println("true");
//            } else {
//                System.out.println("false");
//            }
//        }
//    }


    //    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        String[] parts1 = line.split(" ");
//        line = sc.nextLine();
//        String[] parts2 = line.split(" ");
//        int len1 = parts1.length;
//        int len2 = parts2.length;
//        int i = 0, j = 0;
//        while (i < len1 && j < len2) {
//            for (int k = 0; k < 4 && i < len1; k++) {
//                System.out.printf("%s ", parts1[i++]);
//            }
//            System.out.printf("%s ", parts2[j++]);
//        }
//        while (i < len1) {
//            if (i == len1 - 1) {
//                System.out.print(parts1[i]);
//            } else {
//                System.out.printf("%s ", parts1[i]);
//            }
//            i++;
//        }
//        while (j < len2) {
//            if (j == len2 - 1) {
//                System.out.print(parts2[j]);
//            } else {
//                System.out.printf("%s ", parts2[j]);
//            }
//            j++;
//        }
//    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        while (n-- > 0) {
//            int num = sc.nextInt();
//            boolean res = check(num);
//            if (res) {
//                System.out.println("true");
//            } else {
//                System.out.println("false");
//            }
//        }
//    }
//
//    private static boolean check(int n) {
//        HashSet<Integer> set = new HashSet<>();
//        do {
//            set.add(n);
//            n = calc(n);
//            if (n == 1) {
//                return true;
//            }
//            if (set.contains(n)) {
//                return false;
//            }
//        } while (true);
//    }
//
//    private static int calc(int n) {
//        int sum = 0;
//        while (n != 0) {
//            int cur = n % 10;
//            n = n / 10;
//            sum += cur * cur;
//        }
//        return sum;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<List<Integer>> record = new LinkedList<>();
        while (--n > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int flag = sc.nextInt();
            // not black
            if (flag == 0) {
                if (i < j) {
                    record.add(Arrays.asList(i, j));
                } else {
                    record.add(Arrays.asList(j, i));
                }
            }
        }
        Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0) != o2.get(0)) {
                    return o1.get(0) - o2.get(0);
                } else {
                    return o1.get(1) - o2.get(1);
                }
            }
        };
        record.sort(comparator);
    }

    private static List<Set<Integer>> find(List<List<Integer>> record) {
        List<Set<Integer>> result = new ArrayList<>();
        return result;
    }
}
