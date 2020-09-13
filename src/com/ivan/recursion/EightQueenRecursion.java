package com.ivan.recursion;


/**
 * 八皇后问题 用栈来理解
 * TODO 里面用了回溯算法
 */

public class EightQueenRecursion {
    private final static int max = 8;
    int[] arr = new int[max];
    static int count =0;
    public static void main(String[] args) {
        new EightQueenRecursion().check(0);
        System.out.println(count);
    }

    /**
     *
     * @param n
     */
    public void check(int n){
        if(n == max){
            print();
            count++;
            return;
        }
        /**
         * TODO  这里发生了回溯 如果产生错误 就回溯到上一个方法调用，
         *      如果上一个遍历到i=8 后一个也满足不了 回溯到上上个
         *      在这里 也就是后调用的check中遍历结束 方法出栈 ，然后执行之前的一个方法
         *      之前的方法 i+1 ，然后再方法进栈0-max继续摆放。
         *      如果可以就继续，不行就又回溯上去 i++ （当前栈帧出栈，继续之前一个i++）。
         *      再执行调用摆后面棋子，如果前一个方法到i=max 也就是for结束 也不满足，方法结束出栈 向 上 上 回溯，
         *      也就是后两个方法，在 上 上 个条件下不满足 出栈了。
         *
          */
        for(int i = 0;i <max;i++){
            arr[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }
    }

    /**
     * 判断是否正确
     * arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n]-arr[i]) 表示在同一行或者 同一列 容易理解
     * @param n
     * @return
     */
    private boolean judge(int n){
        for(int i=0;i<n;i++){
            if(arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     */
    public void print(){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"");
        }
        System.out.println();
    }
}
