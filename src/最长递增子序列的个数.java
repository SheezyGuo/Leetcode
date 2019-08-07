public class 最长递增子序列的个数 {
    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // dp[i] 和 count[i]至少是1,规避越界判断
            dp[i] = 1;
            count[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                // nums[j] >= nums[i] 不会出现更长的子序列
                if (nums[j] < nums[i]) {
                    // 出现更长
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) { //出现等长
                        count[i] += count[j];
                    }
                }
            }
        }
        int maxlen = 0;
        int ct = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > maxlen) {
                maxlen = dp[i];
                ct = count[i];
            } else if (dp[i] == maxlen) {
                ct += count[i];
            }
        }
        return ct;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7, 6}));
        System.out.println(findNumberOfLIS(new int[]{2, 2, 2, 2, 2, 2}));
    }
}
