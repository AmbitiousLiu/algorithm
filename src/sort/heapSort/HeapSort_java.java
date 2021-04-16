package sort.heapSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jleo
 * @date 2020/6/21
 */
public class HeapSort_java {

    public void heapSort(int[] num) {
        // 初始化大顶堆，可以让上一层的数据总是大于下一层，（1/2）nlogn
        for (int i = num.length / 2 - 1; i >= 0; i--) {
            adjust(num, i, num.length);
        }
        // 移走最大元素，继续调整，nlogn
        for (int i = num.length - 1; i >= 0; i--) {
            swap(num, i, 0);
            adjust(num, 0, i);
        }
    }

    public void adjust(int[] num, int index, int length) {
        // 如果左下标出界
        if (index * 2 + 1 >= length) {
            return;
        }
        // 如果右下标没有出界
        if (index * 2 + 2 < length) {
            // 如果右节点大于左节点
            if (num[index * 2 + 2] > num[index * 2 + 1]) {
                // 如果右节点大于此节点
                if (num[index * 2 + 2] > num[index]) {
                    swap(num, index, index * 2 + 2);
                    adjust(num, index * 2 + 2, length);
                }
            } else {
                // 如果左节点大于此节点
                if (num[index * 2 + 1] > num[index]) {
                    swap(num, index, index * 2 + 1);
                    adjust(num, index * 2 + 1, length);
                }
            }
        } else {
            // 如果左节点大于此节点
            if (num[index * 2 + 1] > num[index]) {
                swap(num, index, index * 2 + 1);
                adjust(num, index * 2 + 1, length);
            }
        }
    }

    public void swap(int[] num, int index1, int index2) {
        int temp = num[index1];
        num[index1] = num[index2];
        num[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,6,9,4,2,3,6,7,5};
        new HeapSort_java().heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
