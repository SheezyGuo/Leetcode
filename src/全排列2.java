import java.util.ArrayList;
import java.util.List;

public class 全排列2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(list);
            return res;
        }
        permute(nums, 0, res);
        return res;
    }

    public void permute(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums)
                list.add(num);
            res.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            boolean isRepeated = false;
            for (int j = start; j < i; j++) {
                if (nums[j] == nums[i]) {
                    isRepeated = true;
                    break;
                }
            }
            if (isRepeated)
                continue;
            swap(nums, start, i);
            permute(nums, start + 1, res);
            swap(nums, start, i);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
