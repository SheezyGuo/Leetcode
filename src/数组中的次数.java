
public class 数组中的次数 {
    private static int getFirstK(int[] arr, int num) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (arr[mid] > num) {
                j = mid - 1;
            } else if (arr[mid] < num) {
                i = mid + 1;
            } else {
                if (mid > 0 && arr[mid] == arr[mid - 1]) {
                    j = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    private static int getLastK(int[] arr, int num) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (arr[mid] > num) {
                j = mid - 1;
            } else if (arr[mid] < num) {
                i = mid + 1;
            } else {
                if (mid < arr.length - 1 && arr[mid + 1] == arr[mid]) {
                    i = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 7, 7, 7, 8, 8, 8};
        System.out.println(getFirstK(arr, 1));
        System.out.println(getFirstK(arr, 2));
        System.out.println(getFirstK(arr, 3));
        System.out.println(getFirstK(arr, 8));
        System.out.println(getFirstK(arr, 10));
        System.out.println(getFirstK(arr, -1));
        System.out.println(getLastK(arr, 1));
        System.out.println(getLastK(arr, 2));
        System.out.println(getLastK(arr, 3));
        System.out.println(getLastK(arr, 8));
        System.out.println(getLastK(arr, 80));
        System.out.println(getLastK(arr, -1));
    }


}
