import java.util.Collections;
import java.util.PriorityQueue;

public class 数据流中位数 {
    private static PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> right = new PriorityQueue<>();
    private static boolean flag = true;

    public void Insert(Integer num) {
        if (flag) {
            if (!right.isEmpty() && num > right.peek()) {
                left.add(right.poll());
                right.add(num);
            } else {
                left.add(num);
            }
            flag = !flag;
        } else {
            if (!left.isEmpty() && num < left.peek()) {
                right.add(left.poll());
                left.add(num);
            } else {
                right.add(num);
            }
            flag = !flag;
        }
    }

    public Double GetMedian() {
        if (left.size() == 1 && right.size() == 0) {
            return (double) left.peek();
        } else if (left.size() == right.size()) {
            return ((double) left.peek() + right.peek()) / 2;
        } else {
            return (double) left.peek();
        }
    }
}
