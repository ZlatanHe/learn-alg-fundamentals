package sort.util;

import sort.BubbleSort;
import sort.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Zlatan on 18/1/18.
 */
public class ArrayUtil {

    public static void swap(int[] array, int index1, int index2) {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (index1 > array.length - 1 || index2 > array.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    private static void correctSort(int[] arr) {
        Arrays.sort(arr);
    }

    private static int[] generateRandomArray(int size, int maxValue) {
        Random random = new Random();
        int realSize = random.nextInt(size) + 1;
        int[] result = new int[realSize];
        for (int i = 0; i < realSize; i++) {
            result[i] = random.nextInt(maxValue);
        }
        return result;
    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            throw new IllegalArgumentException("无法校验空数组");
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static void printArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    public static void testSort(Class<? extends Sort> clazz) throws Exception {
        int size = 10;
        int maxValue = 100;

        int[] array1 = generateRandomArray(size, maxValue);
        int[] array2 = Arrays.copyOf(array1, array1.length);
        int[] array3 = Arrays.copyOf(array1, array1.length);

        Sort sort = clazz.newInstance();

        correctSort(array1);
        sort.sortInt(array2);

        boolean isCorrect = isEqual(array1, array2);
        System.out.println(isCorrect ? "Correct" : "Fault");
        printArray(array3);
        printArray(array2);
    }
}
