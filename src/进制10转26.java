import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 进制10转26 {
    public static Map<Integer, Character> map;

    static {
        map = new HashMap<Integer, Character>();
        for (int i = 1; i <= 26; i++) {
            map.put(i, (char) ('A' - 1 + i));
        }
    }

    public String convertToTitle(int n) {
        LinkedList<Character> list = new LinkedList<>();
        while (n != 0) {
            list.addFirst(map.get(n % 26 == 0 ? 26 : n % 26));
            n = (n - 1) / 26;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
