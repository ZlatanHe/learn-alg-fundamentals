package sort.util;

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
}
