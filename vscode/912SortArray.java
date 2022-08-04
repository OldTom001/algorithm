class SortArray {
    public int[] sortArray(int[] nums) {
        
        int n = nums.length;
        quickSort2(nums, 0, n-1);
        return nums;
    }
    //快排1.0
    public void quickSort1(int[] nums, int l, int r){
        if(l >= r){ //注意这里必须是l>=r, 当partition是整个数组最小值时, r会传入-1
            return;
        }
        int partition = nums[r];
        int lessIndex = l-1; 

        for(int i = l; i< r; i++){
            if(nums[i] <= partition){
                lessIndex++;
                swap(nums, i, lessIndex);
            }
        }
        int pos = ++lessIndex; //下一个划分点是小于区的下一个元素
        swap(nums, r, pos);
        quickSort1(nums, l, pos-1);
        quickSort1(nums, pos+1, r);
    }

    public void quickSort2(int[] nums, int l, int r){
        if(l >= r){ //注意这里必须是l>=r, 当partition是整个数组最小值时, r会传入-1
            return;
        }
        int partition = nums[r];
        int lessIndex = l-1, largerIndex = r;
        int i = l;
        while(i < largerIndex){
            if(nums[i] < partition){
                lessIndex++;
                swap(nums, i, lessIndex);
                i++;
            }else if(nums[i] > partition){
                largerIndex--;
                swap(nums, i, largerIndex);
            }else{
                i++;
            }
        }
        swap(nums, r, largerIndex);
        largerIndex++;
        int pos1 = lessIndex; 
        int pos2 = largerIndex;
        quickSort2(nums, l, pos1);
        quickSort2(nums, pos2, r);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        SortArray s = new SortArray();
        int[] nums = {5,1,1,2,0,0};
        s.sortArray(nums);
        for(int a : nums){
            System.out.println(a);
        }
    }
    
}
