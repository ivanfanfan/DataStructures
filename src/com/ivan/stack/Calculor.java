package com.ivan.stack;

import java.util.Stack;

public class Calculor {

    public static void main(String[] args) {
        Calculor calculor = new Calculor();
        int arithmetic = calculor.arithmetic("3+5*4-2+1");
        System.out.println(arithmetic);
    }

    /**
     * 表达式
     *
     * @param expression
     * @return
     */
    public int arithmetic(String expression) {
        /**
         * 定义两个栈用于存放数据
         */
        Stack<String> numberStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        //定义指针用于扫描
        int index = 0;
        int calculate = 0;
        while (index<expression.length()) {
            //依次得到每一个字符
            char ch = expression.charAt(index);
            System.out.println(ch);
            index ++;
            //判断是否是操作符
            if (isOperator(ch)) {
                //判断栈是否为空
                if (!operatorStack.isEmpty()) {
                    //非空情况下，进行比较---》如果当前操作符小于或者等于栈中操作符 将操作符栈顶pop出一个 在数栈中pop两个数
                    // 进行运算将结果存入数栈中 然后将当前操作符 入栈
                    if (priority(ch) <= priority(operatorStack.peek().charAt(0))) {
                        Integer num1 = Integer.parseInt(numberStack.pop());
                        Integer num2 = Integer.parseInt(numberStack.pop());
                        char c = operatorStack.pop().charAt(0);
                        calculate = calculate(num1, num2, c);
                        numberStack.push(String.valueOf(calculate));
                        operatorStack.push(String.valueOf(ch));
                    } else if (priority(ch) > priority(operatorStack.peek().charAt(0))) {
                        operatorStack.push(String.valueOf(ch));
                    }
                } else {
                    //栈空
                    operatorStack.push(String.valueOf(ch));
                }
            }else {
                numberStack.push(String.valueOf(ch));
            }

        }

        //如果最后栈非空就将符号栈全部弹出并计算
        while (!operatorStack.isEmpty()){
            String pop = operatorStack.pop();
            calculate = calculate(Integer.parseInt(numberStack.pop()), Integer.parseInt(numberStack.pop()), pop.charAt(0));
            numberStack.push(calculate+"");
        }
        return calculate;
    }

    /**
     * 进行计算
     *
     * @param num1
     * @param num2
     * @param operator
     * @return
     */
    public int calculate(int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
        }
        return result;
    }

    /**
     * 判断是否是操作符
     *
     * @param ch
     * @return
     */
    public boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    /**
     * 判断操作符的优先级
     *
     * @param oper Operator
     * @return
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }
}
