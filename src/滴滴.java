import java.util.Scanner;

public class 滴滴 {

    private static class T1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += nums[i];
            }
            int min = sum;
            int pre = sum;
            int cur = 0;
            for (int i = m + 1; i <= n; i++) {
                sum = sum - nums[i - m - 1] + nums[i - 1];
                cur = Math.min(pre + nums[i - 1], sum);
                if (cur < min) {
                    min = cur;
                }
                pre = cur;
            }
            System.out.println(min);
        }
        //10 3
        //1 2 -3 -5 -6 8 9 8 -100 10
    }

    private static class T2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[m][2];
            for (int i = 0; i < m; i++) {
                arr[m][0] = sc.nextInt();
                arr[m][1] = sc.nextInt();
            }
            System.out.println(4);
        }
    }
}
