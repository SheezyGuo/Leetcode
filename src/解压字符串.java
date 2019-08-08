import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 解压字符串 {

    public static void main(String[] args) {
        String test = "A2BD((AB)2)3A2B2";
        String parts[] = split(test);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
        }
    }

    private static String expand(String str, StringBuilder sb) {
        if (str.matches("[A-Z]")) {
            sb.append(str);
            return str;
        } else if (str.matches("[A-Z]\\d+")) {
            char c = str.charAt(0);
            int n = Integer.parseInt(str.substring(1));
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(c);
            }
            sb.append(stringBuilder.toString());
            return stringBuilder.toString();
        } else {

        }
        return null;
    }

//    private static void expandBracket(String str, StringBuilder sb) {
//        if()
//        int e = match(str, 0);
//        e++;
//        String core = str.substring(0, e);
//        int n = Integer.parseInt(str.substring(e));
//
//    }


    private static int match(String str, int start) {
        int depth = 0;
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                depth++;
            } else if (str.charAt(i) == ')') {
                depth--;
                if (depth == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static String[] split(String str) {
        List<String> parts = new ArrayList<>();
        int s = 0;
        int i = 0;
        int len = str.length();
        while (i < len) {
            char c = str.charAt(i);
            if (isAlpha(c)) {
                i++;
                if (i < len) {
                    if (isAlpha(str.charAt(i))) {
                        ;
//                        parts.add(str.substring(s, i));
//                        s = i;
                    } else if (isDigital(str.charAt(i))) {
                        while (i < len && isDigital(str.charAt(i))) {
                            i++;
                        }
//                        parts.add(str.substring(s, i));
//                        s = i;
                    } else if (str.charAt(i) == '(') {
                        ;
                    }
                } else {
                    ;
                }
                parts.add(str.substring(s, i));
                s = i;
            } else if (c == '(') {
                i = match(str, i);
                if (i == -1) {
                    System.err.println("i==-1");
                    return null;
                }
                i++;
                while (i < len && isDigital(str.charAt(i))) {
                    i++;
                }
                parts.add(str.substring(s, i));
                s = i;
            }
        }
        return parts.toArray(new String[parts.size()]);
    }

    private static boolean isAlpha(char c) {
        return c <= 'Z' && c >= 'A';
    }

    private static boolean isDigital(char c) {
        return c >= '0' && c <= '9';
    }


}
