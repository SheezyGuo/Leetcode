import java.util.Scanner;

public class 秘密通信 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String key = sc.next();
        int bits[] = new int[N];
        int pos = N;
        int len = key.length();
        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = key.charAt(i) - '0';
        }
        int Apos = len;
        int tail = arr[--Apos];
        bits[--pos] = tail;
        while (--pos >= Math.max(N - K, 0)) {
            bits[pos] = tail ^ arr[--Apos];
            tail = arr[Apos];
        }
        if (pos >= 0) {
            tail = bits[pos + K - 1];
            for (int i = pos + 1; i <= pos + K - 2; i++) {
                tail ^= bits[i];
            }
            bits[pos] = tail ^ arr[--Apos];
        }
        while (--pos >= 0) {
            tail = tail ^ bits[pos + K] ^ bits[pos + 1];
            bits[pos] = tail ^ arr[--Apos];
        }
        for (int i : bits) {
            System.out.printf("%d", i);
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String secret = scanner.next();
        char[] result = new char[n];
        result[0] = secret.charAt(0);
        for (int i = 1; i < k; i++) {
            result[i] = xor(secret.charAt(i), secret.charAt(i - 1));
        }
        for (int i = k; i < n; i++) {
            result[i] = xor(xor(secret.charAt(i), secret.charAt(i - 1)), result[i - k]);
        }

        System.out.println(new String(result));
    }

    private static char xor(char a, char b) {
        return a == b ? '0' : '1';
    }
}
