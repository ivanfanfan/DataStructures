package com.ivan.recursion;

public class recursionTest1 {

    public static void main(String[] args) {
        test(5);
    }

    /**
     * 打印问题
     *
     * @param n
     */
    public static void test(int n) {
        if (n > 2) {//递归结束条件
            test(n - 1); //递归
        }
        System.out.println(n);
    }

    /**
     * 阶乘递归
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
