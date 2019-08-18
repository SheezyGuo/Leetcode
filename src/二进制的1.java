public class 二进制的1 {
    public static int[] count(int n) {
        int len = 0;
        int m = n;
        while (m > 0) {
            m >>= 1;
            len++;
        }
        int nums[] = new int[len];
        m = n;
        int base = 2;
        int pos = len - 1;
        while (m >= base / 2) {
            nums[pos--] = m / base * base / 2 + Math.max((m % base + 1) - base / 2, 0);
            base <<= 1;
        }
        return nums;
    }

    public static void print(int[] num) {
        int sum = 0;
        for (int i : num) {
            sum += i;
            System.out.printf("%d ", i);
        }
        System.out.println();
        System.out.println(sum);
    }

    public static void main(String[] args) {
        print(count(1));
        print(count(2));
        print(count(4));
        print(count(6));
        print(count(8));
        print(count(13));
        print(count(14));
        print(count(15));
        print(count(1024));
    }
}
