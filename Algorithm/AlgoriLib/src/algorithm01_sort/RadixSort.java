package algorithm01_sort;

public class RadixSort {
    //基数排序方法
    public static void radixSort(int[] arr) {
        //1、得到数组中最大数的位数
        int max = arr[0];
        for (int l = 0; l < arr.length; l++) {
            if (arr[l] > max){
                max = arr[l];
            }
        }
        //等到最大数是几位数
        int maxLength = (max + "").length();

        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //说明
        //1、二维数组包含10个一维数组
        //2、为了防止在放入数的时候，数据溢出，则每个一维数组（桶），大小定义为arr.length
        //3、明确，基数排序是使用空间换取时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记住每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录每个桶依次放入的数据个数
        //比如bucketElementCounts[0]，记录的就是bucket【0】桶的放入数据个数

        int[] bucketElementCounts = new int[10];
        for (int l = 0,n=1; l < maxLength; l++,n *= 10) { //l控制数据位, 按照各位十位百位...依次处理. n是取模时的分母, 若取个位, 则n=1, digitOfElement=arr[i] / n % 10
            for (int i = 0; i < arr.length ; i++) {
                //取出每个元素的个位的值
                int digitOfElement = arr[i] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                bucketElementCounts[digitOfElement]++;
            }
            //一位操作完毕, 可以取数了
            int index = 0;
            for (int j = 0; j < bucketElementCounts.length; j++) { //基数0~9依次取, 实现按某一位排序
                if (bucketElementCounts[j]!=0){
                    for (int k = 0;k < bucketElementCounts[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
                //第一轮处理后，需要将每个bucketElementCounts[k]=0!!!!
                bucketElementCounts[j] = 0;
            }
        }
    }
}
