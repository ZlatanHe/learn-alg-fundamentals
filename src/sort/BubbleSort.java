package sort;

import sort.util.ArrayUtil;

/**
 * Created by Zlatan on 18/1/18.
 */
public class BubbleSort implements Sort {

    @Override
    public void sortInt(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }

        if (array.length == 1) {
            return;
        }

        for (int end = array.length - 1; end >= 0; end--) {
            for (int i = 0; i < end; i++) {
                if (array[i] > array[i+1]) {
                    ArrayUtil.swap(array, i, i + 1);
                }
            }
        }
    }
}
