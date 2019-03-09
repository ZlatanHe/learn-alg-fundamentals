package sort;

import util.ArrayUtil;

import java.util.Random;

/**
 *
 * 快速排序：分治法；对于某个序列找到一个pivot（基准值），比其大的在其右，比其小的在其左，对左右子序列再次快排。
 * Created by Zlatan on 19/3/7.
 */
public class QuickSort implements Sort {

    private static final Random RANDOM = new Random();

    @Override
    public void sortInt(int[] array) {
        validate(array);
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int begin, int end) {
        if (end - begin + 1 <= 1) {
            return;
        }
        int pivotIndx = partition(array, begin, end);
        quickSort(array, begin, pivotIndx);
        if (pivotIndx < end) {
            quickSort(array, pivotIndx + 1, end);
        }
    }

    /**
     * 时间复杂度 O(k), k = end - start + 1
     */
    private int partition(int[] array, int begin, int end) {
        int pivotIdx = RANDOM.nextInt(end - begin + 1) + begin;
        int pivot = array[pivotIdx];
        ArrayUtil.swap(array, begin, pivotIdx);

        int left = begin, right = end;
        while (left != right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] < pivot) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        return left;
    }

    public static void main(String[] args) throws Exception {
        ArrayUtil.testSort(QuickSort.class);
    }
}
