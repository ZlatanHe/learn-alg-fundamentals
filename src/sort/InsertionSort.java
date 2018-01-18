package sort;

import sort.util.ArrayUtil;

/**
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
