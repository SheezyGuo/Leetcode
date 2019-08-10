import java.util.Scanner;

public class 特殊的测试 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int res = test(nums, i);
            if (res < min) {
                min = res;
            }
        }
        System.out.println(min);
    }

    private static int test(int[] nums, int pos) {
        int sum = 0;
        int pre = nums[0];
        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        for (int i = 1; i < pos; i++) {
            if (nums[i] <= pre) {
                sum += pre + 1 - nums[i];
                pre++;
            } else {
                pre = nums[i];
            }
        }
        if (pos != 0) {
            left = pre;
        }
        pre = nums[nums.length - 1];
        for (int i = nums.length - 2; i > pos; i--) {
            if (nums[i] <= pre) {
                sum += pre + 1 - nums[i];
                pre++;
            } else {
                pre = nums[i];
            }
        }
        if (pos != nums.length - 1) {
            right = pre;
        }
        int mid = Math.max(Math.max(left + 1, right + 1), nums[pos]);
        sum += mid - nums[pos];
        return sum;
    }
}
