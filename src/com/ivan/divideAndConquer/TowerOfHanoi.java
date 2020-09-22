package com.ivan.divideAndConquer;

public class TowerOfHanoi {
    public static void main(String[] args) {
        hanoi(7,'A','B','C');
    }
    public static void hanoi(int num,char A,char B,char C){
        if(num == 1){
            System.out.println(A+"--->"+C);
        }else {
            //将A上面的num-1塔片，从A->B
            hanoi(num-1,A,C,B);
            System.out.println(A+"--->"+B);
            //将B上面的所有塔片移动到C上
            hanoi(num-1,B,A,C);
        }
    }
}
