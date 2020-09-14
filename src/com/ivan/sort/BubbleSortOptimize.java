package com.ivan.sort;

import java.util.Arrays;

/**
 * 冒泡排序  优化
 */
public class BubbleSortOptimize {

    public static void main(String[] args) {
        new BubbleSortOptimize().bubbleSort();
    }
    public void bubbleSort() {
        int[] arr = {-1, 3, 2, 5, 10, -6};
        int temp;
        /**
         * boolean flag = false;
         * 定义指针 观察有没有变化
         */
        boolean flag = false;
        for (int j = 0; j < arr.length - 1; j++) {//这里表示最后一个不用排
            for (int i = 0; i < arr.length - 1 - j; i++) { //已经排好的j个不用再排
                if (arr[i] < arr[i + 1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            if(flag == false){
                break;
            }
        }
        String s = Arrays.toString(arr);
        System.out.println(s);
    }
}
