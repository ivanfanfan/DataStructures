package com.ivan.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToReversePolishNotation {

    public static void main(String[] args) {
        ToReversePolishNotation tonifixExpressionNotation = new ToReversePolishNotation();
        List<String> arraylist = tonifixExpressionNotation.getArraylist("1+5*4-2+6+((3+5)-2)");
        System.out.println(arraylist);
        List<String> strings = tonifixExpressionNotation.parseReversePolishNotation(arraylist);
        System.out.println(strings);
    }


    /**
     * 将中缀表达式转换成后缀表达式
     * @param list 中缀表达式
     * @return 后缀表达式
     */
    public List<String> parseReversePolishNotation(List<String> list){
        Stack<String> stack = new Stack<>(); //符号栈
        List<String> ls = new ArrayList<>(); //存储结果
        for (String s : list) {
            if(s.matches("\\d+")){
                ls.add(s);
            }else if (s.equals(")")){
               while (!stack.peek().equals("(")){
                   ls.add(stack.pop());
               }
               stack.pop();//拿出左括号
            }else if (s.equals("(")||stack.isEmpty()){
                stack.push(s);
            }else {
                //TODO 优先级比较 枚举类 为什么要用这种优先级？
                while (!stack.isEmpty() && Operate.getValue(stack.peek()) >= Operate.getValue(s)){
                    ls.add(stack.pop());
                }
                stack.push(s);  //最后一个不用比较直接入栈
            }

        }
        /**
         * 扫描结束清空栈 加入list
         */
        while(!stack.isEmpty()){
            ls.add(stack.pop());
        }

        return ls;
    }

    /**
     * 中缀表达式存储到ArrayList中
     *
     * @param nifixExpression
     * @return
     */
    public List<String> getArraylist(String nifixExpression) {
        List<String> list = new ArrayList<>();
        String key = "";
        for (int i = 0; i < nifixExpression.length(); i++) {
            /**
             * if 是数字就就行拼接
             *      if下一位不是数字
             *          就将上次拼接的数字加入list
             *          key置空
             *          将下一位字符加入
             * else
             *      不是数字直接加入
             */
            if (nifixExpression.charAt(i) <= 57 && nifixExpression.charAt(i) >= 48) {
                key += nifixExpression.charAt(i);
                if (nifixExpression.charAt(i + 1) > 57 || nifixExpression.charAt(i + 1) < 48) {
                    list.add(key);
                    key = "";
                    list.add(nifixExpression.charAt(++i) + "");  //注意这里必须是 ++i 不是i++
                }
            } else {
                list.add("" + nifixExpression.charAt(i));
            }
        }
        return list;
    }
}
/**
 * 可以定义枚举类， 也可以定义基本类
 * //TODO 枚举
 */
class Operate{
    private final static int ADD = 1;
    private final static int SUB = 1;
    private final static int MUL = 2;
    private final static int DIV = 2;
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不合法");
                break;
        }
        return result;
    }
}
