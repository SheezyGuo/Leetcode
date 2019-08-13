import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                if (nums[i] > 0) {
                    break;
                }
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        if (nums[i] + nums[j] > 0) {
                            break;
                        }
                        int tar = 0 - nums[i] - nums[j];
                        int k = j + 1;
                        int l = nums.length - 1;
                        while (k <= l) {
                            int mid = (l - k) / 2 + k;
                            if (nums[mid] < tar) {
                                k = mid + 1;
                            } else if (nums[mid] > tar) {
                                l = mid - 1;
                            } else {
                                res.add(Arrays.asList(nums[i], nums[j], nums[mid]));
                                break;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        //List<List<Integer>>声明了res的结构
        //new ArrayList<>();定义了res的外部结构最外层是list
        List<List<Integer>> res = new ArrayList<>();

        int len = nums.length;
        if (len < 3) return res; //spec

        Arrays.sort(nums); //排序(sum小了的话找大的更有效的接近目标)
        if (nums[0] > 0 || (nums[0] == 0 && nums[2] > 0) || nums[len - 1] < 0) return res; //[]

        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) break; //my nums[i] > 0说明后面的都不可能使得sum=0
            if (nums[i] == 0 && nums[i + 1] == 0 && nums[i + 2] == 0) {
                res.add(Arrays.asList(0, 0, 0));
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重
            int L = i + 1, R = len - 1;
            while (L < R) { //两指针相遇停止循环寻找
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; //去重
                    //L < R不加会越界，第一次报错的原因int[] nums = {0, 0, 0};
                    while (L < R && nums[R] == nums[R - 1]) R--; //去重
                    L++;
                    R--;
                } else if (sum < 0) {
                    //while (L < R && nums[L] == nums[L+1]) L++; //去重
                    L++;
                } else {
                    //while (L < R && nums[R] == nums[R-1]) R--; //去重
                    R--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        int i, j, k, target;
        List<List<Integer>> list = new ArrayList<>();
        for (k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k == 0 || nums[k - 1] < nums[k]) {
                target = 0 - nums[k];
                i = k + 1;
                j = nums.length - 1;
                while (i < j) {
                    if (nums[i] + nums[j] == target) {
                        list.add(Arrays.asList(nums[k], nums[i], nums[j]));
                        do {
                            i++;
                        } while (i < j && nums[i] == nums[i - 1]);
                        do {
                            j--;
                        } while (i < j && nums[j + 1] == nums[j]);
                    } else if (nums[i] + nums[j] > target) {
                        do {
                            j--;
                        } while (i < j && nums[j + 1] == nums[j]);
                    } else {
                        do {
                            i++;
                        } while (i < j && nums[i - 1] == nums[i]);
                    }
                }
            }
        }
        return list;
    }
}
