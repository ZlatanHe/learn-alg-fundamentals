package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Zlatan on 18/1/18.
 */
public class TestSort {

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

    public static void main(String[] args) throws Exception {
        int size = 10;
        int maxValue = 100;
        String toBeTestClassName = "sort.BubbleSort";

        int[] array1 = generateRandomArray(size, maxValue);
        int[] array2 = Arrays.copyOf(array1, array1.length);
        int[] array3 = Arrays.copyOf(array1, array1.length);

        Class clazz = Class.forName(toBeTestClassName);
        Sort sort = (Sort) clazz.newInstance();

        correctSort(array1);
        sort.sortInt(array2);

        boolean isCorrect = isEqual(array1, array2);
        System.out.println(isCorrect ? "Correct" : "Fault");
        printArray(array3);
        printArray(array2);
    }
}
