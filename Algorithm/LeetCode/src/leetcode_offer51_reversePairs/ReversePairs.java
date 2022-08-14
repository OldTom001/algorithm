package leetcode_offer51_reversePairs;

public class ReversePairs {
    int count = 0;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n-1);
        return count;
    }
    public void mergeSort(int[] nums, int l, int r){
        if(l >= r){
            return;
        }
        int m = ((r-l)>>1)+l;
        mergeSort(nums, l, m);
        mergeSort(nums, m+1, r);
        merge(nums, l, m, r);
    }
    public void merge(int[] nums, int l, int m, int r)
    {
        int[] temp = new int[r-l+1];
        int p1 = l, p2 = m+1, i = 0;
        while(p1<=m && p2 <=r){
            if(nums[p1]>nums[p2]){
                temp[i++] = nums[p2++];
            }else{
                temp[i++] = nums[p1++];
                count += p2-(m+1);
            }
        }
        while(p1<=m){
            temp[i++] = nums[p1++];
            count += p2-(m+1);
        }
        while(p2<=r){
            temp[i++] = nums[p2++];
        }
        for(int j = 0; j<=r-l; j++){
            nums[j+l] = temp[j];
        }
    }

    public static void main(String[] args) {

        int[] nums = {7, 5, 6, 4};
        ReversePairs r = new ReversePairs();
        System.out.println(r.reversePairs(nums));
    }
}
