import java.lang.ProcessBuilder.Redirect;

/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 *
 * https://leetcode-cn.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (41.74%)
 * Likes:    298
 * Dislikes: 0
 * Total Accepted:    52.5K
 * Total Submissions: 125K
 * Testcase Example:  '"2"\n"3"'
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * 示例 1:
 * 
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 
 * 示例 2:
 * 
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 
 * 说明：
 * 
 * 
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] nums1 = new int[num1.length()];
        int[] nums2 = new int[num2.length()];
        int[] res = new int[num1.length() + num2.length()];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = num1.charAt(nums1.length - 1 - i) - '0';
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = num2.charAt(nums2.length - 1 - i) - '0';
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                res[i + j] += nums1[i] * nums2[j];
            }
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < res.length - 1) {
            int cur = res[i];
            res[i + 1] += cur / 10;
            cur %= 10;
            sb.insert(0, cur);
            i++;
        }
        int residual = res[res.length - 1];
        while (residual > 0) {
            sb.insert(0, residual % 10);
            residual /= 10;
        }
        return sb.toString();
    }
}
// @lc code=end
