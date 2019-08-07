public class 连续乘积最大连续子序列 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] pos = new int[len];
        int[] neg = new int[len];
        pos[0] = nums[0];
        neg[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] == 0) {
                pos[i] = 0;
                neg[i] = 0;
            } else if (nums[i] > 0) {
                pos[i] = pos[i - 1] <= 0 ? nums[i] : nums[i] * pos[i - 1];
                neg[i] = neg[i - 1] <= 0 ? nums[i] * neg[i - 1] : 0;
            } else {
                pos[i] = neg[i - 1] < 0 ? neg[i - 1] * nums[i] : nums[i];
                neg[i] = pos[i - 1] <= 0 ? nums[i] : pos[i - 1] * nums[i];
            }
        }
        int max = nums[0];
        for (int n : pos) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }


    public int maxSubArray(int[] nums) {
        int i, sum = 0, max = Integer.MIN_VALUE;
        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            } else {
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
