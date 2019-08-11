import java.util.Scanner;

public class 抠门老板 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] years = new int[n];
        int[] moneys = new int[n];
        for (int i = 0; i < n; i++) {
            years[i] = sc.nextInt();
            moneys[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (years[i] > years[i - 1] && moneys[i] <= moneys[i - 1]) {
                moneys[i] = moneys[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (years[i] > years[i + 1] && moneys[i] <= moneys[i + 1]) {
                moneys[i] = moneys[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i : moneys) {
            sum += i;
        }
        System.out.println(sum * 100);
    }
}
