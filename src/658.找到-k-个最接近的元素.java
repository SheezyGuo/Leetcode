import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=658 lang=java
 *
 * [658] 找到 K 个最接近的元素
 *
 * https://leetcode-cn.com/problems/find-k-closest-elements/description/
 *
 * algorithms
 * Medium (42.57%)
 * Likes:    71
 * Dislikes: 0
 * Total Accepted:    7.5K
 * Total Submissions: 17.3K
 * Testcase Example:  '[1,2,3,4,5]\n4\n3'
 *
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x
 * 的差值一样，优先选择数值较小的那个数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 * 
 * 
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,2,3,4,5], k=4, x=-1
 * 输出: [1,2,3,4]
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * k 的值为正数，且总是小于给定排序数组的长度。
 * 数组不为空，且长度不超过 10^4
 * 数组里的每个元素与 x 的绝对值不超过 10^4
 * 
 * 
 * 
 * 
 * 更新(2017/9/19):
 * 这个参数 arr 已经被改变为一个整数数组（而不是整数列表）。 请重新加载代码定义以获取最新更改。
 * 
 */

// @lc code=start
class Solution {
    // 堆方法
    // public List<Integer> findClosestElements(int[] arr, int k, int x) {
    // PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) ->
    // (Math.abs(o2 - x) - Math.abs(o1 - x)));
    // int len = arr.length;
    // for (int i = 0; i < Math.min(len, k); i++) {
    // queue.add(arr[i]);
    // }
    // if (len > k) {
    // for (int i = k; i < arr.length; i++) {
    // if (Math.abs(arr[i] - x) < Math.abs(queue.peek() - x)) {
    // queue.poll();
    // queue.add(arr[i]);
    // }
    // }
    // }
    // ArrayList<Integer> list = new ArrayList<>();
    // while (!queue.isEmpty()) {
    // list.add(queue.poll());
    // }
    // Collections.sort(list);
    // return list;
    // }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0, j = arr.length - 1;
        while (j - i + 1 > k) {
            if (x - arr[i] <= arr[j] - x) {
                j--;
            } else {
                i++;
            }
        }
        List<Integer> list = new ArrayList<>(j - i + 1);
        for (int l = i; l <= j; l++) {
            list.add(arr[l]);
        }
        return list;
    }
}
// @lc code=end
