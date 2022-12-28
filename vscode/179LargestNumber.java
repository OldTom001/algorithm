import java.util.Random;

class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        quick(nums, 0, nums.length - 1);
        if (nums[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
   
    public void quick (int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int smallI = l - 1;
        int largeI = r;
        int partitionI = (new Random()).nextInt((r - l + 1)) + l;
        int partitionN = nums[partitionI];
        swap(nums,partitionI,r);
        int i = l;
        while (i < largeI) {
            String s1 = nums[i] + "";
            String s2 = partitionN + "";
            if ((s1 + s2).compareTo((s2 + s1)) <0) { // s1 > s2
                swap(nums, i, --largeI);
            } else if ((s1 + s2).compareTo((s2 + s1)) >0) {
                swap(nums, i++, ++smallI);
            } else {
                i++;
            }
        }
        swap(nums, r, largeI++);
        quick(nums, l, smallI);
        quick(nums, largeI, r);
    }
   
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LargestNumber l = new LargestNumber();
        int[] nums = {3,30,34,5,9};
        System.out.println("最大整数: " + l.largestNumber(nums));
        
        System.out.println(("3"+"5").compareTo("5"+"3"));
        Integer b  = 1;
        System.out.println(b.compareTo(300));


    }
}