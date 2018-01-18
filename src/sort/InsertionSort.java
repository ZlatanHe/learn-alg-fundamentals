package sort;

import sort.util.ArrayUtil;

/**
 * 插入排序，将数组分为已排部分和未排部分，初始已排部分为最左位，指针位即未排部分的最左位
 *  将指针位的数字插入已排部分中的合适位置
 *  指针位向右直至数组末尾，完成排序
 * Created by Zlatan on 18/1/18.
 */
public class InsertionSort implements Sort {

    @Override
    public void sortInt(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }

        if (array.length == 1) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                ArrayUtil.swap(array, j, j + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayUtil.testSort(InsertionSort.class);
    }
}
