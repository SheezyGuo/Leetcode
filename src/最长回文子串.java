public class 最长回文子串 {
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int maxLen = 1;
        String maxStr = s.substring(0, 1);
        int dp = 1;
        for (int i = 1; i < s.length(); i++) {
            if (i - dp - 1 >= 0 && s.charAt(i - dp - 1) == s.charAt(i)) {
                dp += 2;
            } else if (allSame(s.substring(i - dp, i + 1)) && s.charAt(i + 1 - dp) == s.charAt(i)) {
                dp += 1;
            } else if (s.charAt(i) == s.charAt(i - 1)) {
                dp = 2;
            } else {
                dp = 1;
            }
            if (dp > maxLen) {
                maxLen = dp;
                maxStr = s.substring(i + 1 - dp, i + 1);
            }
        }
        return maxStr;
    }

    public static boolean allSame(String str) {
        char a = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != a) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "bananas";
        longestPalindrome(a);
    }
}
