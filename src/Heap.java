public class Heap {
    private int[] data;
    private int length;

    public Heap(int[] nums) {
        this.data = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            data[i + 1] = nums[i];
        }
        this.length = data.length;
        init();
    }

    public void downshift(int pos) {
        if (pos < 1 || pos >= length) {
            return;
        }
        int temp = data[pos];
        while (pos * 2 <= length - 1) {
            int lchild = pos * 2;
            int rchild = lchild == length - 1 ? lchild : lchild + 1;
            int bigger = data[lchild] < data[rchild] ? rchild : lchild;
            if (temp < data[bigger]) {
                data[pos] = data[bigger];
                pos = bigger;
            } else {
                break;
            }
        }
        data[pos] = temp;
    }

    public void upshift(int pos) {
        if (pos < 1 || pos > length) {
            return;
        }
        int temp = data[pos];
        while (pos > 0) {
            int parent = pos / 2;
            if (temp < data[parent]) {
                data[pos] = data[parent];
                pos = parent;
            }
        }
        data[pos] = temp;
    }

    public void init() {
        for (int k = length / 2; k > 0; k--) {
            downshift(k);
        }
    }

    public void swap(int i, int j) {
        data[0] = data[i];
        data[i] = data[j];
        data[j] = data[0];
    }

    public void sort() {
        for (int i = length - 1; i >= 1; i--) {
            swap(i, 1);
            length--;
            downshift(1);
        }
    }

    public static void main(String[] args) {
        int data[] = new int[]{10, 2, 5, 12, 5, 6, 1, 23, 65, 1};
        Heap heap = new Heap(data);
        heap.sort();
        for (int i = 1; i < heap.data.length; i++) {
            System.out.println(heap.data[i]);
        }
    }


}
