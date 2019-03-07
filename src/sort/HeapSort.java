package sort;

import sort.util.ArrayUtil;

/**
 * Created by Zlatan on 19/3/7.
 */
public class HeapSort implements Sort {

    @Override
    public void sortInt(int[] array) {
        validate(array);
        int length = array.length;
        while (length > 1) {
            heapSort(array, length);
            ArrayUtil.swap(array, 0, length - 1);
            length--;
        }
    }

    private void heapSort(int[] array, int length) {
        int lastIndex = length - 1;
        //从lastIndex处的节点的父节点开始
        for(int i = (lastIndex - 1) / 2 ; i >= 0; i--) {

            //保存正在判断的节点
            int k = i;

            //如果当前k节点的左子节点存在
            while(2*k+1 <= lastIndex) {

                //k节点的左子节点的索引为2*k+1
                int leftIndex = 2*k+1;
                //biggerIndex记录元素值较大的那个节点的索引
                int biggerIndex = leftIndex;
                //如果leftIndex小于lastIndex, 说明右子节点存在
                if(leftIndex < lastIndex) {
                    int rightIndex = leftIndex+1;
                    //如果右子节点的值较大
                    if(array[leftIndex] < array[rightIndex]) {
                        //biggerIndex指向左右子节点中较大的那个
                        biggerIndex = rightIndex;
                    }
                }

                //如果k节点的值小于biggerIndex节点的值,交换
                if(array[k] >= array[biggerIndex]) {
                    break;
                } else {
                    ArrayUtil.swap(array, k, biggerIndex);
                    k = biggerIndex;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayUtil.testSort(HeapSort.class);
    }
}
