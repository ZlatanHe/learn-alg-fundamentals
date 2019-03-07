package sort;

/**
 * 名称			平均时间复杂度		最差时间复杂度	最好时间复杂度	空间复杂度	稳定
 * 直接插入排序		O(N^2)				O(N^2)			O(N)			O(1)	 Y
 * 希尔排序			O(N^1.3)			O(N)			- 				O(1)	 N
 * 简单选择排序		O(N^2)				O(N^2)			O(N^2)			O(1)	 Y
 * 冒泡排序			O(N^2)				O(N^2)			O(N)			O(1)	 Y
 * 堆排序
 * 快速排序
 * 归并排序			O(NlogN)			O(NlogN)		O(NlogN)		O(N)	 Y
 * 计数排序			O(NlogN)			O(N^2)			O(NlogN)        O(1)     N
 *
 * Created by Zlatan on 18/1/18.
 */
public interface Sort {

    void sortInt(int[] array);

    default void validate(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }

        if (array.length == 1) {
            return;
        }
    }
}
