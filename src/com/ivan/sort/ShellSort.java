package com.ivan.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort();
        System.out.println("--------------");
        shellSort.shellSort1();
    }
    public void shellSort(){
        int[] arr={8,9,1,7,21,3,5,4,6,0,2};
        int temp;
        //按照哪几种跨度分组
        for(int span = arr.length/2; span>0;span /=2){
            //遍历该跨度后面的所有元素 跨度前面的数组 当做每组中已经排好序的参考插入排序
            for(int i = span;i<arr.length;i++){
                //与该组之前的元素(已经排序好的元素)进行比较，不满足条件 调换位置 j-span 表示找该组之前的第一个元素（正向看倒数第一个已经默认排好的元素）
                for (int j = i - span;j>=0;j =j-span){
                    //跟他之前的元素两两比较，为什么不用a[i]>a[j]
                    //答：因为那样永远比较的是j-span 个位置的元素和 i位置互换的元素比较做不到排序效果只能找出一个最小或者最大的
                    //续：使用以下方式比较 就是对之前排好序的元素组中的元素 俩两换位，由于之前的是默认排好序的 所以两两换位满足条件
                    if(arr[j]>arr[j+span]){
                        temp = arr[j];
                        arr[j] = arr[j+span];
                        arr[j+span] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
