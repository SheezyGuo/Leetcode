import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 个税 {
    private static Map<Integer, Integer> map;

    static {
        map = new HashMap<>();
        map.put(5000, 0);
        map.put(8000, 90);
        map.put(17000, 990);
        map.put(30000, 3590);
        map.put(40000, 6090);
        map.put(60000, 12090);
        map.put(85000, 20840);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int num = sc.nextInt();
            double res = 0;
            if (num >= 85000) {
                res = map.get(85000) + (num - 85000) * 0.45;
            } else if (num >= 60000) {
                res = map.get(60000) + (num - 60000) * 0.35;
            } else if (num >= 40000) {
                res = map.get(40000) + (num - 40000) * 0.30;
            } else if (num >= 30000) {
                res = map.get(30000) + (num - 30000) * 0.25;
            } else if (num >= 17000) {
                res = map.get(17000) + (num - 17000) * 0.20;
            } else if (num >= 8000) {
                res = map.get(8000) + (num - 8000) * 0.10;
            } else if (num >= 5000) {
                res = map.get(5000) + (num - 5000) * 0.03;
            } else {
                res = 0;
            }
            int r = (int) Math.round(res);
            System.out.println(r);
        }
    }
}

