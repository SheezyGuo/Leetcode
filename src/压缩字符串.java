import java.util.LinkedList;
import java.util.Scanner;

public class 压缩字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        LinkedList<String> stack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {

            if ((!Character.isDigit(str.charAt(i))) && str.charAt(i) != '|') {
                stack.push(String.valueOf(str.charAt(i)));
            } else if (str.charAt(i) == '|') {
                String num = "";
                String s = "";
                i = i - 1;
                while (str.charAt(i) != '[') {
                    num = str.charAt(i) + num;
                    i--;
                }
                s = stack.pop();
                while (!stack.peek().equals("]")) {
                    s = s + stack.pop();
                }
                stack.pop();
                String s2 = "";
                for (int j = 0; j < Integer.parseInt(num); j++) {

                    s2 = s2 + s;
                }
                stack.push(s2);
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        System.out.println(res.toString());
    }
}
