package com.ivan.sort;

import java.util.Arrays;

/**
 * 插入排序， 如果排序的数列已经排好的数有很多，那么用插入排序的效率会大大提升
 * 因为他几乎不会进入二层循环
 */
public class InsertSort {
    public static void main(String[] args) {
        new InsertSort().insertSort();
    }

    /**
     * 定义变量记录要进行排序的元素 insertVal
     * 定义指针指向前面排好序元素的最高位，进行挨个比较 insertIndex = i -1; i是当前要插入的元素 最高位当然就是i-1
     * 定义循环 循环比较待插入的元素和已经排好序的各个元素
     * 循环条件： insertIndex>=0  =0的时候就是已经比较到了第一个元素arr[0]
     * inserVal < arr[insertIndex]  排序方式
     * 循环操作：
     * 如果不满足条件，该比较元素向后移动一位 arr[insertIndex+1] = arr[insertIndex]
     * 然后比较后面一个 insertIndex--
     * 循环结束 将要排序的元素 插入到当前位置的后一个位置，所以就是arr[insertIndex+1] = insertVal;
     */
    public void insertSort() {
        int[] arr = {-1, 3, 2, 5, 10, -6};
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];//
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 算法和数据结构中的代码
     * 定义指针指向未参与排序的序列 第一位进行遍历  for (int p = 1; p < arr.length; p++) {
     * 定义tmp变量 记录当前所进行排序的元素，int tmp = arr[p];
     * 从右到左开始遍历已经排序好的序列 并进行判断是否满足当前要求  for (j = p;j>=1&&tmp<arr[j-1];j-- )
     * 如果满足就将所进行比较的元素向后移动一位 arr[j] = arr[j-1] 不满足就说明找到了当前位置 记录在j中
     * 将tmp赋值给arr[j]  arr[j] = tmp;
     *
     * 循环以上策略直到结束。
     */
    public void insertSort1() {
        int[] arr = {-1, 3, 2, 5, 10, -6};
        int j;
        for (int p = 1; p < arr.length; p++) {
            int tmp = arr[p];
            for (j = p;j>=1&&tmp<arr[j-1];j-- ){
                arr[j]=arr[j-1];
            }
            arr[j] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
