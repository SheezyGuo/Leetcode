import java.util.*;

public class 火车进站 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int nums[] = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        LinkedList<Boolean> list = new LinkedList<>();
        List<String> result = new ArrayList<>();
        recur(nums, 0, 0, 0, list, result);
        Collections.sort(result);
        for (String str : result) {
            for (int i = 0; i < str.length() - 1; i++) {
                System.out.printf("%c ", str.charAt(i));
            }
            System.out.println(str.charAt(str.length() - 1));
        }
    }

    private static void recur(int[] nums, int in, int out, int depth, LinkedList<Boolean> list, List<String> result) {
        if (depth == 2 * nums.length) {
            int[] stack = new int[nums.length];
            int top = -1;
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for (Boolean b : list) {
                if (b) {
                    stack[++top] = nums[i++];
                } else {
                    sb.append(stack[top--]);
                }
            }
            result.add(sb.toString());
            return;
        }
        if (out < in) {
            list.add(false);
            recur(nums, in, out + 1, depth + 1, list, result);
            list.removeLast();
        }
        if (in < nums.length) {
            list.add(true);
            recur(nums, in + 1, out, depth + 1, list, result);
            list.removeLast();
        }
    }
}
