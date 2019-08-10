import javafx.util.converter.BigIntegerStringConverter;

import java.math.BigInteger;
import java.util.Scanner;

public class 绝对值 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigIntegerStringConverter bigIntegerStringConverter = new BigIntegerStringConverter();
        BigInteger zero = bigIntegerStringConverter.fromString("0");
        int n = sc.nextInt();
        BigInteger[] arr = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            arr[i] = bigIntegerStringConverter.fromString(sc.next());
        }
        BigInteger num1 = bigIntegerStringConverter.fromString("0"), num2 = bigIntegerStringConverter.fromString("0");
        BigInteger delta = bigIntegerStringConverter.fromString("10000000000000000000000000000");
        for (int i = 1; i < n; i++) {
            BigInteger d = arr[i].subtract(arr[i - 1]).compareTo(zero) == 1 ? arr[i].subtract(arr[i - 1]) : arr[i - 1].subtract(arr[i]);
            if (d.compareTo(delta) < 0) {
                delta = d;
                num1 = arr[i - 1];
                num2 = arr[i];
            }
        }
        System.out.printf("%s %s", num1.toString(), num2.toString());
    }
}
