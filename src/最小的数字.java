import java.util.ArrayList;
import java.util.Comparator;

public class 最小的数字 {

    public static String PrintMinNumber(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(String.valueOf(i));
        }
        // 3 > 332,3 < 334
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                StringBuilder sb = new StringBuilder();
                if (len1 > len2) {
                    char end = o2.charAt(len2 - 1);
                    for (int i = 0; i < len1 - len2; i++) {
                        sb.append(end);
                    }
                    o2 = o2 + sb.toString();
                } else if (len1 < len2) {
                    char end = o1.charAt(len1 - 1);
                    for (int i = 0; i < len1 - len2; i++) {
                        sb.append(end);
                    }
                    o1 = o1 + sb.toString();
                }
                return o1.compareTo(o2);

            }
        };
        list.sort(comparator);
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] a = new int[]{3334, 3, 3332};
        System.out.println(PrintMinNumber(a));
        System.out.println("3".compareTo("323"));
        System.out.println("3".compareTo("34"));
    }
}
