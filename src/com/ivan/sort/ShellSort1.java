package com.ivan.sort;

import java.util.Arrays;

public class ShellSort1 {

    public static void main(String[] args) {
        new ShellSort1().shellSort();
    }

    /**
     *
     */

    public void shellSort() {
        int[] arr = {-1, 3, 2, 5, 10, -6};
        //跨度策略
        int j;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //再每种跨度条件中执行插入排序
            //插入排序中进行遍历gap之后的所有元素
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                for (j = i; j >= gap && tmp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
