//import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Collections;

public class 合理的IP {

    class Solution {
//        public List<String> restoreIpAddresses(String s) {
//            List<String> result = new ArrayList<>();
//            LinkedList<String> parts = new LinkedList<>();
//            backtrace(s, result, parts, 0, 0);
//            return result;
//        }
//
//        private boolean checkPart(String s) {
//            return checkPart(s, 0, s.length());
//        }
//
//        private boolean checkPart(String s, int i) {
//            return checkPart(s, i, s.length());
//        }
//
//        private boolean checkPart(String s, int i, int j) {
//            String sub = s.substring(i, j);
//            if (sub.matches("0.+")) {
//                return false;
//            }
//            int value = Integer.parseInt(sub);
//            return value >= 0 && value <= 255;
//        }
//
//        private void backtrace(String s, List<String> result, LinkedList<String> parts, int start, int depth) {
//            if (parts.size() > 4) {
//                return;
//            }
//            if (parts.size() == 4) {
//                if (start == s.length()) {
//                    result.add(String.join(".", parts));
//                } else {
//                    return;
//                }
//            }
//            for (int i = start; i < Math.min(start + 3, s.length()); i++) {
//                String part = s.substring(start, i + 1);
//                if (!checkPart(part)) {
//                    continue;
//                }
//                parts.addLast(part);
//                backtrace(s, result, parts, i + 1, depth + 1);
//                parts.removeLast();
//            }
//        }


    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] a = new int[nums.length + 1];
        int[] b = new int[nums.length + 1];
        a[0] = 0;
        a[1] = nums[0];
        b[0] = 0;
        b[1] = 0;
        for (int i = 2; i < nums.length; i++) {
            a[i] = Math.max(a[i - 2] + nums[i - 1], a[i - 1]);
        }
        for (int i = 2; i < nums.length + 1; i++) {
            b[i] = Math.max(b[i - 2] + nums[i - 1], b[i - 1]);
        }
        return Math.max(b[nums.length], a[nums.length-1]);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2, 3, 1}));
    }
}
