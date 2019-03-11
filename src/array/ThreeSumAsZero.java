package array;

import sort.QuickSort;

import java.util.ArrayList;
import java.util.List;

/**
 * 排序，然后固定一个数num，再使用双指针找到和为-num的两个数的不重复组合
 *
 * 时间复杂度O(NlogN) + O(N) = O(NLogN)
 * Created by Zlatan on 19/3/11.
 */
class ThreeSumAsZero {

    public List<List<Integer>> find(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
//        Arrays.sort(nums);
        new QuickSort().sortInt(nums);
        for (int i = 0; nums[i] <= 0 && i < nums.length - 2; i++) {
            // 从左往右扫，fix一个非正数, 去找所有满足"不小于它的且和为它的相反数"的两个数字的组合
            if (i > 0 && nums[i] == nums[i-1]) {
                // 不要有重复fix同一个数
                continue;
            }
            int target = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // 所有满足"不小于它的且和为它的相反数"的两个数字的组合
                if (nums[left] + nums[right] == target) {
                    res.add(create(nums, i, left, right));
                    while (left < right && nums[left] == nums[left + 1]) {
                        // 不要有重复
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        // 不要有重复
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    private List<Integer> create(int[] nums,
                                 int index1,
                                 int index2,
                                 int index3) {
        List<Integer> res = new ArrayList<>();
        res.add(nums[index1]);
        res.add(nums[index2]);
        res.add(nums[index3]);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumAsZero().find(new int[]{-1, 0, 1, 2, -1, -4}));
    }

}