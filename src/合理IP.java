import java.util.ArrayList;
import java.util.List;

public class 合理IP {

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        backtrack(res, new char[s.length() + 3], 0, s.toCharArray(), 0, 4);
        return res;
    }

    public void backtrack(List<String> res, char[] temp, int tempIndex, char[] src, int srcIndex, int num) {
        if (tempIndex == temp.length) {
            if (temp[temp.length - 1] != '.') {
                res.add(new String(temp));
            }
            return;
        }

        if (num == 0) {
            return;
        }

        for (int j = 1; j <= 3; j++) {
            // 长度不够直接结束
            if (srcIndex + j > src.length) {
                return;
            }
            if (j > 1) {
                // 0开头
                if (src[srcIndex] == '0') {
                    return;
                }
            }
            // 小于等于255
            if (j == 3) {
                char c1 = src[srcIndex];
                char c2 = src[srcIndex + 1];
                char c3 = src[srcIndex + 2];
                if (c1 > '2' || (c1 == '2' && c2 > '5') || (c1 == '2' && c2 == '5' && c3 > '5')) {
                    return;
                }
            }
            // 标记赋值
            System.arraycopy(src, srcIndex, temp, tempIndex, j);
            tempIndex += j;
            srcIndex += j;
            num--;
            if (num > 0) {
                temp[tempIndex++] = '.';
            }

            // 递归调用
            backtrack(res, temp, tempIndex, src, srcIndex, num);

            // 回溯
            if (num > 0) {
                tempIndex--;
            }
            num++;
            tempIndex -= j;
            srcIndex -= j;
        }
    }

}
