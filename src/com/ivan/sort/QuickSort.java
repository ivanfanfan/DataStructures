package com.ivan.sort;

import java.util.Arrays;

/**
 * 画图，很简单
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 8, 7, 4, 5, 3, 9};
        int[] quick = quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(quick));
    }

    public static int[] quick(int[] arr, int left, int right) {
        if (left < right) {//递归结束条件
            int partition = partition(arr, left, right);
            quick(arr, left, partition - 1);
            quick(arr, partition + 1, right);
        }
        return arr;
    }

    /**
     * 将小的放在左边，大的放在右边
     */
    public static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;//指针 指向 第一个约定交换的位置
        for (int i = index; i < right; i++) {//i 遍历指针 遍历后面的数
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++; //交换后待交换数的位置得++  画图很明显
            }

        }
        swap(arr,pivot, index - 1);
        return index - 1;

    }

    /**
     * change
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
