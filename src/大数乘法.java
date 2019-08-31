public class 大数乘法 {

    private static String multiply(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        int[] S = new int[A.length + B.length];
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                S[i + j + 1] += (A[i] - '0') * (B[j] - '0');
            }
        }
        for (int i = S.length - 1; i >= 1; i--) {
            S[i - 1] += S[i] / 10;
            S[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        int i = S[0] == 0 ? 1 : 0;
        while (i < S.length) {
            sb.append(S[i]);
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("99", "999"));
        System.out.println(multiply("1728357812635870126501256172345", "6871298561826987198236505"));
    }
}
