import java.util.Comparator;
import java.util.PriorityQueue;

class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer m1, Integer m2){
                return m1-m2;
            }
        });
        for(int i = 0; i<nums.length; i++){
            if(pq.size() == k){
                if(pq.peek() < nums[i]){
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }else{
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
    
    public static void main(String[] args) {
        FindKthLargest f = new FindKthLargest();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int ans = f.findKthLargest(nums, k);
        System.out.println(ans);
    }
    
}
