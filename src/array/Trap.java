package array;

/**
 * 给定n个非负整数表示每个宽度为1的柱子的高度图, 计算按此排列的柱子, 下雨之后能接多少雨水
 *
 * Created by Zlatan on 19/3/11.
 */
class Trap {

    public int trap(int[] height) {

        if(height == null || height.length <= 2) {
            return 0;
        }

        int maxL = height[0]; // 从左往右数的最高峰
        int waterSum = 0; //计算总的水量
        int maxR = 0; // 最高峰值
        int[] maxRs = new int[height.length]; // 从某个坐标到最右点闭区间中的最高峰值
        for(int i = height.length - 1; i >= 0; i--) {
            if(height[i] > maxR) {
                maxRs[i] = maxR = height[i];
            }
            else {
                maxRs[i] = maxR;
            }
        }

        for(int i = 1; i < height.length - 1; i++) {
            if(height[i] > maxL) {
                maxL = height[i];//更新左边最大值
            }
            waterSum += Math.max(Math.min(maxL, maxRs[i]) - height[i], 0);
        }
        return waterSum;
    }

    public static void main(String[] args) {
        System.out.println(new Trap().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new Trap().trap(new int[]{5,2,1,2,1,5}));
    }
}
