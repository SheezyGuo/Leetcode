import java.util.*;

public class 基本计算器 {
    public final static Map<String, Integer> priority;

    static {
        priority = new HashMap<>();
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("*", 2);
        priority.put("/", 2);
        priority.put("!", 3);
    }

    public static int calculate(String s) {
        s = s.replace(" ", "");
        s = "(" + s + ")";
        List<String> parts = split(s);
        return recur(parts, 0)[0];
    }

    private static int[] recur(List<String> parts, int i) {
        // 忽略 (
        i++;
        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<String> ops = new LinkedList<>();
        while (i < parts.size() && !parts.get(i).equals(")")) {
            // 是操作符
            if (priority.containsKey(parts.get(i))) {
                if (ops.isEmpty() || priority.get(parts.get(i)) > priority.get(ops.peekLast())) {
                    ops.add(parts.get(i));
                } else if (priority.get(ops.peekLast()) != 1 && priority.get(parts.get(i)) <= priority.get(ops.peekLast())) {
                    int num2 = nums.pollLast();
                    int num1 = nums.pollLast();
                    String op = ops.pollLast();
                    int res = operate(num1, num2, op);
                    nums.addLast(res);
                    ops.addLast(parts.get(i));
                } else {
                    ops.addLast(parts.get(i));
                }
            } else if (parts.get(i).equals("(")) {
                int[] ret = recur(parts, i);
                nums.add(ret[0]);
                i = ret[1];

            } else {
                nums.add(Integer.parseInt(parts.get(i)));
            }
            i++;
        }
        if (!ops.isEmpty() && priority.get(ops.peekLast()) == 2) {
            int num2 = nums.pollLast();
            int num1 = nums.pollLast();
            String op = ops.pollLast();
            int res = operate(num1, num2, op);
            nums.addLast(res);
        }
        while (!ops.isEmpty()) {
            int num1 = nums.pollFirst();
            int num2 = nums.pollFirst();
            String op = ops.pollFirst();
            int res = operate(num1, num2, op);
            nums.addFirst(res);
        }
        return new int[]{nums.pop(), i};
    }


    public static int operate(int num1, int num2, String op) {
        int res = 0;
        switch (op) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
        }
        return res;
    }

    private static List<String> split(String s) {
        int i = 0;
        int len = s.length();
        List<String> list = new ArrayList<>();
        while (i < len) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i + 1;
                while (j < len && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                list.add(s.substring(i, j));
                i = j;
            } else {
                list.add(s.substring(i, ++i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String a = "1*2-3/4+5*6-7*8+9/10";
        String b = "282-1*2*13-30-2*2*2/2-95/5*2+55+804+3024";
        String c = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(a));
        System.out.println(calculate(b));
        System.out.println(calculate(c));
    }
}
