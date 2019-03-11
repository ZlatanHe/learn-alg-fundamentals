package dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 *
 * Created by Zlatan on 19/3/11.
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];

        int curBestSum = nums[0]; // 当前元素作为尾元素的子序列可能的最大和
        for(int i = 1; i < nums.length; i++) {
            if (curBestSum > 0) {
                curBestSum += nums[i];
            } else {
                curBestSum = nums[i];
            }

            if (maxSum < curBestSum) {
                maxSum = curBestSum;
            }
        }

        return maxSum;
    }

}
