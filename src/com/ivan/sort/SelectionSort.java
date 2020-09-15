package com.ivan.sort;

import java.util.Arrays;

/**
 * 选择排序基本思想：
 * 找出最小的数放在第一个位置，
 * 从剩余元素 找出次小的数 放再第二个位置。
 * 。。。
 */
public class SelectionSort {
    public static void main(String[] args) {
        new SelectionSort().selection();
    }

    public void selection() {
        int[] arr = {-1, 3, 2, 5, 10, -6};
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
