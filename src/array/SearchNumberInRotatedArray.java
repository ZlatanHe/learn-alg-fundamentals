package array;

/**
 * 搜索旋转排序数组
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * Created by Zlatan on 19/3/11.
 */
class SearchNumberInRotatedArray {

    // 时间复杂度O(logN) + O(logN) = O(logN)
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        // 先找到旋转点：真正的开头 O(logN)
        int left = 0;
        int right = len - 1;
        int rotationPointer = 0;
        if (nums[left] > nums[right]) {
            while (left <= right) {
                if (nums[left] <= nums[right]) {
                    rotationPointer = left;
                } else {
                    rotationPointer = (left + right) >> 1;
                }
                if (nums[rotationPointer] <= nums[right]
                        && (nums[rotationPointer] < nums[rotationPointer - 1])) {
                    break;
                }
                if (nums[rotationPointer] <= nums[right]) {
                    right = rotationPointer - 1;
                } else {
                    left = rotationPointer + 1;
                }
            }
        }
        // 开始二分查找 O(logN)
        left = 0;
        right = len - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            int index = mid + rotationPointer;
            if (index >= len) {
                index -= len;
            }
            if (nums[index] == target) {
                return index;
            }
            if (target > nums[index]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        return search2(nums, target, 0, nums.length - 1);
    }

    private int search2(int[] nums, int target, int start, int end) {
        if (end - start + 1 <= 0) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] >= nums[start]) {
            // mid在有序部分
            int index = search2(nums, target, start, mid - 1);
            return index == -1 ? search2(nums, target, mid + 1, end) : index;
        } else {
            // mid在无序部分
            int index = search2(nums, target, mid + 1, end);
            return index == -1 ? search2(nums, target, start, mid - 1) : index;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SearchNumberInRotatedArray().search2(new int[]{1,2,3,4,5}, 4)); // 3
        System.out.println(new SearchNumberInRotatedArray().search2(new int[] {3, 1}, 1)); // 1
        System.out.println(new SearchNumberInRotatedArray().search2(new int[]{4,5,6,7,0,1,2}, 7)); // 3
        System.out.println(new SearchNumberInRotatedArray().search2(new int[]{4,5,6,7,0}, 6)); // 2
        System.out.println(new SearchNumberInRotatedArray().search2(new int[]{5,1,2,3,4}, 1)); // 1
    }
}
