package com.ivan.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式求值
 */
public class ReversePolishCalculator {
    public static void main(String[] args) {
        ReversePolishCalculator calculator = new ReversePolishCalculator();
        String reversePolishNotation = "3 4 + 5 * 6 - ";

        List<String> arraylist = calculator.getArraylist(reversePolishNotation);
        System.out.println(arraylist);

        int calculate = calculator.calculate(arraylist);
        System.out.println(calculate);

    }

    /**
     * 遍历list
     * 1.用正则表达式判断数字， 压栈
     * 2.不是数字就进行符号判断 并弹出两个数进行运算
     * @param list
     * @return
     */
    public int calculate(List<String> list){
        Stack<String> stack = new Stack<>();
        int result=0;

        for (String s : list) {
            if(s.matches("\\d+")) { //使用正则表达式匹配数字
                stack.push(s);
            }else {
                switch (s){
                    case "+":
                        result = Integer.parseInt(stack.pop())+Integer.parseInt(stack.pop());
                        break;
                    case "-":
                        int i = Integer.parseInt(stack.pop());
                        int i1 = Integer.parseInt(stack.pop());
                        result = i1 - i;
                        break;
                    case "*":
                        result = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                        break;
                    case "/":
                        i=Integer.parseInt(stack.pop());
                        i1 = Integer.parseInt(stack.pop());
                        result = i1 / i;
                        break;
                }
                stack.push(result+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * 将逆波兰表达式转换成ArrayList
     * @param reversePolishNotation 逆波兰表达式
     * @return ArrayList
     */
    public List<String> getArraylist(String reversePolishNotation){
        String[] s = reversePolishNotation.split(" ");
        List<String> list = new ArrayList<>();
        for (String s1 : s) {
            list.add(s1);
        }
        return list;
    }
}
