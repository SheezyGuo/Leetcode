public class 只出现一次的数字 {
    public static int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int i : nums) {
            for (int k = 0; k < 32; k++) {
                if (((i >>> (31 - k)) & 1) == 1) {
                    count[k]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += count[i] % 3;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-2, -2, 1, 1, -3, 1, -3, -3, -4, -2};
        System.out.println(singleNumber(a));
    }
}
