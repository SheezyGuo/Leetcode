import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 进制组合 {

    public static Map<Character, Integer> map;

    static {
        map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);

    }

    //  8  2 7777771111
    //  2  8 1111177777

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int r1 = sc.nextInt();
            int r2 = sc.nextInt();
            String repr = sc.next();
            int left = 0;
            int right = repr.length() - 1;
            if (r1 > r2) {
                for (int i = repr.length() - 1; i >= 0; i--) {
                    if (map.get(repr.charAt(i)) >= r2) {
                        left = i;
                        break;
                    }
                }
                for (int s = left; s <= right; s++) {
                    int res = check(repr, s, r1, r2);
                    if (res != -1) {
                        System.out.println(res);
                        break;
                    }
                }
            } else {
                for (int i = 0; i < repr.length(); i++) {
                    if (map.get(repr.charAt(i)) >= r1) {
                        right = i;
                        break;
                    }
                }
                for (int s = left; s <= right; s++) {
                    int res = check(repr, s, r1, r2);
                    if (res != -1) {
                        System.out.println(res);
                        break;
                    }
                }
            }
        }
    }

    private static int check(String str, int part, int r1, int r2) {
        if (part == 0 || part >= str.length() - 1) {
            return -1;
        }
        String left = str.substring(0, part + 1);
        String right = str.substring(part + 1);
        int b1 = Integer.parseInt(left, r1);
        int b2 = Integer.parseInt(right, r2);
        return b1 == b2 ? b1 : -1;
    }
}
