import java.util.Arrays;
import java.util.Scanner;

public class 举重大赛 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int sum = 0;
        int i = 0, j = 0;

        while (i < N) {
            while (j < N && (double) nums[i] / nums[j] >= 0.9) {
                j++;
            }
            sum += j - 1 - i;
            i++;
        }
        System.out.println(sum);
    }
}
