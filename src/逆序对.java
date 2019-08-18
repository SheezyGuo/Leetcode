public class 逆序对 {
    public int InversePairs(int[] array) {
        return InversePairs(array, 0, array.length - 1) % 1000000007;
    }

    public int InversePairs(int[] array, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int mid = (j - i) / 2 + i;
        int ip1 = InversePairs(array, i, mid);
        int ip2 = InversePairs(array, mid + 1, j);
        int merge = merge(array, i, mid, mid + 1, j);
        return (ip1 + ip2 + merge) % 1000000007;
    }

    private int merge(int[] array, int s1, int e1, int s2, int e2) {
        int length = e2 - s1 + 1;
        int[] copy = new int[length];
        int p1 = s1, p2 = s2;
        int count = 0;
        int sum = 0;
        int i = 0;
        while (p1 <= e1 && p2 <= e2) {
            if (array[p1] <= array[p2]) {
                copy[i++] = array[p1++];
                sum += count;
                if (sum > 1000000007) {
                    sum -= 1000000007;
                }
            } else {
                copy[i++] = array[p2++];
                count++;
            }
        }
        while (p1 <= e1) {
            copy[i++] = array[p1++];
            sum += count;
            if (sum > 1000000007) {
                sum -= 1000000007;
            }
        }
        while (p2 <= e2) {
            copy[i++] = array[p2++];
            // count++;
        }
        for (int j = s1; j <= e2; j++) {
            array[j] = copy[j - s1];
        }
        return sum;
    }

    public static void main(String[] args) {
        逆序对 A = new 逆序对();
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        int[] b = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(A.InversePairs(a));
        System.out.println(A.InversePairs(b));
    }
}