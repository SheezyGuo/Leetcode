import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 超级丑数 {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        PriorityQueue<Integer> candidates = new PriorityQueue<>();
        int beishu[] = new int[primes.length];
        Arrays.fill(beishu, 1);
        List<Integer> preUgly = new ArrayList<>();
        preUgly.add(1);
        n--;
        for (int i = 0; i < primes.length; i++) {
            candidates.add(primes[i] * beishu[i]);
        }
        while (n-- > 0) {
            int ugly = candidates.peek();
            if (n == 0) {
                return ugly;
            }
            preUgly.add(ugly);
            for (int i = 0; i < primes.length; i++) {
                int bs = findBeishu(preUgly, primes[i], ugly);
                if (bs != beishu[i]) {
                    candidates.remove(primes[i] * beishu[i]);
                    candidates.add(primes[i] * bs);
                    beishu[i] = bs;
                }
            }
        }
        return -1;
    }

    private static int findBeishu(List<Integer> list, int ugly, int cur) {
        int i = 0, j = list.size() - 1;
        int tar = cur % ugly == 0 ? (cur / ugly + 1) : (int) Math.ceil((double) cur / ugly);
        int pos = list.size();
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (list.get(mid) > tar) {
                pos = mid;
                j = mid - 1;
            } else if (list.get(mid) < tar) {
                i = mid + 1;
            } else {
                pos = mid;
                break;
            }
        }
        return list.get(pos);
    }

    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(10000, new int[]{2, 7, 13, 19}));
    }

    public int nthSuperUglyNumber2(int n, int[] primes) {
        if (n == 1) return 1;
        int len = primes.length, j = 0, tmp;
        int ugly[] = new int[n];
        int index[] = new int[len];
        ugly[0] = 1;
        while (j < n - 1) {
            int idx = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                tmp = primes[i] * ugly[index[i]];
                if (tmp == ugly[j]) {
                    index[i]++;
                    tmp = primes[i] * ugly[index[i]];
                }
                if (tmp < min) {
                    min = tmp;
                    idx = i;
                }
            }
            index[idx]++;
            ugly[++j] = min;
        }
        return ugly[n - 1];
    }
}
