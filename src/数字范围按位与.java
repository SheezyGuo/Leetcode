public class 数字范围按位与 {
    public static int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        int res = 0;
        while (m != 0 && n != 0) {
            int base = 1;
            while (base <= m && base != 1 << 31) {
                base <<= 1;
            }
            if (base == 1 << 31) {
                res += 1 << 30;
                m -= 1 << 30;
                n -= 1 << 30;
                continue;
            }
            base >>= 1;
            if ((base << 1) > n) {
                res += base;
            }
            m -= base;
            n -= base;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(2147483646, 2147483647));
    }
}
