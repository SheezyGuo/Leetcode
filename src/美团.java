import java.util.*;

public class 美团 {


    static class T1 {
        static Map<Integer, String> map;
        static Map<Integer, String> map2;

        static {
            map = new HashMap<>();
            map2 = new HashMap<>();
            map.put(0, "零");
            map.put(1, "壹");
            map.put(2, "贰");
            map.put(3, "叁");
            map.put(4, "肆");
            map.put(5, "伍");
            map.put(6, "陆");
            map.put(7, "柒");
            map.put(8, "捌");
            map.put(9, "玖");
            map2.put(0, "千");
            map2.put(1, "百");
            map2.put(2, "十");
            map2.put(3, "");
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String line = sc.next();
            line = line.substring(1, line.length() - 1);
            String[] nums = line.split(",");
            List<String> list = new ArrayList<>();
            for (String num : nums) {
                num = num.substring(1, num.length() - 1);
                String[] parts = num.split("\\.");
                int[] head = new int[13];
                int[] tail = new int[2];
                boolean zhen = false;
                if (parts.length == 1 || parts[1].equals("0") || parts[1].equals("00")) {
                    zhen = true;
                }
                int len = parts[0].length();
                for (int i = parts[0].length() - 1; i >= 0; i--) {
                    head[12 - (parts[0].length() - 1 - i)] = parts[0].charAt(i) - '0';
                }
                if (len == 13) {
                    list.add("\"壹万亿元整\"");
                }
                String temp = "";
                temp += printSub(head, 1, 4);
                if (!temp.isEmpty()) {
                    temp += "亿";
                }
                String next = printSub(head, 5, 8);
                if (!temp.isEmpty() && !next.isEmpty() && head[5] == 0) {
                    next = "零" + next;
                }
                temp += next;
                if (!temp.isEmpty()) {
                    temp += "万";
                }
                next = printSub(head, 9, 12);
                if (!temp.isEmpty() && !next.isEmpty() && head[9] == 0) {
                    next = "零" + next;
                }
                temp += next;
                temp += "元";
                if (zhen) {
                    temp += "整";
                } else {
                    for (int i = parts[1].length() - 1; i >= 0; i--) {
                        tail[1 - (parts[1].length() - 1 - i)] = parts[1].charAt(i) - '0';
                    }
                    temp += map.get(tail[0]) + "角";
                    temp += map.get(tail[1]) + "分";
                }
                list.add(String.format("\"%s\"", temp));
            }
            System.out.println(list);
        }

        private static String printSub(int[] arr, int from, int to) {
            String res = "";
            boolean None = true;
            int i = 0;
            for (i = 0; i < 4; i++) {
                if (arr[i + from] != 0) {
                    None = false;
                    break;
                }
            }
            if (None) {
                return res;
            }
            while (i < 4) {
                int pos = i + from;
                if (arr[pos] > 0) {
                    res += map.get(arr[pos]) + map2.get(i);
                } else {
                    if (!res.endsWith("零")) {
                        res += "零";
                    }
                }
                i++;
            }
            while (res.endsWith("零")) {
                res = res.substring(0, res.length() - 1);
            }
            return res;
        }
    }


    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.main(null);
    }

}


