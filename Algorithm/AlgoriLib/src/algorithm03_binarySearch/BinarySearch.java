package algorithm03_binarySearch;

public class BinarySearch {
    /**
     * 求数组中第一个等于target的元素的索引(左侧边界)
     * @param nums
     * @param target
     * @return
     */
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; //1

        while (left < right) { // 2
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;//3
            } else if (nums[mid] < target) {
                left = mid + 1;//4
            } else if (nums[mid] > target) {
                right = mid; //5
            }
        }
        // target 比所有数都大
        if (left == nums.length) return -1;
        // 类似之前算法的处理方式
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        int[] nums = {1,2,3,3,3,4,5,6,7,9,9,9,9,9,10};
        int target = 6;
        System.out.println(b.left_bound(nums, target));
    }
}
