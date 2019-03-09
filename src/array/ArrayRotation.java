package array;

import util.ArrayUtil;

/**
 * Created by Zlatan on 19/3/8.
 */
public class ArrayRotation {

    public int[] rotate(int[] arr, int d, int method) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("array should not be empty");
        }
        if (arr.length < d) {
            throw new IllegalArgumentException("d is too large");
        }

        if (arr.length == d) {
            return arr;
        }

        System.out.print("before rotate: ");
        ArrayUtil.printArr(arr);
        int[] res;
        switch (method) {
            case 1:
                res = usingTmpArray(arr, d);
                break;
            case 2:
                res = rotateOneByOne(arr, d);
                break;
            case 3:
                res = segmentReverse(arr, d);
                break;
            default:
                throw new IllegalArgumentException("No such method");
        }
        System.out.print("after rotate: ");
        ArrayUtil.printArr(res);
        return res;
    }

    public static void main(String[] args) {
        ArrayRotation arrayRotation = new ArrayRotation();
        arrayRotation.rotate(new int[]{1,2,3,4,5,6,7,8,9,0}, 4, 1);
        arrayRotation.rotate(new int[]{1,2,3,4,5,6,7,8,9,0}, 4, 2);
        arrayRotation.rotate(new int[]{1,2,3,4,5,6,7,8,9,0}, 2, 3);
        arrayRotation.rotate(new int[]{1,2,3,4,5,6,7,8,9,0}, 3, 3);
        arrayRotation.rotate(new int[]{1,2,3,4,5,6,7,8,9,0}, 4, 3);
    }

    /**
     * time complexity: O(N)
     * space complexity: O(d)
     *
     */
    private int[] usingTmpArray(int[] arr, int d) {
        int[] tmp = new int[d];
        for (int i = 0; i < d; i++) {
            tmp[i] = arr[i];
        }
        for (int i = 0; i < arr.length - d; i++) {
            arr[i] = arr[i + d];
        }
        for (int i = 0; i < d; i++) {
            arr[arr.length - d + i] = tmp[i];
        }
        return arr;
    }

    /**
     * time complexity: O(N^2)
     * space complexity: O(1)
     *
     */
    private int[] rotateOneByOne(int[] arr, int d) {
        for (int i = 0 ; i < d; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                ArrayUtil.swap(arr, j, j + 1);
            }
        }
        return arr;
    }

    /**
     * time complexity: O(N)
     * space complexity: O(1)
     */
    private int[] segmentReverse(int[] arr, int d) {
        reverseArr(arr, 0, d - 1);
        reverseArr(arr, d, arr.length - 1);
        reverseArr(arr, 0, arr.length - 1);
        return arr;
    }

    private void reverseArr(int[] arr, int start, int end) {
        int indexSum = start + end;
        int mid = indexSum / 2;
        for (int i = start; i <= mid; i++) {
            ArrayUtil.swap(arr, i, indexSum - i);
        }
    }
}

