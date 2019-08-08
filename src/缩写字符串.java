import java.util.Scanner;

public class 缩写字符串 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            String line = sc.nextLine();
            System.out.println(compress(line));
        }
    }

    private static String compress(String str) {
        if (str.length() < 4) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char[] carr = str.toCharArray();
        for (int i = 0; i < carr.length; ) {
            int j = i + 1;
            int count = 0;
            while (j < carr.length && carr[j] - carr[j - 1] == 1) {
                count++;
                j++;
            }
            if (count < 3) {
                sb.append(str.substring(i, j));
            } else {
                sb.append(String.format("%c-%c", carr[j - count - 1], carr[j - 1]));
            }
            i = j;
        }
        return sb.toString();
    }
}
