import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 第K个排列 {

    private static Map<Integer, Integer> map = new HashMap<>();

    public String getPermutation(int n, int k) {
        char[] res = new char[n];
        LinkedList<Integer> list = new LinkedList<>();
        int dep = 0;
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        recur(list, res, k, 0);
        return new String(res);
    }

    private void recur(LinkedList<Integer> list, char[] res, int n, int dep) {
        if (dep == res.length) {
            return;
        }
        int num = get(res.length - dep - 1);
        if (n <= num) {
            res[dep] = (char) (list.pollFirst() + '0');
            recur(list, res, n, dep + 1);
        } else {
            int count = (n - 1) / num;
            int mod = n - count * num;
            int val = list.remove(count);
            res[dep] = (char) (val + '0');
            recur(list, res, mod, dep + 1);
        }
    }

    private int get(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            map.put(1, 1);
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int res = n * get(n - 1);
            map.put(n, res);
            return res;
        }
    }
}
