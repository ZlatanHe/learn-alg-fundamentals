package sort;

import util.ArrayUtil;

import java.util.Arrays;

/**
 * Created by Zlatan on 18/1/18.
 */
public class MergeSort implements Sort {

    @Override
    public void sortInt(int[] array) {
        validate(array);
        int[] newArr = mergeSort(array, 0, array.length);
        for (int i = 0 ; i < array.length; i++) {
            array[i] = newArr[i];
        }
    }

    private int[] mergeSort(int[] array, int start, int end) {
        int length = end - start;
        if (length == 1) {
            return Arrays.copyOfRange(array, start, end);
        }
        int mid = length / 2 + start;
        int[] left = mergeSort(array, start, mid);
        int[] right = mergeSort(array, mid, end);
        int[] res = new int[length];
        int leftIdx = 0;
        int rightIdx = 0;
        for (int i = 0; i < length; i++) {
            int leftVal = leftIdx < left.length ? left[leftIdx] : Integer.MAX_VALUE;
            int rightVal = rightIdx < right.length ? right[rightIdx] : Integer.MAX_VALUE;
            if (leftVal < rightVal) {
                res[i] = leftVal;
                leftIdx++;
            } else {
                res[i] = rightVal;
                rightIdx++;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        ArrayUtil.testSort(MergeSort.class);
    }
}
