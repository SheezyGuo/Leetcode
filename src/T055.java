public class T055 {
    public static void main(String[] args) {

    }

    // 完全回溯
    public static boolean backtrace(int[] nums, int pos) {
        if (pos == nums.length - 1) {
            return true;
        }
        int max_step = Math.min(pos + nums[pos], nums.length - 1);
        for (int i = pos + 1; i <= max_step; i++) {
            if (backtrace(nums, i)) {
                return true;
            }
        }
        return false;
    }

    // 


}
