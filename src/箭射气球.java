import java.util.Arrays;
import java.util.Comparator;

public class 箭射气球 {
    public int findMinArrowShots(int[][] points) {
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1];
            }
        };
        Arrays.sort(points, comp);
        int i = 0;
        int sum = 0;
        while (i < points.length) {
            int end = points[i][1];
            int j = i;
            while (j < points.length && points[j][0] <= end) {
                j++;
            }
            sum++;
            i = j;
        }
        return sum;
    }
//
//    public int findMinArrowShots2(int[][] points){
//        Comparator<int[]> comp = new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        };
//        int i=0;
//        while(i<)
//    }
}
