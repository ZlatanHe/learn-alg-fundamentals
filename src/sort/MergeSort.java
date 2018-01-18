package sort;

import sort.util.ArrayUtil;

/**
 * Created by Zlatan on 18/1/18.
 */
public class MergeSort implements Sort {

    @Override
    public void sortInt(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }

        if (array.length == 1) {
            return;
        }

        mergeSortProcess(array, 0, array.length - 1);
    }

    private void mergeSortProcess(int[] array, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) >> 1;
        mergeSortProcess(array, left, mid);
        mergeSortProcess(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] result = new int[right - left + 1];
        int l = left, r = mid + 1, i = 0;
        while (l <= mid && r <= right) {
            result[i++] = array[l] < array[r] ? array[l++] : array[r++];
        }
        while (l <= mid) {
            result[i++] = array[l++];
        }
        while (r <= right) {
            result[i++] = array[r++];
        }
        for (int j = left; j <= right; j++) {
            array[j] = result[j-left];
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayUtil.testSort(MergeSort.class);
    }
}
