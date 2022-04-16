import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        

        int len = nums.length;
        
        for(int first = 0; first<len-2; first++){
            if(first!=0&&nums[first]==nums[first-1]){
                continue;
            }
            int second = first + 1;
            int third = len-1;
            while(second < third){
                if(nums[first]+nums[second]+nums[third]==0){
                    List<Integer> subList = new ArrayList<Integer>();
                    subList.add(nums[first]);
                    subList.add(nums[second]);
                    subList.add(nums[third]);
                    list.add(subList);
                    int num_second = nums[second];
                    while(nums[second]==num_second && second<third){
                        second++;
                    }
                }else if(nums[first]+nums[second]+nums[third]<0){
                    int num_second = nums[second];
                    while(nums[second]==num_second && second<third){
                        second++;
                    }

                }else{
                    int num_third = nums[third];
                    while(nums[third]==num_third && third>second){
                        third--;
                    }
                }
            }
        }
        return list;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> getThreeSum = new ArrayList<List<Integer>>();

        int[] nums = {0,0,0,0};

        getThreeSum = solution.threeSum(nums);

        System.out.println(getThreeSum);
    }
}