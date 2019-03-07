package sort;

import sort.util.ArrayUtil;

/**
 * 选择排序，与插入排序一样的分成已排部分和未排部分，不同的是已排部分中间不会被插入数据
 * 初始指针位是最左位
 *  从指针位向右遍历直到数组末尾，寻找最小数字，与指针位交换位置
 *  指针位向右直到数组末尾，排序结束
 *  时间复杂度O(N^2)
 *  空间复杂O(1)
 * Created by Zlatan on 18/1/18.
 */
public class SelectionSort implements Sort{

    @Override
    public void sortInt(int[] array) {
        validate(array);
        for (int i = 0; i < array.length - 1; i++) {
            // i 为待排部分的开始
            int min = Integer.MAX_VALUE;
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            ArrayUtil.swap(array, i, minIndex);
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayUtil.testSort(SelectionSort.class);
    }
}
