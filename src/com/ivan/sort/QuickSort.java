package com.ivan.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-1, 3, 2, 5, 10, 2};

        new QuickSort().quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 定义指针指向最左边和最右边
     * @param arr
     * @param left
     * @param right
     */
    public void quickSort(int[] arr, int left, int right) {

        int l = left;
        int r = right;
        int temp;
        int pivot = arr[(right + left) / 2];
        while (l < r) {
            //找值
            while (arr[l] < pivot) {
                l+=1;
            }
            while (arr[r] > pivot) {
                r-=1;
            }
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            //交换完成后如果arr[l]=pivot l++
            if (arr[l] == pivot) {
                r-=1;
            }
            if (arr[r] == pivot) {
                l+=1;
            }
        }
        //如果l == r 必须l++ r-- 否则栈溢出
        if (l == r) {
            l+=1;
            r-=1;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
        System.out.println(Arrays.toString(arr));
    }
}
