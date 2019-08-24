public class 接雨水 {
    public int trap(int[] height) {
        int len = height.length;
        int[] stack = new int[len];
        int top = -1;
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < len; i++) {
            left[i] = top >= 0 ? stack[0] : 0;
            while (top >= 0 && stack[top] < height[i]) {
                top--;
            }
            stack[++top] = height[i];
        }
        top = -1;
        for (int i = len - 1; i >= 0; i--) {
            right[i] = top >= 0 ? stack[0] : 0;
            while (top >= 0 && stack[top] < height[i]) {
                top--;
            }
            stack[++top] = height[i];
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.max(Math.min(left[i], right[i]) - height[i], 0);
    }
        return sum;
    }
}
