import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 全排列 {

    // curSize 表示当前的路径 path 里面有多少个元素
    private void generatePermution(int[] nums, boolean[] visited, int curSize, int len, Stack<Integer> path, List<List<Integer>> res) {
        if (curSize == len) {
            // 此时 path 已经保存了 nums 中的所有数字，已经成为了一个排列
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                path.push(nums[i]);
                visited[i] = true;
                generatePermution(nums, visited, curSize + 1, len, path, res);
                // 刚开始接触回溯算法的时候常常会忽略状态重置
                // 回溯的时候，一定要记得状态重置
                path.pop();
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        if (len == 0) {
            return res;
        }
        generatePermution(nums, used, 0, len, new Stack<>(), res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        全排列 solution = new 全排列();
        List<List<Integer>> permute = solution.permute(nums);
        for (int i = 0; i < permute.size(); i++) {
            System.out.println(permute.get(i));
        }
    }
}
