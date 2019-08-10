import java.util.LinkedList;

public class 子数组最小值之和 {
    public int sumSubarrayMins(int[] A) {
        int len = A.length;
        int[] left = new int[len];
        int[] right = new int[len];
        LinkedList<Integer> stack = new LinkedList<>();
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = len;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = (res + A[i] * (i - left[i]) * (right[i] - i)) % mod;
        }
        return res;
    }

    public int sumSubarrayMins2(int[] A) {
        int len = A.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] s = new int[len];
        int top = -1;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < len; i++) {
            while (top != -1 && A[s[top]] >= A[i]) {
                top--;
            }
            if (top == -1) {
                left[i] = -1;
            } else {
                left[i] = s[top];
            }
            s[++top] = i;
        }
        top = -1;
        for (int i = len - 1; i >= 0; i--) {
            while (top != -1 && A[s[top]] > A[i]) {
                top--;
            }
            if (top == -1) {
                right[i] = len;
            } else {
                right[i] = s[top];
            }
            s[++top] = i;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = (res + A[i] * (i - left[i]) * (right[i] - i)) % mod;
        }
        return res;
    }

    public int sumSubarrayMins3(int[] A) {
        int[] s = new int[A.length];
        int top = -1, res = 0, mid, left, mod = (int) (1e9 + 7);
        for (int right = 0; right <= A.length; right++) {
            while (top != -1 && A[s[top]] > (right == A.length ? 0 : A[right])) {
                mid = s[top--];
                left = top == -1 ? -1 : s[top];
                res = (res + A[mid] * (right - mid) * (mid - left)) % mod;
            }
            s[++top] = right;
        }
        return res;
    }
}
