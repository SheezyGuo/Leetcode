import java.util.Comparator;
import java.util.PriorityQueue;

public class 数字1的个数 {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int result = 0;
        String t = String.valueOf(n);
        for (int i = 0; i < t.length(); i++) {
            result += parse(t, i);
        }
        return result;
    }

    private static int parse(String t, int pos) {
        pos = t.length() - pos - 1;
        String lefts = t.substring(0, pos);
        String rights = t.substring(pos + 1);
        int lsize = lefts.length(), rsize = rights.length();
        int left = lsize == 0 ? 0 : Integer.valueOf(lefts);
        int right = rsize == 0 ? 0 : Integer.valueOf(rights);
        char p = t.charAt(pos);
        int result;
        if (p > '1') {
            result = (left + 1) * ((int) Math.pow(10, rsize));
        } else if (p == '1') {
            result = left * ((int) Math.pow(10, rsize)) + right + 1;
        } else {
            result = left * ((int) Math.pow(10, rsize));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(21345));
    }
}
