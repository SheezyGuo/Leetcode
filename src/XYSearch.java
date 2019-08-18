public class XYSearch {
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 10};
        func(a, 0, a.length - 1, 1);
        func(a, 0, a.length - 1, 2);
        func(a, 0, a.length - 1, 3);
        func(a, 0, a.length - 1, 4);
        func(a, 0, a.length - 1, 5);
        func(a, 0, a.length - 1, 6);
        func(a, 0, a.length - 1, 7);
        func(a, 0, a.length - 1, 8);
        func(a, 0, a.length - 1, 9);
        func(a, 0, a.length - 1, 10);
        func(a, 0, a.length - 1, 11);
    }

    public static void func(int[] a, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] < target) {
                start = mid + 1;
            } else if (a[mid] > target) {
                end = mid - 1;
            } else {
                System.out.println(a[mid]);
                return;
            }
        }
        if (end < 0) {
            System.out.println(-1);
        } else {
            System.out.println(a[end]);
        }

    }

}
