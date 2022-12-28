class KthSmallest{
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int right = matrix[n-1][n-1];
        int left = matrix[0][0];
        
        while(left < right){
            int mid = (right-left)/2 + left;
            int num = findLessNum(matrix, mid, n);
            if(num >= k){
                right = mid;
            }else if(num < k){
                left = mid+1;
            }
        }
        return left;
    }

    public int findLessNum(int[][] matrix, int mid, int n){
        int  row = n-1, column = 0;
        int num = 0;
        while(row >= 0 && column <= n-1){
            if(matrix[row][column] <=mid){
                column++;
                num += (row+1);
            }else{
                row--;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        KthSmallest k = new KthSmallest();

        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int kth = 8;
        k.kthSmallest(matrix, kth);
    }
}