package sort;

import sort.util.ArrayUtil;

/**
 * 希尔排序
 *
 * 升级版本的直接插入排序，也叫做缩小增量排序。这样可以尽可能地接近直接插入排序的最好情况。
 *
 * Created by Zlatan on 19/3/7.
 */
public class ShellSort implements Sort {

    @Override
    public void sortInt(int[] array) {
        validate(array);
        int length = array.length;
        int gap = length >> 1;
        while (gap > 0) {
            for (int i = 0; i < length; i += gap) {
                for (int j = i - gap; j >= 0 && array[j] > array[j + gap]; j -= gap) {
                    ArrayUtil.swap(array, j, j + gap);
                }
            }
            gap--;
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayUtil.testSort(ShellSort.class);
    }
}
