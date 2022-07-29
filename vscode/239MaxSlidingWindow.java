import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length-k+1];
        int windMax = Integer.MIN_VALUE;
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i<nums.length; i++){
            if(i<k){
                queue.add(nums[i]);
                if(i == k-1){
                    for(Integer in : queue){
                        windMax = Math.max(windMax, in);
                    }
                    ans[i-k+1] = windMax;
                    windMax = Integer.MIN_VALUE;                   
                }
            }else{
                queue.remove();
                queue.add(nums[i]);
                for(Integer in : queue){
                    windMax = Math.max(windMax, in);
                }
                ans[i-k+1] = windMax;
                windMax = Integer.MIN_VALUE;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        MaxSlidingWindow m = new MaxSlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = m.maxSlidingWindow(nums,k);
        System.out.println(Arrays.toString(ans));
    }
}
