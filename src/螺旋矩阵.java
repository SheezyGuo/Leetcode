import java.util.ArrayList;
import java.util.List;

class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix[0] == null || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int h_max = matrix[0].length;
        int v_max = matrix.length - 1;
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>(h_max * v_max);
        while (h_max > 0 && v_max > 0) {
            if (h_max == 0) {
                break;
            }
            for (int n = 0; n < h_max; n++) {
                result.add(matrix[i++][j]);
            }
            i--;
            j++;
            h_max--;
            if (v_max == 0) {
                break;
            }
            for (int n = 0; n < v_max; n++) {
                result.add(matrix[i][j++]);
            }
            i--;
            j--;
            v_max--;
            if (h_max == 0) {
                break;
            }
            for (int n = 0; n < h_max; n++) {
                result.add(matrix[i--][j]);
            }
            i++;
            j--;
            h_max--;
            if (v_max == 0) {
                break;
            }
            for (int n = 0; n < v_max; n++) {
                result.add(matrix[i][j++]);
            }
            i++;
            j++;
            v_max--;
        }
        return result;
    }
}