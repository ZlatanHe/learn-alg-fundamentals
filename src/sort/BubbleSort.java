package sort;

import util.ArrayUtil;

/**
 * 冒泡排序，初始指针位在最后一位
 *  每次都对指针位左部子数组做冒泡排序，即看到左边数比右边大就交换，直到指针位或者当前遍历不存在交换为止
 *  某个子序列不存在交换意味着自序列有序
 *
 * Created by Zlatan on 18/1/18.
 */
public class BubbleSort implements Sort {

    @Override
    public void sortInt(int[] array) {
        validate(array);

        for (int end = array.length - 1; end >= 0; end--) {
            boolean exchange = false;
            for (int i = 0; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    ArrayUtil.swap(array, i, i + 1);
                    exchange = true;
                }
            }
            if (!exchange) {
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayUtil.testSort(BubbleSort.class);
    }
}
