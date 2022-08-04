import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        Deque<Integer> stack = new LinkedList<>(); //单调递增栈
        int result = 0;
        int[] minLeftIndex = new int[n];
        int[] minRightIndex = new int[n];
        Arrays.fill(minLeftIndex, -1);
        Arrays.fill(minRightIndex, n);

        //单调栈求第一个右侧较小值
        for(int i = 0; i < n; i++){
            
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                minRightIndex[stack.pop()] = i;
            }
            stack.push(i);
        }
 
        //求第一个左侧较小值
        stack = new LinkedList<>();
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                minLeftIndex[stack.pop()] = i;
            }
            stack.push(i);
        }

        for(int i = 0; i<n; i++){
            result = Math.max(result, heights[i] * (minRightIndex[i]-minLeftIndex[i]-1));
        }
        return result;  
    }
    public static void main(String[] args) {
        LargestRectangleArea l = new LargestRectangleArea();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(l.largestRectangleArea(heights)); 
    }
}