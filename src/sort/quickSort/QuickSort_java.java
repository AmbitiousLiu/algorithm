package sort.quickSort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author jleo
 * @date 2020/5/18
 */
public class QuickSort_java {
    public static void main(String[] args) {
        int[] nums = {8, 5, 1, 9, 4, 2, 3, 6, 7, 0};
        new QuickSort_java().quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int[] num) {
        sort(num, 0, num.length-1);
    }

    public void sort(int[] num, int low, int high) {
        int pivot;
        if(low < high) {
            //将L[low,high]一分为二,算出枢轴值pivot,该值得位置固定,不用再变化
            pivot = partition(num,low,high);

            //对两边的数组分别排序
            sort(num, low, pivot-1);
            sort(num, pivot+1, high);
        }
    }

    //  选择一个枢轴值(关键字) 把它放到某个位置 使其左边的值都比它小 右边的值都比它大
    public int partition(int[] num, int low, int high) {
        int pivotKey;
        pivotKey = num[low];
        //顺序很重要，要先从右边找
        while (low < high) {
            while (low < high && num[high] >= pivotKey) {  //从后往前找到比key小的放到前面去
                high--;
            }
            swap(num, low, high);
            while (low < high && num[low] <= pivotKey) {  //从前往后找到比key大的 放到后面去
                low++;
            }
            swap(num, low, high);
        } //遍历所有记录  low的位置即为 key所在位置, 且固定,不用再改变
        return low;
    }

    //交换数组的两个位置
    public void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
