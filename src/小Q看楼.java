import java.util.Arrays;
import java.util.Scanner;

public class 小Q看楼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        int count[] = new int[n];
        Arrays.fill(count, 1);
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int stack[] = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            count[i] += top + 1;
            while (top >= 0 && stack[top] <= nums[i]) {
                top--;
            }
            stack[++top] = nums[i];
        }
        top = -1;
        for (int i = n - 1; i >= 0; i--) {
            count[i] += top + 1;
            while (top >= 0 && stack[top] <= nums[i]) {
                top--;
            }
            stack[++top] = nums[i];
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.printf("%d ", count[i]);
        }
        System.out.println(count[n - 1]);
    }
}
