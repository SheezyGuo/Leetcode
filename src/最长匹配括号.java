public class 最长匹配括号 {
    public int longestValidParentheses(String s) {
        int dp[] = new int[s.length()];
        int max = 0;
        // int end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                int len1 = 0, len2 = 0;
                if (i - 1 >= 0 && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    len1 = i - dp[i - 1] - 2 >= 0 ? dp[i - 1] + 2 + dp[i - dp[i - 1] - 2] : dp[i - 1] + 2;
                }
                if (i - 1 >= 0 && s.charAt(i - 1) == '(') {
                    len2 = i - 2 >= 0 ? 2 + dp[i - 2] : 2;
                }
                dp[i] = Math.max(len1, len2);
            }
            if (dp[i] > max) {
                max = dp[i];
                // end = i;
            }
        }
        // System.out.printf("%d %d\n",end+1-max,end);
        // System.out.println(s.substring(end+1-max,end+1));
        return max;
    }

    public int longestValidParentheses2(String s) {
        int[] stack = new int[s.length() + 1];
        int top = -1;
        stack[++top] = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack[++top] = i;
            } else {
                if (top >= 1) {
                    max = Math.max(max, i - stack[--top]);
                } else {
                    stack[top] = i;
                }
            }
        }
        return max;
    }
}
