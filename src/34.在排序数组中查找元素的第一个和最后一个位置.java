/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (39.29%)
 * Likes:    369
 * Dislikes: 0
 * Total Accepted:    77.7K
 * Total Submissions: 197.8K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1, middle = -1, pos = -1;
        int[] res = new int[2];
        while (i <= j) {
            middle = i + (j - i) / 2;
            if (nums[middle] == target) {
                pos = middle;
                j = middle - 1;
            } else if (nums[middle] > target) {
                j = middle - 1;
            } else {
                i = middle + 1;
            }
        }
        res[0] = pos;
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            middle = i + (j - i) / 2;
            if (nums[middle] == target) {
                pos = middle;
                i = middle + 1;
            } else if (nums[middle] > target) {
                j = middle - 1;
            } else {
                i = middle + 1;
            }
        }
        res[1] = pos;
        return res;
    }
}
// @lc code=end
