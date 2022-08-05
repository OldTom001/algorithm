package structure01_heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap01<E extends Comparable<E>> {
    private List<E> heap;
    private int heapSize;

    public MaxHeap01(){
        heap = new ArrayList<E>();
        heapSize = 0;
    }

    public int getHeapSize() {
        return heapSize;
    }

    /**
     * 添加一个元素
     * @param element 元素值
     */
    public void add(E element){
        heap.add(element);
        heapSize++;
        heapInsert(heapSize-1);
    }

    public E getTop(){
        if(heapSize>0){
            return heap.get(0);
        }else{
            return null;
        }
    }
    /**
     * 获取堆顶（最大元素）并删除
     * @return
     */
    public E extractTop(){
        if(heapSize>0){
            swap(0, --heapSize);
            heapify(0);
            return heap.get(heapSize);
        }else{
            return null;
        }
    }

    /**
     * 从下往上堆化
     * @param index
     */
    public void heapInsert(int index){
        while(heap.get(index).compareTo(heap.get((index-1)/2))>0){
            swap(index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    /**
     * 从上往下堆化
     * @param index
     */
    public void heapify(int index){
        int left = index*2+1;
        while (left <heapSize){
            int largest = left+1 <heapSize && heap.get(left+1).compareTo(heap.get(left))>0? left+1: left;
            largest = heap.get(largest).compareTo(heap.get(index)) > 0? largest : index;
            if(largest == index){
                break;
            }
            swap(largest, index);
            index = largest;
            left = index*2+1;
        }

    }
    private void swap( int i, int j){
        Collections.swap(heap, i, j);
    }

    @Test
    public void testMaxHeap(){
        MaxHeap01<Integer> maxHeap = new MaxHeap01<>() ;
        maxHeap.add(123);
        maxHeap.add(99);
        maxHeap.add(666);
        maxHeap.add(78);
        maxHeap.add(999);
        Assert.assertEquals(999, (int)maxHeap.getTop());
        System.out.println("获取最大元素" + maxHeap.getTop());
        int n = maxHeap.getHeapSize() ;
//        maxHeap.extractTop();
        for(int  i = 0 ; i < n - 1; i ++) {
            System.out.println("删除第" + i + "个元素：" + maxHeap.extractTop()) ;
        }
        System.out.println("获取最大元素" + maxHeap.getTop());
    }
}
