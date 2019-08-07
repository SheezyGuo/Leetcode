import java.util.Arrays;
import java.util.Comparator;

public class 二维数组列排序 {
    public static void main(String[] args) {
        int[][] A = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                A[i][j] = (int) Math.random() * 100;
            }
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(A, comparator);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%d ", A[i][j]);
            }
            System.out.println("");
        }
    }
}
