package leetcode215_KthLargest;

import java.util.Random;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return -1;
        return qsort(nums, 0, nums.length-1, k-1);
    }
    public int qsort(int[] nums, int left, int right, int k){
        //int partitionIndex = (new Random()).nextInt(right-left +1) + left;
        int partitionIndex = right;
        swap(nums, left, partitionIndex);
        int partition = nums[left];
        int leftIndex = left;
        for(int i = left+1; i<=right; i++){
            if(nums[i] >= partition){
                swap(nums, i, ++leftIndex);
            }
        }
        swap(nums, left, leftIndex);

        if(k < leftIndex){
            return qsort(nums, left, leftIndex-1, k);
        }else if(k == leftIndex){
            return nums[leftIndex];
        }else {
            return qsort(nums, leftIndex+1, right, k);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        KthLargest kth = new KthLargest();
        int[] nums = {3,2,1,5,6,4};
        int k = 1;
        System.out.println(kth.findKthLargest(nums, k));
    }
}
