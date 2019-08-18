import java.util.Arrays;
import java.util.Scanner;

public class 最长上升子序列 {

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
            }
        }
        System.out.println(maxLen);
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        int[] dp = new int[nums.length];
        // dp[i]表示长度为i的LCS的末尾值
        for (int i = 0; i < nums.length; i++) {
            int pos = -1;
            int a = 0, b = len - 1;
            while (a <= b) {
                int mid = (b - a) / 2 + a;
                if (dp[mid] < nums[i]) {
                    a = mid + 1;
                    pos = mid;
                } else if (dp[mid] > nums[i]) {
                    b = mid - 1;
                } else {
                    pos = mid - 1;
                    break;
                }
            }
            dp[pos + 1] = nums[i];
            if (pos + 1 == len) {
                len++;
            }
        }
        return len;
    }

    public static int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12}));
    }
}
